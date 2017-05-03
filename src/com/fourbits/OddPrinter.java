package com.fourbits;

public class OddPrinter implements Runnable {

	public OddPrinter(EvenList evenObj, OddList oddObj) {
		super();
		this.evenObj = evenObj;
		this.oddObj = oddObj;
	}

	EvenList evenObj = new EvenList();	
	OddList oddObj = new OddList();
	
	@Override
	public void run() {
		String currentThread = Thread.currentThread().getName();		
		synchronized (oddObj) {			
			for(Integer obj:oddObj.getList()) {
				
				System.out.println(obj);
				try {
					oddObj.wait();					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				} 
				finally {
					
				}				
				synchronized (evenObj) {		
					evenObj.notify();
					}
				
			}
		}
		
		
	}

}
