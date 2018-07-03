package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ProcessBuilder.Redirect;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.jezhumble.javasysmon.JavaSysMon;
import com.jezhumble.javasysmon.ProcessInfo;

public class ProcessTest {

	public static void main(String[] args) throws IOException {
		
		//String command = "java -jar F:\\workspace-sts-3.9.3.RELEASE\\gs-serving-web-content-complete\\target\\gs-serving-web-content-0.1.0.jar";
		String command = "java -jar -Xmx500m service.jar TRESXLB2 8875";
		JavaSysMon sysMon = new JavaSysMon();
		Map<Integer, String> existingProcessMap = new HashMap<>();
		
		
		
		long startmillis = System.currentTimeMillis();
		System.out.println("-----------------------------------------------------------------------------------------------");
		
		ProcessBuilder builder = new ProcessBuilder(new String[] {"java", "-jar", "-Xmx500m", 
				"F:\\Java-Scoring\\Java-Scoring\\Java-Scoring 2018-02-08", "service.jar", "TRESXLB2", "8875"});
		//builder.directory(new File(""));
		File errFile = new File("F:\\err1.txt");
		File outputFile = new File("F:\\input1.txt");
		
		if (errFile.exists()) {
			errFile.delete();
			
		} else if (outputFile.exists()) {
			outputFile.delete();
			
		}
		
		errFile.createNewFile();
		outputFile.createNewFile();
		
		builder.redirectError(Redirect.appendTo(errFile));
		builder.redirectOutput(Redirect.appendTo(outputFile));
		builder.start();
		
		System.out.println("finished starting the process");
		long stopmillis = System.currentTimeMillis();
		long timeTaken = (stopmillis - startmillis);
		System.out.println("returning from process builder" + timeTaken);
		
		int newPid = 0;
		for (ProcessInfo pInfo : sysMon.processTable()) {
			if (pInfo.getCommand().contains("java")) {
				
					if (pInfo.getCommand().contains("TRESXLB2")) {
						//existingProcessMap.put(pInfo.getPid(), pInfo.getCommand());
						System.out.println(pInfo.getPid() + ", command = " + pInfo.getCommand()); // process id of the server program
						newPid = pInfo.getPid();
					}
					
				
			}
			
		}
		
		
		System.out.println("waiting..........");
		/*try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//System.out.println("waiting done");
		System.out.println("pid to kill " + newPid);
		//sysMon.killProcess(newPid); //un-comment it to kill the java server program. Comment the rest of the code before running it. 
		//System.out.println("killed the process");
	}

}
