package generics;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

// 泛型异常类 The generic class TestGeneric<T> may not subclass java.lang.Throwable
//public class TestGeneric<T> extends Exception {
public class TestGeneric<R> {

	// Cannot make a static reference to the non-static type T
//	static T member;
	
	// this one is fine
    public R[] notYetInstantiatedArray;
 
    // 不能实例化参数类型的数组
//    public T[] array = new T[5];
    
    class MyList<T> implements List<T>, Comparable<T> {

		@Override
		public int compareTo(T o) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int size() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public boolean isEmpty() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean contains(Object o) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Iterator<T> iterator() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Object[] toArray() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <T> T[] toArray(T[] a) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean add(T e) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean remove(Object o) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean containsAll(Collection<?> c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean addAll(Collection<? extends T> c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean addAll(int index, Collection<? extends T> c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean removeAll(Collection<?> c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean retainAll(Collection<?> c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void clear() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public T get(int index) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public T set(int index, T element) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void add(int index, T element) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public T remove(int index) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int indexOf(Object o) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int lastIndexOf(Object o) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public ListIterator<T> listIterator() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ListIterator<T> listIterator(int index) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<T> subList(int fromIndex, int toIndex) {
			// TODO Auto-generated method stub
			return null;
		}
    	
    }
    
    // 泛型支持多边界
    public static <T, U extends List<T> & Comparable<T>> void doStuff(final U comparableList) {}
 
    
	public TestGeneric() {
		// 实例化类型<T>
		// new T();
	}
	
	public static void main(String[] args) {
		// 与基本类型不兼容
//		TestGeneric<int> tg = new TestGeneric<>();
		TestGeneric<Integer> diamond = new TestGeneric<>();
		// raw type
		TestGeneric raw = new TestGeneric();
		// 
		raw = diamond;
		{
			diamond = raw;
			TestGeneric<Integer> diamond1 = new TestGeneric();
		}
		TestGeneric<Integer> tg = new TestGeneric<Integer>();
		
		TestGeneric.doStuff(tg.new MyList<String>());
	}

}
