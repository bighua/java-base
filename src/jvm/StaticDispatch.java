package jvm;

public class StaticDispatch {

	static abstract class Human{};
	
	static class Man extends Human{};
	
	static class Woman extends Human{}
	
	public void sayHi(Human guy) {
		System.out.println("hi, guy!");
	}
	
	/**
	 * 方法的重载
	 * @param guy
	 */
	public void sayHi(Man guy) {
		System.out.println("hi, Man!");
	}
	
	public void sayHi(Woman guy) {
		System.out.println("hi, Woman!");
	}
	
	public static void main(String[] args) {
		
		// man的静态类型为Human,实际类型为Man
		Human man = new Man();
		Human woman = new Woman();
		StaticDispatch sd = new StaticDispatch();
		// 静态分派，方法接受的参数类型为静态类型，根据静态类型选择重载版本
		sd.sayHi(man); // hi, guy!
		sd.sayHi(woman); // hi, guy!
	}

}
