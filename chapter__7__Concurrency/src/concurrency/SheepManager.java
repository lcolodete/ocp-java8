package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SheepManager {

	private int sheepCount = 0;
	private void incrementAndReport() {
		System.out.print((++sheepCount)+" ");
	}
	
	public static void main(String[] args) throws InterruptedException {
		for (int i=0; i<200; i++)
			testSheepManager();
		
	}

	private static void testSheepManager() throws InterruptedException {
		ExecutorService service = null;
		try {
			service = Executors.newFixedThreadPool(20);
			
			SheepManager manager = new SheepManager();
			
			for (int i=0; i<10; i++) {
				service.submit( () ->  manager.incrementAndReport());
			}
		} finally {
			if (service != null)
				service.shutdown();
			
			service.awaitTermination(2, TimeUnit.SECONDS);
			System.out.println(" >> END");
		}
	}
}
