package com.example.demo.conn011;

public class Singletion {

	//静态内部类中实例化静态对象
	private static class InnerSingletion {
		private static Singletion single = new Singletion();
	}
	
	public static Singletion getInstance(){
		return InnerSingletion.single;
	}
	
}
