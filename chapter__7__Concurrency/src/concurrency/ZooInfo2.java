package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ZooInfo2 {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService service = null;
		try {
			service = Executors.newSingleThreadExecutor();
			
			System.out.println("begin");
			
			service.execute(() -> System.out.println("Printing zoo inventory A"));
			
			service.execute( () -> {
				for (int i=0; i<3; i++) {
					System.out.println("Printing record "+i);
				}
			});
			
			service.execute(() -> System.out.println("Printing zoo inventory B"));

			service.execute(() -> System.out.println("Printing zoo inventory C"));
			
			service.execute(() -> {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					
				}
				System.out.println("Printing zoo inventory D");
			});
			
			System.out.println("end");
		} finally {
			if (service != null) {
				service.shutdown();
				
				System.out.println("end after service.shutdown()");

				service.awaitTermination(2, TimeUnit.SECONDS);
				if (service.isTerminated())
					System.out.println("All tasks finished");
				else
					System.out.println("At least one task is still running");
			}
		}
		
		System.out.println("end main");
	}
}
