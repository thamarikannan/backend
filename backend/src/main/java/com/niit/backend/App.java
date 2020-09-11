package com.niit.backend;

class Demo
{
	private int num;
	private String name;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Demo d = new Demo();
        d.setNum(3);
        d.setName("Logu");
        System.out.println(d.getNum());	
        System.out.println(d.getName());
        
    }
}
