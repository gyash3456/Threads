package Threads;

public class UseAdderSubtracter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Count count =new Count(0);
		Adder add = new Adder(count);
		Subtracter sub = new Subtracter(count);
		Thread t1 = new Thread(add);
		Thread t2 = new Thread(sub);
		t1.start();
		t2.start();
		try {
		Thread.sleep(1000);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("final value of count="+count.getCount());
		}

}
