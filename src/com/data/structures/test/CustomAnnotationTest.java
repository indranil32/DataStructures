package com.data.structures.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

class TestModel {
	
	private int id;
	private String name;

	public TestModel() {
		
	}
	
	public TestModel(int id, String name) {
		this.id = id;
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}

public class CustomAnnotationTest {
	public static void main(String args[]) throws Exception {
		System.out.println("Testing...");
		TestAnnotationParser parser = new TestAnnotationParser();
		int id = 1;
		String name = "Indranil";
		parser.parse(TestClassInvoke.class, id, name);
	}
}

class TestAnnotationParser {
	
	public void parse(Class<?> clazz, int id, String name) throws Exception {
		for (Method m : clazz.getMethods()) {
			for (Parameter p : m.getParameters()) {
				 if (p.isAnnotationPresent(TestObjLoadAnnotation.class)) {
					m.invoke(clazz.newInstance(), new TestModel(id,name));
				 }
			 }
		}
		
		 
	 }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@interface TestObjLoadAnnotation {
	
	public String value();
}


class TestClassInvoke {
	public void load(@TestObjLoadAnnotation("model") TestModel model) {
		System.out.println(model.toString());
	}
}


