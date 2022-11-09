package com.example.module58.task3;

/**
 * consumer
 * @author Kevin
 *
 */
public class Consumer implements Runnable{
	private MessageBus messageBus;
 
	public Consumer(MessageBus messageBus){
		this.messageBus = messageBus;
	}
	
	@Override
	public void run() {
		while(true){
			setIntervalTime();
			messageBus.get();//consume message
		}
	}
	
	//set interval time
	public void setIntervalTime(){
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}