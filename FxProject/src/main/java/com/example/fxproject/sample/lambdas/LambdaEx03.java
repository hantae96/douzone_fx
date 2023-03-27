package com.example.fxproject.sample.lambdas;

interface ILambdaEx03{
	void lambda();
}
public class LambdaEx03 {
	public static void main(String[] args) {
		ILambdaEx03 ex03 = () -> {
			System.out.println("메서드 호출");
		};
		
		ex03.lambda();
		
		ex03 = () -> {
			System.out.println("메서드 호출22");
			System.out.println("메서드 호출33");
			System.out.println("메서드 호출34");
			System.out.println();
		};
		ex03.lambda();
		ex03.lambda();
		ex03.lambda();
	}
}









