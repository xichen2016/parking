import org.junit.Test;

import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

public class TestGeniusParker {
    @Test
    public void testShouldParkPL1WhenPL1HasMostEmptyRatio() throws Exception {
        ParkingLot pl1 = new ParkingLot(4);
        pl1.park(new Car());
        ParkingLot pl2 = new ParkingLot(2);
        Parker geniusParker = new Parker(new GeniusChooser());
        geniusParker.addParkingLot(pl1);
        geniusParker.addParkingLot(pl2);
        Car car = new Car();
        CarTicket carTicket = geniusParker.park(car);
        assertThat(pl2.pick(carTicket), sameInstance(car));
    }
}
