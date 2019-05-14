package io.github.mzanthem.reflect;
class Person{
	private String name;
	private int age = 0;
	Person(){
		name = "default name";
		System.out.println("Person created default");
	}
	Person(String name){
		this.name = name;
		System.out.println("Person created with name");
	}
	Person(String name,int age){
		this.name = name;
		this.age = age;
		System.out.println("Person created with name and age");
	}
	
	String selfIntroduction(){
		return "Hello!My name is '"+name+"'";
	}
	
	
	void say(String something){
		System.out.println(name+"说："+something);
	}
	boolean wasDead(){
		return age > 200; 
	}
	public String getName(){
		return name;
	}
}