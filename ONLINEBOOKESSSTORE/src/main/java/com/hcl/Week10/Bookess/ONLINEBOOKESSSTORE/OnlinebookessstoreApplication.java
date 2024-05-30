package com.hcl.Week10.Bookess.ONLINEBOOKESSSTORE;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnlinebookessstoreApplication {
	
	ArrayList<String> names = new ArrayList<String>();

	public static void main(String[] args) {
		SpringApplication.run(OnlinebookessstoreApplication.class, args);
		System.out.println("Hello Bookess Store");
	}
	public String add(String data) {
		System.out.println(data);
		return data;
	}
	
	public ArrayList<String> listString(String data) {
		System.out.println(data);
		
		names.add(data);
		
		return names;
	}

}
