package register_Tests;

import org.junit.jupiter.api.Test;

import pLData.ParkingLot;
import register.CashRegister;
import register.Ticket;
import vehicleH.Vehicle;
import vehicleH.VehicleType;

class CashRegisterT {
	public ParkingLot pL = new ParkingLot(1, 1, 1);
	public Vehicle v1 = new Vehicle("123-4567", VehicleType.CAR);
	public CashRegister cr = new CashRegister();
	@Test
	void testCashRegister() throws InterruptedException {
		
	}

}
