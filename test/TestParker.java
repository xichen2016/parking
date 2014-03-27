import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertNotNull;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

public class TestParker {
    Parker parker;
    Car car;

    @Before
    public void setUp() throws Exception {
        parker = new Parker();
        car = new Car();
        parker.addParkingLot(new ParkingLot(1));
    }

    @Test
    public void testShouldParkWhenNotFull() throws Exception {
        assertNotNull(parker.park(car));
    }

    @Test
    public void testShouldPickWhenHaveTicket() throws Exception {
        CarTicket ticket = parker.park(car);
        assertThat(parker.pick(ticket), sameInstance(car));
    }

    @Test
    public void testShouldParkWhenFirstFullSecondNotFull() throws Exception {
        parker.park(car);
        ParkingLot parkingLot = new ParkingLot(1);
        parker.addParkingLot(parkingLot);
        Car anotherCar = new Car();
        parker.park(anotherCar);
        assertTrue(parkingLot.getCars().contains(anotherCar));
    }
}
