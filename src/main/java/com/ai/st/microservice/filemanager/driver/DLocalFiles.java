package com.ai.st.microservice.filemanager.driver;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.ai.st.microservice.filemanager.util.FileTools;

public class DLocalFiles {

	private String fullBasePath;

	public DLocalFiles(String fpath) {
		this.fullBasePath = fpath;
	}

	public boolean store(MultipartFile file, String name, String path, boolean rewrite, boolean zip)
			throws IOException {
		if (!file.isEmpty()) {
			FileTools.saveFile(file, name, this.fullBasePath + File.separatorChar + path, rewrite, zip);
			return true;
		}
		return false;
	}

	public boolean store(byte[] file, String filename, String name, String path, boolean rewrite, boolean zip)
			throws IOException {
		if (file.length > 0) {
			FileTools.saveFile(file, filename, name, this.fullBasePath + File.separatorChar + path, rewrite, zip);
			return true;
		}
		return false;
	}

}
