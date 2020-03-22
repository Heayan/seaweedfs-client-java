package com.heayan.seaweedfs.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.alibaba.fastjson.JSONObject;
import com.heayan.seaweedfs.core.FileSource;
import com.heayan.seaweedfs.core.FileTemplate;
import com.heayan.seaweedfs.core.file.FileHandleStatus;

public class Example {
	
	public static void main(String[] args) {
		try {
			String host = "file.heayan.com";
			Integer port = 9100;
			FileInputStream stream = new FileInputStream(new File("C:/Users/wushu/Desktop/blog-web静态图片/public/1.jpg"));
			
			FileSource fileSource = new FileSource();
			// SeaweedFS master server host
			fileSource.setHost(host);
			// SeaweedFS master server port
			fileSource.setPort(port);
			// Set Connection Timeout
			fileSource.setConnectionTimeout(5000);
			// Startup manager and listens for the change
			fileSource.startup();
			
			// Template used with connection manager
			FileTemplate template = new FileTemplate(fileSource.getConnection());
			FileHandleStatus status = template.saveFileByStream("1.jpg", stream);
			System.out.println("==>执行结果：" + JSONObject.toJSONString(status));
			
			fileSource.destroy();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
