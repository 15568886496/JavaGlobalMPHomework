package com.example.module58.task3;

/**
 * producer
 * @author Kevin
 *
 */
public class Producer implements Runnable{
 
	private MessageBus messageBus;
	
	public Producer(MessageBus messageBus){
		this.messageBus = messageBus;
	}
	
	@Override
	public void run() {
		while(true){
			setIntervalTime();
			messageBus.set();//produce product
		}
	}
	
	public void setIntervalTime(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
 
}
 