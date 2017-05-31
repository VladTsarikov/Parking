package by.htp.parking.logic;

import by.htp.parking.entity.ParkPlacePool;
import by.htp.parking.entity.ParkingPlace;

public class Automobile extends Thread {
	
	private boolean reading = false;
	private ParkPlacePool<ParkingPlace> pool;	
	public Automobile (ParkPlacePool<ParkingPlace> pool) {
			this.pool = pool;
	}
	
	public void run() {
		ParkingPlace place = null;
		try {
		place=pool.getResource(500); 
			
		reading = true;
			System.out.println("Authomobile ¹ " + this.getId() + " took place ¹ " + place.getParkPlaceId());
			place.using();
		}
		catch(Exception e){
			System.out.println("Authomobile ¹ " + this.getId() + " went to another parking ->"+ "Timeout exceeded");
		}
		finally{
			if (place != null) {
				reading = false;
			System.out.println("Authomobile ¹ " + this.getId() + "left" + " : " + place.getParkPlaceId() + " place free");
				pool.returnResource(place);
			}
		}
		}
	
	
public boolean isReading() {
		return reading;
	
}

}
