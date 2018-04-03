package concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LionPenManagerCyclicBarrier {

	public void performTasks(CyclicBarrier c1, CyclicBarrier c2) {
		try {
			removeAnimals();
			c1.await();
			cleanPen();
			c2.await();
			addAnimals();
		} catch(InterruptedException | BrokenBarrierException e) {
			
		}
	}
	
	private void addAnimals() {
		System.out.println(Thread.currentThread().getName()+" --> Adding animals");
	}

	private void cleanPen() {
		System.out.println(Thread.currentThread().getName()+" --> Cleaning the pen");
	}

	private void removeAnimals() {
		System.out.println(Thread.currentThread().getName()+" --> Removing animals");
	}

	public static void main(String[] args) {
		ExecutorService service = null;
		try {
			service = Executors.newFixedThreadPool(4);
			
			LionPenManagerCyclicBarrier manager = new LionPenManagerCyclicBarrier();
			
			CyclicBarrier c1 = new CyclicBarrier(4);
			CyclicBarrier c2 = new CyclicBarrier(4, () -> System.out.println("*** Pen Cleaned!"));
			
			for (int i=0; i<4; i++)
				service.submit( () -> manager.performTasks(c1, c2) );
			
		} finally {
			if (service != null)
				service.shutdown();
		}
		
	}

}
