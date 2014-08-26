package reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy {

	interface IHello {
		public void sayHi();
	}
	
	static class Hello implements IHello {
		public void sayHi() {
			System.out.println("hi!");
		}
	}
	static class InnerProxy implements InvocationHandler {
		Object originalObject;
		
		public Object bind(Object origin) {
			this.originalObject = origin;
			return Proxy.newProxyInstance(originalObject.getClass().getClassLoader(), originalObject.getClass().getInterfaces(), this);
		}
	
		@Override
		public Object invoke(Object proxy, Method method, Object[] args)
				throws Throwable {
			System.out.println("say");
			return method.invoke(originalObject, args);
		}
	}
	public static void main(String[] args) {
//		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
		IHello ih = (IHello)new InnerProxy().bind(new Hello());
		ih.sayHi();
	}
}
