package com.example.fxproject.sample.lambdas;

interface ILambdaEx04{
	void lambda(Object data);
}
public class LambdaEx04 {
	public static void main(String[] args) {
		ILambdaEx04 ex04 = (aaaaaa) -> {
			System.out.println("메서드 호출 : " + aaaaaa);
		};
		ex04.lambda("문자열");
		ex04.lambda(123);
		ex04.lambda(12.3);
		
		ex04 = aaaaaa -> {
			System.out.println("메서드 호출 : " + aaaaaa);
		};
		
		ex04.lambda("문자열");
		ex04.lambda(123);
		ex04.lambda(12.3);
	}
}









