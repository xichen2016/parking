import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class TestParker {
    Parker parker = new Parker();
    Car car = new Car();

    @Before
    public void setUp() throws Exception {
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
        parker.park(new Car());
        assertNull(parker.park(car));
        parker.addParkingLot(new ParkingLot(1));
        assertNotNull(parker.park(car));
    }
}
