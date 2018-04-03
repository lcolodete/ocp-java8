package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ZooInfo {

	public static void main(String[] args) {
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
				
				try {
					service.execute(() -> System.out.println("Printing zoo inventory"));
				} catch (Exception e) {
					System.out.println("exception raised while calling service.execute() after shutdown");
					System.out.println(e);
				}
			}
		}
		
		System.out.println("end main");
	}
}
