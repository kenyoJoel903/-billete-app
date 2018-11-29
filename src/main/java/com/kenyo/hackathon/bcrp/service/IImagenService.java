package com.kenyo.hackathon.bcrp.service;

import java.io.InputStream;

public interface IImagenService {
	
	String proccesImage(InputStream iStream, String extension);
	
	String proccesImage2(InputStream iStream, String extension);
	
	String uploadImage(InputStream iStream, String extension);

}
