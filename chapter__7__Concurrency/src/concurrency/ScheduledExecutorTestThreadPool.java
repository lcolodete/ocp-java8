package concurrency;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorTestThreadPool {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ScheduledExecutorService service = null;
		try {
//			service = Executors.newSingleThreadScheduledExecutor();
			service = Executors.newScheduledThreadPool(10);

			Runnable task1 = () -> System.out.println(Thread.currentThread().getName() + " : Hello Zoo! Now is "+new Date());
			
			service.scheduleAtFixedRate(task1, 0, 5, TimeUnit.SECONDS);
		} finally {
//			if (service != null)
//				service.shutdown();
		}
		
		System.out.println("main end");
		
		System.out.println("availableProcessors="+Runtime.getRuntime().availableProcessors());
	}
}
