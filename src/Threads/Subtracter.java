package Threads;

public class Subtracter implements Runnable {
	private Count count;
	public Subtracter(Count count) {
		this.count= count;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<100;i++)
		{
			count.setCount(count.getCount()-1);
//			try {
//				Thread.sleep(1000);
//			}
//			catch(InterruptedException e){
//				e.printStackTrace();
//			}
			System.out.println(count.getCount()+"value set by"+Thread.currentThread().getName());
		}

	}

}
