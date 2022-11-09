package com.example.module58.task3;

/**
 * Message Bus
 * wait()/notify()
 * @author Kevin
 *
 */
public class MessageBus {
	private int currNum = 0;//current queue size.
	private int maxNum = 10000;// maximum queue size
	
	public synchronized void set(){
		if(currNum<maxNum){
			currNum++;
			System.out.println(Thread.currentThread().getName()+" produce a new message, current message size is "+currNum);
			notifyAll();
		}else{//if message size > maximum size then wait
			try {
				System.out.println(Thread.currentThread().getName()+" please wait, message bus is run out of capacity, current message size is "+currNum);
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public synchronized void get(){
		if(currNum>0){
			currNum--;
			System.out.println(Thread.currentThread().getName()+" consume a new message, current message size is "+currNum);
			notifyAll();
		}else{
			try {
				System.out.println(Thread.currentThread().getName()+" message bus is empty, current message size is "+currNum);
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}