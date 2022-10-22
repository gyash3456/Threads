package Threads;
public class UseThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++) {
		Printer printer = new Printer(String.valueOf(i));
		Thread thread = new Thread(printer);
		thread.start();
		}
	}

}
