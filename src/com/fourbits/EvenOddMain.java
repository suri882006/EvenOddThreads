package com.fourbits;

public class EvenOddMain {

	public static void main(String[] args) {

		OddList oddObj = new OddList();
		EvenList evenObj = new EvenList();

		Thread evenThread = new Thread(new EvenPrinter(evenObj, oddObj), "EvenThread");
		Thread oddThread = new Thread(new OddPrinter(evenObj, oddObj), "OddThread");
		oddThread.start();
		//evenThread.setPriority(Thread.MIN_PRIORITY);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		evenThread.start();
		while (evenThread.isAlive() && oddThread.isAlive()) {
			//System.out.println("odd state --> " + oddThread.getState());
			//System.out.println("even state --> " + oddThread.getState());

			if (oddThread.getState().equals(Thread.State.WAITING)) {
				oddThread.interrupt();
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
			}

			if (evenThread.getState().equals(Thread.State.WAITING)) {
				evenThread.interrupt();
			}
		}
	}

}
