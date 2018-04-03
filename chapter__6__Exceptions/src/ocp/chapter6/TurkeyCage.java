package ocp.chapter6;


public class TurkeyCage implements AutoCloseable {

	public void close() throws Exception {
		System.out.println("cage closed!");
	}
	
	public static void main(String[] args) throws Exception {
		try (TurkeyCage cage = new TurkeyCage()) {
			System.out.println("put turkey in");
		}
	}
}
