package parallel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WhaleDataCalculator {

	public int processRecord(int input) {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			
		}
		return input + 1;
	}
	
	public void processAllData(List<Integer> data) {
//		data.stream().map(a -> processRecord(a)).count();
		data.parallelStream().map(a -> processRecord(a)).count();
	}
	
	public static void main(String[] args) {
		WhaleDataCalculator calculator = new WhaleDataCalculator();
		
		//Define the data
		List<Integer> data = new ArrayList<>();
		for (int i=0; i<4000; i++)
			data.add(i);
		
		System.out.println("Calculator started");
		
		//Process the data
		long start = System.currentTimeMillis();
		calculator.processAllData(data);
		double time = (System.currentTimeMillis() - start)/1000.0;
		
		//Report results
		System.out.println("\nTasks completed in : "+time+" seconds");
		System.out.println("Now : "+new Date());
	}
}
