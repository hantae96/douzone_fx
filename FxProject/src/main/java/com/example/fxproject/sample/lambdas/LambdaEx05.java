package com.example.fxproject.sample.lambdas;

interface ILambdaEx05<T>{
	void lambda(T data);
}

public class LambdaEx05 {
	public static void main(String[] args) {
		ILambdaEx05<Integer> ex05 = (aaaaaa) -> {
			System.out.println("메서드 호출 : " + aaaaaa);
		};
//		ex05.lambda("문자열");
		ex05.lambda(123);
		
		ex05 = aaaaaa -> {
			System.out.println("메서드 호출 : " + aaaaaa);
		};
		
//		ex05.lambda("문자열");
		ex05.lambda(123);
	}
}









