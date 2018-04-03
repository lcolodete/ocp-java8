package concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorTest {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ScheduledExecutorService service = null;
		try {
			service = Executors.newSingleThreadScheduledExecutor();

			Runnable task1 = () -> System.out.println("Hello Zoo!");
			Callable<String> task2 = () -> "Monkey";
			
			Future<?> result1 = service.schedule(task1, 5, TimeUnit.SECONDS);
			Future<String> result2 = service.schedule(task2, 20, TimeUnit.SECONDS);
			
			String s = result2.get();
			System.out.println("Callable task2 completed and returned : "+s);
		} finally {
			if (service != null)
				service.shutdown();
		}
		
		System.out.println("main end");
	}
}
