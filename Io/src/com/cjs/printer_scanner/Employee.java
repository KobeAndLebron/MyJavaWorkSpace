package com.cjs.printer_scanner;


public class Employee {
	private String name;
	private int salary;
	private int year;
	private int month;
	private int day;
	
		
	public Employee(String name , int salary , int year , int month , int day){
		this.name = name;
		this.salary = salary;
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public String getName() {
		return this.name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getSalary() {
		return this.salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}


	public int getYear() {
		return this.year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public int getMonth() {
		return this.month;
	}


	public void setMonth(int month) {
		this.month = month;
	}


	public int getDay() {
		return this.day;
	}


	public void setDay(int day) {
		this.day = day;
	}

}



/*try {
	PrintWriter out = new PrintWriter("employee.txt" , "UTF-8");
	writeData(staff,out);
}catch (Exception e){
	e.printStackTrace();
	System.out.println("a");
}

Scanner in = new Scanner(new FileInputStream("employee.txt"));
readData(in);
}

private static void writeData (Employee [] staff , 
			PrintWriter out) throws IOException{
for (Employee e : staff){
		 try {
			 out.println( e.getName() );
		 }catch (Exception a){
			 a.printStackTrace();
		 }
}
}

private static void readData (Scanner in) throws IOException{
in.nextByte();
}*/

