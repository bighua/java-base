package generics;

import java.util.List;
import java.util.Set;

public class GenericMethod {
	/**
	 * 泛型方法
	 * @param anArray
	 * @param elem
	 * @return
	 */
	public static <T extends Comparable<T>> int countGreaterThan(T[] anArray, T elem) {
	    int count = 0;
	    for (T e : anArray)
	        if (e.compareTo(elem) > 0)
	            ++count;
	    return count;
	}
	
	/**
	 * 无边界通配符 <?>
	 * @param list
	 */
	public static void printList(List<?> list) {
	    for (Object elem: list)
	        System.out.print(elem + " ");
	    System.out.println();
	}
	
//	public void print(Set<String> strSet) { }
//    public void print(Set<Integer> intSet) { }
}
