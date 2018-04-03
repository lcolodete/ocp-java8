package concurrency;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorTest2 {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ScheduledExecutorService service = null;
		try {
			service = Executors.newSingleThreadScheduledExecutor();

			Runnable task1 = () -> System.out.println("Hello Zoo! Now is "+new Date());
			
			service.scheduleAtFixedRate(task1, 0, 10, TimeUnit.SECONDS);
		} finally {
//			if (service != null)
//				service.shutdown();
		}
		
		System.out.println("main end");
	}
}
