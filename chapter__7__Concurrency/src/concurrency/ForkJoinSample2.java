package concurrency;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class ForkJoinSample2 {

	public static void main(String[] args) {
		Double[] weights = new Double[10]; 
	
		// 1) Create the task
		ForkJoinTask<Double> task = new WeightAnimalTask(weights, 0, weights.length);
		// 2) Create the pool 
		ForkJoinPool pool = new ForkJoinPool();
		// 3) Start the task
		Double sum = pool.invoke(task);
		
		System.out.println();
		System.out.print("Weights: ");
		Arrays.asList(weights).stream().forEach(d -> System.out.print(d.intValue() + " "));
		System.out.println("Sum: "+sum);
	}

}

class WeightAnimalTask extends RecursiveTask<Double> {

	private Double[] weights;
	private int start;
	private int end;
	
	public WeightAnimalTask(Double[] weights, int start, int end) {
		this.weights = weights;
		this.start = start;
		this.end = end;
	}

	@Override
	protected Double compute() {
		if (end-start <= 3) {
			double sum = 0;
			for (int i=start; i<end; i++) {
				weights[i] = (double) new Random().nextInt(100);
				System.out.println("Animal weighed: "+i);
				sum += weights[i];
			}
			return sum;
		} 
		int middle = start + ((end-start)/2);
		System.out.println("[start="+start+", middle="+middle+", end="+end+"]");
		//invokeAll(new WeightAnimalAction(weights, start, middle), new WeightAnimalAction(weights, middle, end));
		ForkJoinTask<Double> otherTask = new WeightAnimalTask(weights, start, middle);
		otherTask.fork();
		return new WeightAnimalTask(weights, middle, end).compute() + otherTask.join();
		
	}

	
}

