package com.example.demo.sync004;
/**
 * 业务整体需要使用完整的synchronized，保持业务的原子性。
 * @author alienware
 *
 * 数据库ACID，  一致性、持久性、隔离性、原子性
 *
 * 对一个对象方法加锁的时候，需要考虑业务的整体性，即setValue/getValue方法同时加锁synchronized同步关键字，保证业务service的原子性，不然会出现业务错误；
 *
 *
 */
public class DirtyRead {

	private String username = "bjsxt";
	private String password = "123";
	
	public synchronized void setValue(String username, String password){
		this.username = username;
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		this.password = password;
		
		System.out.println("setValue最终结果：username = " + username + " , password = " + password);
	}
	
	public void getValue(){
		System.out.println("getValue方法得到：username = " + this.username + " , password = " + this.password);
	}
	
	
	public static void main(String[] args) throws Exception{
		
		final DirtyRead dr = new DirtyRead();
/*		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				dr.setValue("z3", "456");		
			}
		});*/
		new Thread( () -> dr.setValue("z3", "456") ).start();
		//t1.start();
		Thread.sleep(1000);
		
		dr.getValue();
	}
	
	
	
}
