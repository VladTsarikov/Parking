package by.htp.parking.launcher;

import java.util.LinkedList;

import by.htp.parking.entity.ParkPlacePool;
import by.htp.parking.entity.ParkingPlace;
import by.htp.parking.logic.Automobile;

public class Main {

	public static void main(String[] args){
		
		LinkedList<ParkingPlace> list = new LinkedList<ParkingPlace>();
			
		list.add(new ParkingPlace(1));
		list.add(new ParkingPlace(2));
		list.add(new ParkingPlace(3));
		list.add(new ParkingPlace(4));
		list.add(new ParkingPlace(5));
		
		ParkPlacePool<ParkingPlace> pool = new ParkPlacePool<>(list);
				for (int i = 0; i < 20; i++) {
					new Automobile(pool).start();
				}
			}
		}

