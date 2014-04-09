import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

public class TestSuperManager {
    private Parker parker;
    private ParkingLot parkingLot;
    private Car car;
    private ParkingManager parkingManager;
    private ParkingManager superManager;

    @Before
    public void setUp() throws Exception {
        parker = new Parker(new NormalChooser());
        parkingLot = new ParkingLot(1);
        car = new Car();
        superManager = new ParkingManager();
        parkingManager = new ParkingManager();
    }

    @Test
    public void shouldParkWhenHasEmptyLot() throws Exception {
        parker.addParkingLot(parkingLot);
        parkingManager.add(parker);
        superManager.add(parkingManager);
        CarTicket carTicket = superManager.park(car);
        assertThat(parkingLot.pick(carTicket), sameInstance(car));
    }

    @Test
    public void shouldPickWhenCarIsIn() throws Exception {
        parker.addParkingLot(parkingLot);
        parkingManager.add(parker);
        superManager.add(parkingManager);
        CarTicket carTicket = parkingLot.park(car);
        assertThat(superManager.pick(carTicket), sameInstance(car));
    }
}
