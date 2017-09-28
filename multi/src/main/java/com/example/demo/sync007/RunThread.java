package com.example.demo.sync007;

/**
 * 遍历在多个线程之间可见
 * java1.5对每一个线程增加了一个独立运行空间，空间中装主内存中的引用变量，运行时候直接找独立空间取值，所以有volatile的出现；
 */
public class RunThread extends Thread{

	private volatile boolean isRunning = true;
	private void setRunning(boolean isRunning){
		this.isRunning = isRunning;
	}
	
	public void run(){
		System.out.println("进入run方法..");
		int i = 0;
		while(isRunning == true){
			//..
		}
		System.out.println("线程停止");
	}
	
	public static void main(String[] args) throws InterruptedException {
		RunThread rt = new RunThread();
		rt.start();
		Thread.sleep(1000);
		rt.setRunning(false);
		System.out.println("isRunning的值已经被设置了false");
		Thread.sleep(1000);
		System.out.println(rt.isRunning);
	}
	
	
}
