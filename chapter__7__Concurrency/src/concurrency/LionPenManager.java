package concurrency;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LionPenManager {

	public void performTasks() {
		removeAnimals();
		cleanPen();
		addAnimals();
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
			
			LionPenManager manager = new LionPenManager();
			
			for (int i=0; i<4; i++)
				service.submit( () -> manager.performTasks() );
			
		} finally {
			if (service != null)
				service.shutdown();
		}
		
	}

}
