import java.util.ArrayList;
import java.util.List;

public class Parker {
    List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();

    public CarTicket park(Car car) {
        for (ParkingLot parkingLot : parkingLots) {
            CarTicket ticket = parkingLot.park(car);
            if (ticket != null) {
                return ticket;
            }
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
