import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;
import static junit.framework.TestCase.assertNotNull;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

public class TestParker {
    Parker parker;
    Car car;

    @Before
    public void setUp() throws Exception {
        parker = new Parker(new NormalChooser());
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
        CarTicket carTicket = parker.park(anotherCar);
        assertThat(parkingLot.pick(carTicket), sameInstance(anotherCar));
    }

    @Test
    public void testShouldNotPickWhenCarNotIn() throws Exception {
        CarTicket carTicket = new CarTicket(car);
        assertNull(parker.pick(carTicket));
    }

    @Test
    public void testReturnSummary() throws Exception {
        assertEquals(0,parker.summarize());
        parker.park(new Car());
        assertEquals(1,parker.summarize());
        parker.addParkingLot(new ParkingLot(2));
        assertEquals(1,parker.summarize());
        parker.park(new Car());
        assertEquals(2,parker.summarize());
    }


    @Test
    public void testReturnDetailReport() throws Exception {
        Parker parkerDetail = new Parker(new NormalChooser());
        parkerDetail.addParkingLot(new ParkingLot(2));
        parkerDetail.addParkingLot(new ParkingLot(1));
        parkerDetail.park(new Car());
        parkerDetail.park(new Car());
        String expectedReport = "Parker: 2";
        Assert.assertEquals(expectedReport, parkerDetail.detailReport());
    }
}
