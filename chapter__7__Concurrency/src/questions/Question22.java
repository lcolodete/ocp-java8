package questions;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Question22 {

	private static int counter = 0;
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService service = null;
		try {
			service = Executors.newSingleThreadExecutor();
			
			Future<Integer> result = service.submit( () -> counter++ );
			Future<?> result2 = service.submit( () -> {counter++;} );
			
			Integer i = result.get();
			
			System.out.println(i);
			
			System.out.println(result2.get());
			
			System.out.println(counter);
			
		} finally {
			if (service != null)
				service.shutdown();
		}

	}

}
