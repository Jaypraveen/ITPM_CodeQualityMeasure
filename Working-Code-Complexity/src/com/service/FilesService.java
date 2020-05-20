package com.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import com.model.Files;

public class FilesService {
	
	Files files = new Files();
	
	public static String readFiles(String path) throws FileNotFoundException {
		
		System.out.println(path + " in filesServlet");
		File file = new File(path);
		
		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
		
		String code = "Code";
		try {
			while (( code  = bufferedReader.readLine()) != null) {
				//System.out.println(st);

				//PrintWriter printWriter = response.getWriter();
				//printWriter.println(text);
				System.out.println(code);
			}
			//files.setCode(code);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return code;
		
	}
	
	
	
}
