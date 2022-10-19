package com.raystec.JDBC;

import java.util.Locale;
import java.util.ResourceBundle;

public class TestLocale {
	public static void main(String[] args) {

		ResourceBundle rb = ResourceBundle.getBundle("com.raystec.rb.lang");
		
		ResourceBundle rb1 = ResourceBundle.getBundle("com.raystec.rb.lang", new Locale("hi"));
		
		ResourceBundle rb2 = ResourceBundle.getBundle("com.raystec.rb.lang", new Locale("ge"));
		
		System.out.println(rb.getString("greetings")); // for english
		
		System.out.println(rb1.getString("greetings")); // for hindi
		
		System.out.println(rb2.getString("greetings")); // for german
		
	}
}
