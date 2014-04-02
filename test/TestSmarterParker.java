import org.junit.Test;

import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

public class TestSmarterParker {
    @Test
    public void testShouldParkPL1WhenPL1HasMoreSpots() throws Exception {
        ParkingLot pl1 = new ParkingLot(2);
        ParkingLot pl2 = new ParkingLot(4);
        Parker smarterParker = new Parker(new SmarterChooser());
        smarterParker.addParkingLot(pl1);
        smarterParker.addParkingLot(pl2);
        Car car = new Car();
        CarTicket carTicket = smarterParker.park(car);
        assertThat(pl2.pick(carTicket), sameInstance(car));
    }
}
