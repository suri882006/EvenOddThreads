package com.fourbits;

public class EvenPrinter implements Runnable {
	
	public EvenPrinter(EvenList evenObj, OddList oddObj) {
		super();
		this.oddObj = oddObj;
		this.evenObj = evenObj;
	}

	OddList oddObj = new OddList();
	EvenList evenObj = new EvenList();
	
	@Override
	public void run() {
		String currentThread = Thread.currentThread().getName();		
		synchronized (evenObj) {			
			for(Integer obj:evenObj.getList()) {
				
				System.out.println(obj);
				try {	
					evenObj.wait();		
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				} 
				finally {
					
				}
				synchronized (oddObj) {		
				oddObj.notify();
				}
			}				
		}
		
		
	}

}
