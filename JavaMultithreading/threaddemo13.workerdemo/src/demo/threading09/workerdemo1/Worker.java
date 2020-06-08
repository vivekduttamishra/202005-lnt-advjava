package demo.threading09.workerdemo1;

import in.conceptarchitect.threading.ThreadUtils;

/**
 * Every Worker works independently (separate Thread)
 * To add 'itemsToAdd' item in a
 * Basket
 * 
 * Works may be using separte Baskets
 * or may be sharing baskets
 */


public class Worker implements Runnable {

	Thread thread;
	Basket basket;
	long itemsToAdd;
	
	public Worker(Basket basket,long itemsToAdd) {
		
		this.basket=basket;
		thread=new Thread(this);
		this.itemsToAdd=itemsToAdd;
	}
	
	public void start(){
		thread.start();
	}
	
	public void waitFor(){
		ThreadUtils.waitFor(thread);
	}
	

	@Override
	public void run() {
		// 
		for(int i=0;i<itemsToAdd;i++)
			basket.addItem();
	}

	public Basket getBasket() {
		return basket;
	}

	public void setBasket(Basket basket) {
		this.basket = basket;
	}

}
