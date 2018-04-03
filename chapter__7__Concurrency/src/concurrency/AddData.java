package concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AddData {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ExecutorService service = null;
		try {
			service = Executors.newSingleThreadExecutor();
			Future<?> result = service.submit( () -> 30 + 12 );
			
//			Integer addedData = result.get();
			
			Object addedData = result.get();
			
			System.out.println(addedData);
			
		} finally {
			if (service != null)
				service.shutdown();
		}
	}
}
