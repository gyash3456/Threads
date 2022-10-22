package mergeSort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class Sorter implements Callable<List<Integer>> {
	List<Integer> arr;
	ExecutorService executor;
	public Sorter(List<Integer>arr,ExecutorService executor) {
		this.arr=arr;
		this.executor=executor;
	}

	@Override
	public List<Integer> call() throws Exception {
		// TODO Auto-generated method stub
		if(arr.size()<=1)
			return arr;
		int mid=arr.size()/2;
		List<Integer> leftArrayList = arr.subList(0, mid);
		List<Integer> rightArrayList = arr.subList(mid, arr.size());
		Sorter leftSorter = new  Sorter(leftArrayList,executor);
		Sorter rightSorter = new Sorter(rightArrayList,executor);
		
		Future<List<Integer>> leftSortedArray= executor.submit(leftSorter);
		Future<List<Integer>> rightSortedArray=executor.submit(rightSorter);
		
		List<Integer> mergedList = merge(leftSortedArray,rightSortedArray);
		return mergedList;
	}
	public List<Integer> merge(Future<List<Integer>>left,Future<List<Integer>>right) throws InterruptedException, ExecutionException{
		List<Integer> mergedList = new ArrayList<Integer>();
		int i=0,j=0;
		List<Integer>sortedLeft= left.get();
		List<Integer>sortedRight=right.get();
		while(i<sortedLeft.size()&&j<sortedRight.size()) {
			if(sortedLeft.get(i)<sortedRight.get(j)) {
				mergedList.add(sortedLeft.get(i));
				i++;
			}
			else {
				mergedList.add(sortedRight.get(j));
				j++;
			}
		}
		while(i<sortedLeft.size()) {
			mergedList.add(sortedLeft.get(i));
			i++;
		}
		while(j<sortedRight.size()) {
			mergedList.add(sortedRight.get(j));
			j++;
		}
		
		return mergedList;
		
	}

}
