package com.data.structures.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializeTest {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Employee e = new Employee();
		Address a = new Address();
		a.setAddress("test address");
		e.setAddress(a);
		e.setId(1);
		e.setName("test name");
		e.setTestType1("test static type");
		System.out.println(e.toString());
		
		FileOutputStream fos = new FileOutputStream("tmp.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(e);
		oos.flush();
		oos.close();
		fos.flush();
		fos.close();
		
		FileInputStream fis = new FileInputStream("tmp.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Employee e1 = (Employee) ois.readObject();
		System.out.println(e1.toString());
	}

}

class Employee implements Serializable{
	private int id;
	private String name;
	private Address address;
	private static String testType1;
	private final static String testType2 = "test";
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public static String getTestType1() {
		return testType1;
	}
	public static void setTestType1(String testType1) {
		Employee.testType1 = testType1;
	}
	public static String getTesttype2() {
		return testType2;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address
				+ "testType1= "+testType1+" testType2=" +testType2+"]";
	}
}

class Address implements Serializable{
	private String address;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Address [address=" + address + "]";
	}
	
}