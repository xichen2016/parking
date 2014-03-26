import org.junit.Test;

import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.*;

public class TestParking {
    ParkingLot parkingLot = new ParkingLot(1);
    Car car = new Car();

    @Test
    public void testCanParkWhenNotFull() throws Exception {
        CarTicket ticket = parkingLot.park(car);
        assertThat(parkingLot.pick(ticket), sameInstance(car));
    }

    @Test
    public void testCantParkWhenFull() throws Exception {
        parkingLot.park(car);
        Car anotherCar = new Car();
        CarTicket anotherTicket = parkingLot.park(anotherCar);
        assertNull(anotherTicket);
    }

    @Test
    public void testParkAndParkAgainWhenNotFull() throws Exception {
        ParkingLot parkingLot = new ParkingLot(2);
        parkingLot.park(car);
        Car anotherCar = new Car();
        CarTicket anotherTicket = parkingLot.park(anotherCar);
        assertThat(parkingLot.pick(anotherTicket), sameInstance(anotherCar));
    }

    @Test
    public void testCanPickCarWhenCarIn() throws Exception {
        CarTicket carTicket = parkingLot.park(car);
        assertThat(parkingLot.pick(carTicket), sameInstance(car));
    }

    @Test
    public void testCantPickCarWhenCarNotIn() throws Exception {
        parkingLot.park(car);
        CarTicket carTicket = new CarTicket(new Car());
        assertEquals(parkingLot.pick(carTicket), null);
    }

    @Test
    public void testCanParkAndPickOneCarForManyTimes() throws Exception {
        CarTicket carTicket = parkingLot.park(car);
        parkingLot.pick(carTicket);
        assertNotNull(parkingLot.park(car));
    }
}
