package by.htp.parking.entity;

public class ParkingPlace {
	
	private int ParkPlaceId;
	
	public ParkingPlace(int id) {
			super();
			this.ParkPlaceId = id;
		}
		
	public int getParkPlaceId() {
		return ParkPlaceId;
	}

	public void setParkPlaceId(int parkPlaceId) {
		ParkPlaceId = parkPlaceId;
	}

	public void using() {
			try {
				Thread.sleep(new java.util.Random().nextInt(500));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	
	
	

