package patterns;

public class TestVisitorTicketTracker {

	public static void main(String[] args) {
//		VisitorTicketTracker tracker = VisitorTicketTracker.getInstance();
//		System.out.println("tracker="+tracker);
//		
//		VisitorTicketTracker tracker2 = VisitorTicketTracker.getInstance();
//		System.out.println("tracker2="+tracker2);
//		
//		System.out.println(tracker == tracker2);
//		System.out.println(tracker.equals(tracker2));
		
		startThreads();
	}

	private static void startThreads() {
		Runnable r = () -> {
			System.out.println(Thread.currentThread().getName() + " : begin");
			VisitorTicketTracker tracker = VisitorTicketTracker.getInstance();
			System.out.println(Thread.currentThread().getName() + " : tracker="+tracker);
		};
		
		Thread t1 = new Thread(r);
		t1.setName("t1");
		t1.start();
		
		Thread t2 = new Thread(r);
		t2.setName("t2");
		t2.start();
	}
}
