package jvm;

public class VMStack {

	public static void main(String[] args) {
		// 规划恰当的变量作用域，以控制变量回收时间
		{
			byte[] p = new byte[64 * 1024 * 1024];
		}
		int a = 0;
		sayHi();
		System.gc();
	}
	
	public static void sayHi() {
		System.out.println("hi!");
	}

}
