package util;

import java.io.*;
public class inputstream_File {
	public static File asFile(InputStream inputStream) throws IOException{
	 	File tmp = File.createTempFile("lzq", ".png", new File("C:\\Users\\miaoz\\Desktop\\��Ŀ����ͱʼ�"));
	 	OutputStream os = new FileOutputStream(tmp);
	    int bytesRead = 0;
	    byte[] buffer = new byte[8192];
	    while ((bytesRead = inputStream.read(buffer, 0, 8192)) != -1) {
	      os.write(buffer, 0, bytesRead);
	    }
	    inputStream.close();
	    return tmp;
	 }
}
