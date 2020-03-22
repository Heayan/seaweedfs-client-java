# seaweedfs-client-java
SeaweedFS分布式文件系统客户端。

# Quick Start

##### DEMO
```java

String host = "192.168.1.120";
Integer port = 9333;
FileInputStream stream = new FileInputStream(new File("C:/1.jpg"));
			
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
```
