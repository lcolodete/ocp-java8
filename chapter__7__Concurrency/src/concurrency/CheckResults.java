package concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CheckResults {

	private static int counter = 0;
	
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ExecutorService service = null;
		try {
			service = Executors.newSingleThreadExecutor();
			
			Future<?> result = service.submit( () -> {
				for (int i=0; i<500; i++) {
					CheckResults.counter++;
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						
					}
				}
			});
			
			//the main thread will wait at most 10 seconds for the submitted task to complete
			//if the task does not complete within 10 seconds, a TimeoutException will be thrown
//			result.get(10, TimeUnit.SECONDS);
			
			//waits endlessly for the task to complete
			result.get();
			
			System.out.println("Reached! counter="+CheckResults.counter);
//		} catch (TimeoutException e) {
//			System.out.println("Not reached in time. counter="+CheckResults.counter);
		} 
		finally {
			if (service != null) 
				service.shutdown();
		}
	}
}
