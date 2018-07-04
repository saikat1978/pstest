package test;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.lang.ProcessBuilder.Redirect;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class ProcessTest2 {

	public static void main(String[] args) {
		String command = "java -jar -Xmx1024m service.jar TRESXLB2 8875";
		
		/*
		ProcessBuilder builder = new ProcessBuilder(command.split(" "));
		builder.redirectError(Redirect.appendTo(new File("f:\\err1.txt")));
		builder.redirectOutput(Redirect.appendTo(new File("f:\\output1.txt")));
		builder.directory(new File("F:\\Java-Scoring\\Java-Scoring\\Java-Scoring-2018-02-08"));
		try {
			builder.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("done");
		}*/
		
		ping("localhost", 8875);
		
		
	}
	
	static void ping(String server, int port) {
		try {
			Socket echoSocket = new Socket();
			System.out.println("going to connect");
			echoSocket.connect(new InetSocketAddress(server, port), 2000);
			
			System.out.println("connected");
			
			echoSocket.setSoTimeout(2000);
			DataOutputStream out = new DataOutputStream(echoSocket.getOutputStream());
			DataInputStream in = new DataInputStream(echoSocket.getInputStream());
			
			out.writeUTF("status");
			out.flush();
			
			System.out.println(in.readUTF());
			
			out.close();
			in.close();
			echoSocket.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
