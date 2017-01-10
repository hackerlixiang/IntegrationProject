package com.myproject.www.test2;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map.Entry;
import java.util.Set;

import sun.print.resources.serviceui;

public class ThreadTest {
	
	public static void main(String[] args) {
//		Thread r1 = new Thread(new Runnable1());
//		Thread r2 = new Thread(new Runnable1());
//		Thread1 t1 = new Thread1();
//		Thread1 t2 = new Thread1();
//		
//		r1.start();
//		r2.start();
//		t1.start();
//		t2.start();
		Set s = new HashSet();
		Hashtable<String, String> table = new Hashtable<String, String>();
		table.put("a", "dd");
		for (Entry<String, String> set : table.entrySet()) {
			System.out.println(set.getKey()+"="+set.getValue());
		}
	}
}

class Runnable1 implements Runnable{

	@Override
	public void run() {
		for (int i=0;i<5;i++) {
			System.out.println("r"+i);
		}
	}
	
}

class Thread1 extends Thread{
	
	@Override
	public void run() {
		for (int i=0;i<5;i++) {
			System.out.println("t"+i);
		}
	}
}