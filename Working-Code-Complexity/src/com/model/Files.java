package com.model;

public class Files {

	private String path;
	private String code;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
		System.out.println(path + " in files - setPath");
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
		System.out.println(code + " in files - setCode");
	}

	public Files(String path, String code) {
		super();
		this.path = path;
		this.code = code;
	}

	public Files() {
		super();
		// TODO Auto-generated constructor stub
	}

}
