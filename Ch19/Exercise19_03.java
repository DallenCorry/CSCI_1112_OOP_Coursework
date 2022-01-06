/*
Author: Dallen Corry
Date: 01/06/2022

Description: Implemented the removeDuplicates method.
 */
import java.util.ArrayList;

public class Exercise19_03 {
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    list.add(14);
    list.add(24);
    list.add(14);
    list.add(42);
    list.add(25);
    list.add(14);
    list.add(25);
    list.add(34);
    list.add(24);
    
    
    ArrayList<Integer> newList = removeDuplicates(list);
    System.out.println("Original list: "+list);
    
    System.out.print("List without duplicates: "+newList);
  }

	private static <E> ArrayList<E> removeDuplicates(ArrayList<E> l) {
		//create new list
		ArrayList<E> list = new ArrayList<E>();
		for (int i=0; i<l.size(); i++) {
			list.add(l.get(i));
		}
		//remove duplicates
		for(int i=0; i<list.size(); i++) {
			for(int j=i+1; j<list.size(); j++) {
				if(list.get(i)==(list.get(j))) {
//					System.out.println("found Duplicates "+ list.get(i)+" "+list.get(j));
					list.remove(j);
				}
			}
		}
		return list;
	}
}