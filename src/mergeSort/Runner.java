package mergeSort;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Runner {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		List<Integer> arr= List.of(4,3,2,1,9,8,7,6);
		ExecutorService executor = Executors.newCachedThreadPool();
		Sorter sorter = new Sorter(arr,executor);
		Future<List<Integer>>finalList= executor.submit(sorter);
		System.out.println(finalList.get());
		

	}

}
