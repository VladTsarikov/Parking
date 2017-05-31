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
		ParkingPlace place = pool.getResource(500); 
			reading = true;
			System.out.println("Authomobile place ¹ " + this.getId()
				
+ " took channel #" + place.getParkPlaceId());
			place.using();
		
			if (place != null) {
				reading = false;
			System.out.println("Authomobile place ¹ " + this.getId() + " : "
				
+ place.getParkPlaceId() + " place released");
				pool.returnResource(place);
			}
		}
	
	
public boolean isReading() {
		return reading;
	
}

}
