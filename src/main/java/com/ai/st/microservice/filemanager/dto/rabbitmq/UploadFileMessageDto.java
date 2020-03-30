package com.ai.st.microservice.filemanager.dto.rabbitmq;

import java.io.Serializable;

public class UploadFileMessageDto implements Serializable {

	private static final long serialVersionUID = 3050930525504636650L;

	private String filename;
	private String namespace;
	private String driver;
	private byte[] file;
	private String filenameZip;
	private boolean zip;
	
	public UploadFileMessageDto() {
		this.zip = true;
	}

	public UploadFileMessageDto(String filename, String namespace, String driver, byte[] file, String filenameZip, boolean zip) {
		this.filename = filename;
		this.namespace = namespace;
		this.driver = driver;
		this.file = file;
		this.filenameZip = filenameZip;
        this.zip = zip;
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

	public String getFilenameZip() {
		return filenameZip;
	}

	public void setFilenameZip(String filenameZip) {
		this.filenameZip = filenameZip;
	}
	
	public boolean isZip() {
		return zip;
	}

	public void setZip(boolean zip) {
		this.zip = zip;
	}

}
