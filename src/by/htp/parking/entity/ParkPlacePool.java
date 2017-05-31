package by.htp.parking.entity;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class ParkPlacePool <T> {

	private final static int POOL_SIZE = 5; 
	
	private final Semaphore semaphore = new Semaphore(POOL_SIZE, true);
		
	private final Queue<T> resources = new LinkedList<T>();
		
	public ParkPlacePool(Queue<T> source) {		
			resources.addAll(source);	
		}
		
	public T getResource(long maxWaitMillis){	
		
				try {
					if (semaphore.tryAcquire(maxWaitMillis, TimeUnit.MILLISECONDS)) {
						T res = resources.poll();
						return res;
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return null;
	}
			
	public void returnResource(T res) {
			resources.add(res); 
			semaphore.release();
		}
	}


