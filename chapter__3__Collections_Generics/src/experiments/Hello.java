package experiments;

public class Hello<T> {

	T t;
	public Hello(T t) {
		this.t = t;
	}
	
	public String toString() {
		return this.t.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(new Hello<String>("hi"));
		System.out.println( new Hello("there") );
	}
}
