package com.amazon.test;

import java.util.ArrayList;
import java.util.List;

public class DemoList {
	public static void main(String args[]) {
		List<String> wow=new ArrayList<String>();
		wow.add("name");
		wow.add("value");
		wow.add("place");
		wow.add("state");
		wow.remove(1);
		wow.remove(2);
		System.out.println(wow.size());
		System.out.println(wow);
		
		for(int i=0;i<10;i++) {
			for(int j=1;j<=1;j++) {
				System.out.println(i);
			}
		}
	}

}
