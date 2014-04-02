import java.util.ArrayList;
import java.util.List;

public class Parker {
    protected List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
    private ParkinglotChooser normalParkinglotChooser;

    public Parker(ParkinglotChooser normalParkinglotChooser) {
        this.normalParkinglotChooser = normalParkinglotChooser;
    }

    public CarTicket park(Car car) {
        ParkingLot result = normalParkinglotChooser.findParkinglot(parkingLots);
        CarTicket ticket = result.park(car);
        if (ticket != null) {
            return ticket;
        }
        return null;
    }

    public Car pick(CarTicket ticket) {
        for (ParkingLot parkingLot : parkingLots) {
            Car car = parkingLot.pick(ticket);
            if (car != null) {
                return car;
            }
        }
        return null;
    }

    public void addParkingLot(ParkingLot parkingLot) {
        parkingLots.add(parkingLot);
    }
}
