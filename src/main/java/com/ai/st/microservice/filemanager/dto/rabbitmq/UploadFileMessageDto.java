package com.ai.st.microservice.filemanager.dto.rabbitmq;

import java.io.Serializable;

public class UploadFileMessageDto implements Serializable {

	private static final long serialVersionUID = 3050930525504636650L;

	private String filename;
	private String namespace;
	private String driver;
	private byte[] file;
	
	public UploadFileMessageDto() {

	}

	public UploadFileMessageDto(String filename, String namespace, String driver, byte[] file) {
		this.filename = filename;
		this.namespace = namespace;
		this.driver = driver;
		this.file = file;
	}

	public String getFilename() {
		return filename;
	}

	public String getNamespace() {
		return namespace;
	}

	public String getDriver() {
		return driver;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

}
