/*
Author: Dallen Corry
Date: 01/06/2022

Description: Creted two methods that sort a generic array in ascending and descenging order.
*/
import java.util.ArrayList;

public class Exercise19_09 {
	public static void main(String[] args) {
		System.out.println("Print in ascending order then in descending order.");
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(14);
		list.add(24);
		list.add(4);
		list.add(42);
		list.add(5);
		
		Exercise19_09.<Integer>sortAscend(list);
		System.out.print(list);
		
		System.out.println();
		
		Exercise19_09.<Integer>sortDescend(list);
		System.out.print(list);
		
		System.out.println();
		
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add(" ");
		list2.add("Bobby");
		list2.add("Allison");
		list2.add("Derek");
		list2.add("Carl");
		list2.add("Aaron");
		list2.add("Zendaya");
		list2.add("Peter");
		
		Exercise19_09.<String>sortAscend(list2);
		System.out.print(list2);
		
		System.out.println();
		
		Exercise19_09.<String>sortDescend(list2);
		System.out.print(list2);
		
	}

	public static <E extends Comparable<E>> void sortDescend(ArrayList<E> list) {
		for (int i=0; i<list.size(); i++) {
			for (int j=0; j<list.size(); j++) {
				if (list.get(i).compareTo(list.get(j))>0) {
					E temp = list.get(i);
					list.set(i, list.get(j));
					list.set(j, temp);
				}
			}
		}
	}
	
	public static <E extends Comparable<E>> void sortAscend(ArrayList<E> list) {
		for (int i=0; i<list.size(); i++) {
			for (int j=0; j<list.size(); j++) {
				if (list.get(i).compareTo(list.get(j))<0) {
					E temp = list.get(i);
					list.set(i, list.get(j));
					list.set(j, temp);
				}
			}
		}
	}

}
