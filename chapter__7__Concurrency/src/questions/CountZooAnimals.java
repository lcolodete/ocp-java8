package questions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class CountZooAnimals {

	public static Integer performCount(int exhibitNumber) throws Exception {
		
		//can return null
		//can throw a RuntimeException
		//can declare a checked exception
		
//		if (exhibitNumber == 2) {
//			while(true) {
//				
//			}
//		}
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
		}
		
		System.out.println("performCount: "+exhibitNumber);
		
//		throw new NumberFormatException(exhibitNumber+" ");
		
//		throw new IllegalArgumentException(exhibitNumber+" ");
		
		return exhibitNumber;
//		return null;
	}
	
	public static void printResults(Future<?> f) {
		try {
			System.out.println(f.get());
		} catch (Exception e) {
			System.out.println("Exception! msg="+e.getMessage()+", e="+e.getClass());
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		
//		ExecutorService service = Executors.newSingleThreadExecutor();
		ExecutorService service = Executors.newFixedThreadPool(20);
			
		final List<Future<?>> results = new ArrayList<>();
		
		IntStream.range(0,10).forEach(i -> results.add( service.submit(() -> performCount(i)) ));

		System.out.println("main going to sleep...");
		Thread.sleep(5000);
		System.out.println("main awaken");
		
		results.stream().forEach(f -> printResults(f));
	
		if (service != null)
			service.shutdown();
		
	}
	
}
