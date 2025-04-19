package com.spring.boot;

import com.spring.boot.dto.MathNumber;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringBoot903Application {

	public static void main(String[] args) {

	}

	public static <T extends Number> Double sum(T x, T y){
		return x.doubleValue() + y.doubleValue();
	}


	public static <T> void display(T value){
		System.out.println(value);
	}

	/*
	public static int sum(int x, int y){
		return x + y;
	}


	public static float sum(float x, float y){
		return x + y;
	}


	public static double sum(double x, double y){
		return x + y;
	}


	public static Long sum(Long x, Long y){
		return x + y;
	}*/
}
