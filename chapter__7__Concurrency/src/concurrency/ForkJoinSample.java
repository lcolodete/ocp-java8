package concurrency;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class ForkJoinSample {

	public static void main(String[] args) {
		Double[] weights = new Double[10]; 
	
		// 1) Create the task
		ForkJoinTask<?> task = new WeightAnimalAction(weights, 0, weights.length);
		// 2) Create the pool 
		ForkJoinPool pool = new ForkJoinPool();
		// 3) Start the task
		pool.invoke(task);
		
		System.out.println();
		System.out.print("Weights: ");
		Arrays.asList(weights).stream().forEach(d -> System.out.print(d.intValue() + " "));
	}

}

class WeightAnimalAction extends RecursiveAction {

	private Double[] weights;
	private int start;
	private int end;
	
	public WeightAnimalAction(Double[] weights, int start, int end) {
		this.weights = weights;
		this.start = start;
		this.end = end;
	}
	
	@Override
	protected void compute() {
		if (end-start <= 3) {
			for (int i=start; i<end; i++) {
				weights[i] = (double) new Random().nextInt(100);
				System.out.println("Animal weighed: "+i);
			}
		} else {
			int middle = start + ((end-start)/2);
			System.out.println("[start="+start+", middle="+middle+", end="+end+"]");
			invokeAll(new WeightAnimalAction(weights, start, middle), new WeightAnimalAction(weights, middle, end));
		}
		
	}
	
}

