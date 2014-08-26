package jvm;

public class VolatileTest {

	public static volatile int c = 0;
	public static volatile int d = 0;
	
	public static void inc() {
		c++;
		d++;
	}
	
	public static final int THREAD_COUNT = 20;
	
	public static void main(String[] args) {
		
		Thread[] ts = new Thread[THREAD_COUNT];
		for (Thread t : ts) {
			t = new Thread(new Runnable() {
				
				@Override
				public void run() {
					for (int i = 0; i < 100; i++) {
						inc();
					}
				}
			});
			t.start();
		}
		
		while (Thread.activeCount() > 1) Thread.yield();
		
		System.out.println(c);
		System.out.println(d);
	}
}
