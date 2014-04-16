import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

public class TestParkingManager {

    private Parker parker;
    private ParkingLot parkingLot;
    private Car car;
    private ParkingManager manager;

    @Before
    public void setUp() throws Exception {
        car = new Car();
        parkingLot = new ParkingLot(1);
        parker = new Parker(new NormalChooser());
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

    @Test
    public void testReturnSummary() throws Exception {
        parker.addParkingLot(parkingLot);
        manager.add(parker);

        assertEquals(0, manager.summarize());
        manager.park(new Car());
        assertEquals(1,manager.summarize());

        Parker anotherPaker = new Parker(new NormalChooser());
        anotherPaker.addParkingLot(new ParkingLot(2));
        manager.add(anotherPaker);
        assertEquals(1,manager.summarize());
        manager.park(new Car());
        assertEquals(2,manager.summarize());
    }

    @Test
    public void testReturnReport() throws Exception {
        parker.addParkingLot(parkingLot);
        manager.add(parker);

        assertEquals("ParkingManager: 0",manager.report());
        manager.park(new Car());
        assertEquals("ParkingManager: 1",manager.report());

        Parker anotherPaker = new Parker(new NormalChooser());
        anotherPaker.addParkingLot(new ParkingLot(2));
        manager.add(anotherPaker);
        assertEquals("ParkingManager: 1",manager.report());
        manager.park(new Car());
        assertEquals("ParkingManager: 2",manager.report());
    }

    @Test
    public void testReturnEmptyDetailReport() throws Exception {
        ParkingManager parkingManagerDetail = new ParkingManager();
        Parker parker1 = new Parker(new NormalChooser());
        Parker parker2 = new Parker(new NormalChooser());
        parker1.addParkingLot(new ParkingLot(2));
        parker1.addParkingLot(new ParkingLot(1));
        parker2.addParkingLot(new ParkingLot(1));
        parkingManagerDetail.add(parker1);
        parkingManagerDetail.add(parker2);

        String emptyExpected = "ParkingManager: 0\n" +
                "__Parker: 0\n" +
                "____ParkingLot: 0\n" +
                "____ParkingLot: 0\n" +
                "__Parker: 0\n" +
                "____ParkingLot: 0";
        Assert.assertEquals(emptyExpected, parkingManagerDetail.detailReport());
    }

    @Test
    public void testReturnDetailReport() throws Exception {
        ParkingManager parkingManagerDetail = new ParkingManager();
        Parker parker1 = new Parker(new NormalChooser());
        Parker parker2 = new Parker(new NormalChooser());
        parker1.addParkingLot(new ParkingLot(2));
        parker1.addParkingLot(new ParkingLot(1));
        parker2.addParkingLot(new ParkingLot(1));
        parker2.addParkingLot(new ParkingLot(2));
        parkingManagerDetail.add(parker1);
        parkingManagerDetail.add(parker2);
        parkingManagerDetail.park(new Car());
        parkingManagerDetail.park(new Car());
        parkingManagerDetail.park(new Car());
        parkingManagerDetail.park(new Car());

        String emptyExpected = "ParkingManager: 4\n" +
                "__Parker: 3\n" +
                "____ParkingLot: 2\n" +
                "____ParkingLot: 1\n" +
                "__Parker: 1\n" +
                "____ParkingLot: 0\n" +
                "____ParkingLot: 1";
        Assert.assertEquals(emptyExpected, parkingManagerDetail.detailReport());
    }
}
