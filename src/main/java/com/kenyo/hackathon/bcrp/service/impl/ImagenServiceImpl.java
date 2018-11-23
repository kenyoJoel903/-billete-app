package com.kenyo.hackathon.bcrp.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.time.Instant;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kenyo.hackathon.bcrp.service.IImagenService;
import com.kenyo.hackathon.bcrp.util.HackathonUtil;


@Service
public class ImagenServiceImpl implements IImagenService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private HackathonUtil util;

	@Override
	public String proccesImage(InputStream iStream, String extension) {
		logger.info("[INicio] proccesImage " + extension);
		long startTime = Instant.now().toEpochMilli();
		String path = util.getPath() + "/" + startTime + "." + extension;
		logger.info("[INicio] proccesImage " + path);
		if(saveImageInDirectory(iStream, path)) {
			StringBuffer output = new StringBuffer();
			Process p;
			try {
				p = Runtime.getRuntime().exec("tesseract "+ path + " stdout");
				p.waitFor();
				BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
				String line = "";			
				while ((line = reader.readLine())!= null) {
					output.append(line + "\n");
				}
				return output.toString();
			} catch (Exception e) {
				logger.error("error", e);
				return null;
			}
			
		}
		return null;
	}
	
	private boolean saveImageInDirectory(InputStream in, String path) {
		OutputStream os;
		try {
			os = new FileOutputStream(new File(path));
			byte[] buffer = new byte[1024];
			int bytes = 0;
			while ((bytes = in.read(buffer)) != -1) {
				os.write(buffer, 0, bytes);
			}
			os.close();
			in.close();
			return true;
		} catch (Exception e) {
			logger.error("Error",e);
			return false;
		}
	}

}
