package com.cjs.printer_scanner;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CopyEmployees {
	
	public static void main(String[] args) throws IOException{
		Employee[] staff = new Employee[3];
		
		staff[0] = new Employee("kobe" , 5560021 , 1995 , 122 , 13);
		staff[1] = new Employee("lebron" , 10000 , 1995 , 10 , 13);
		staff[2] = new Employee("durent" , 100 , 1995 , 10 , 13);
		
		PrintWriter out = new PrintWriter("employees.txt");
		writeData(staff,out);
		Scanner in = new Scanner (new FileInputStream ("employees.txt"));
		readData(in);
	}

	private static void writeData (Employee [] staff , 
				PrintWriter out) throws IOException{
		for(int i = 0;i < staff.length;i++){
			 out.write( staff[i].getName() + staff[i].getSalary() + "___");
		}
		out.close();
	}
	
	private static void readData(Scanner in){
		String a = in.nextLine();
		System.out.println(a);
	}

}

