import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

public class TestParkingManager {

    private Parker parker;
    private ParkingLot parkingLot;
    private Car car;
    private ParkingManager manager;

    @Before
    public void setUp() throws Exception {
        parker = new Parker(new NormalChooser());
        parkingLot = new ParkingLot(1);
        car = new Car();
        manager = new ParkingManager();
    }

    @Test
    public void shouldParkWhenHasEmptyLot() throws Exception {
        parker.addParkingLot(parkingLot);
        manager.add(parker);
        CarTicket carTicket = manager.park(car);
        assertThat(parkingLot.pick(carTicket), sameInstance(car));
    }

    @Test
    public void shouldPickWhenCarIsIn() throws Exception {
        parker.addParkingLot(parkingLot);
        manager.add(parker);
        CarTicket carTicket = parkingLot.park(car);
        assertThat(manager.pick(carTicket), sameInstance(car));
    }
}
