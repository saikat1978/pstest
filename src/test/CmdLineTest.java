package test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CmdLineTest {

	public static void main(String[] args) {
		String startLoc = "C:\\Users\\Saikat Chatterjee\\AppData\\Roaming\\Microsoft\\Windows\\Start Menu\\Programs\\Startup";
		String cmd = "java -jar -Xmx500m F:\\Java-Scoring\\Java-Scoring\\Java-Scoring 2018-02-08\\service.jar TRESXLB2 8875";
		
		File batchFile = new File(startLoc + "\\test.bat");
		
		long startmillis = System.currentTimeMillis();
		try {
			if (!batchFile.exists()) {
				batchFile.createNewFile();
			} else {
				batchFile.delete();
				batchFile.createNewFile();
			}
			BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(batchFile));
			writer.write(cmd.getBytes());
			writer.flush();
			writer.close(); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long stopmillis = System.currentTimeMillis();
		long timeTaken = (stopmillis - startmillis);
		System.out.println(timeTaken);

	}

}
