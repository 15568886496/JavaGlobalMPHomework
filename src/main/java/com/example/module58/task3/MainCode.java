package com.example.module58.task3;

/**
 *
 * @author Kevin
 *
 */
public class MainCode {
	public static void main(String[] args) {
		//init message bus
		MessageBus ba = new MessageBus();
		
		//create three producer
		Producer p1 = new Producer(ba);
		Producer p2 = new Producer(ba);
		Producer p3 = new Producer(ba);
		//create three producer
		Consumer c1 = new Consumer(ba);
		Consumer c2 = new Consumer(ba);
		Consumer c3 = new Consumer(ba);
		Thread t1 = new Thread(p1,"producer 1");
		Thread t2 = new Thread(p2,"producer 2");
		Thread t3 = new Thread(p3,"producer 2");
		Thread t4 = new Thread(c1,"consumer 1");
		Thread t5 = new Thread(c2,"consumer 2");
		Thread t6 = new Thread(c3,"consumer 3");
//		t1.start();
//		t2.start();
//		t3.start();
		t4.start();
		t5.start();
		t6.start();
	}
}