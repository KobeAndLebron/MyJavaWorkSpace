package com.cjs.printer_scanner;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStream {
	public static void main(String[] args) throws IOException{
		 @SuppressWarnings("resource")
		DataOutputStream dataOut = new DataOutputStream (new FileOutputStream("text.txt"));
		 dataOut.writeInt(123324);
		 @SuppressWarnings("resource")
		DataInputStream dataInput = new DataInputStream (new FileInputStream("text.txt"));
		 int i = dataInput.readInt();
		 System.out.println(i);
	}
}

	
	