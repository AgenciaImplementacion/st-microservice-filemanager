package com.ai.st.microservice.filemanager.rabbitmq.listeners;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.ai.st.microservice.filemanager.driver.DLocalFiles;
import com.ai.st.microservice.filemanager.dto.rabbitmq.UploadFileMessageDto;
import com.ai.st.microservice.filemanager.util.FileTools;
import com.ai.st.microservice.filemanager.util.RandomString;

@Component
public class RabbitMQFileListener {

	private final static Logger log = Logger.getLogger(DLocalFiles.class.getName());
	
	@Value("${st.temporalDirectory}")
	public String tmpPath;
	
	@Value("${st.filesDirectory}")
	public String realPath;

	@RabbitListener(queues = "${st.rabbitmq.queueFiles.queue}")
	public String recievedMessageFile(UploadFileMessageDto message) {

		String url = null;

		DLocalFiles st = new DLocalFiles(this.realPath);

		String namespace = message.getNamespace();
		String filename = message.getFilename();

		try {
			int y = Calendar.getInstance().get(Calendar.YEAR);
			int m = Calendar.getInstance().get(Calendar.MONTH);
			int d = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
			int h = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
			int mi = Calendar.getInstance().get(Calendar.MINUTE);
			String s = (new RandomString(5)).nextString();
			String base_url;
			if (namespace.equals("default")) {
				base_url = namespace + File.separatorChar + String.valueOf(y) + File.separatorChar + String.valueOf(m)
						+ File.separatorChar + String.valueOf(d);
			} else {
				base_url = namespace;
			}
			
			byte[] file = FileTools.getByteArrayFile(this.tmpPath + File.separatorChar + filename);
					
			while (true) {
				try {
					st.store(file, filename, h + "h" + mi + "m" + s, base_url, false);
					break;
				} catch (FileAlreadyExistsException e) {
					s = (new RandomString(5)).nextString();
				}
			}

			url = base_url.replaceAll(String.valueOf(File.separatorChar), ".") + "." + h
					+ "h" + mi + "m" + s;

		} catch (IOException e) {
			log.log(Level.SEVERE, "Error: (DLocalFiles.store.IOException) " + e.getMessage(), e);
		}

		return url;
	}

}
