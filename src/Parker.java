import java.util.ArrayList;
import java.util.List;

public class Parker implements Parkable {
    protected List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
    private ParkingLotChooser parkingLotChooser;

    public Parker(ParkingLotChooser parkingLotChooser) {
        this.parkingLotChooser = parkingLotChooser;
    }

    @Override
    public CarTicket park(Car car) {
        ParkingLot result = parkingLotChooser.findParkingLot(parkingLots);
        CarTicket ticket = result.park(car);
        if (ticket != null) {
            return ticket;
        }
        return null;
    }

    @Override
    public Car pick(CarTicket ticket) {
        for (ParkingLot parkingLot : parkingLots) {
            Car car = parkingLot.pick(ticket);
            if (car != null) {
                return car;
            }
        }
        return null;
    }

    @Override
    public int summarize() {
        int result=0;
        for (ParkingLot parkingLot : parkingLots) {
            result += parkingLot.summarize();
        }
        return result;
    }

    @Override
    public String report() {
        return "Parker: " + String.valueOf(summarize());
    }

    @Override
    public String detailReport() {
        String result = report();
//        for (ParkingLot parkingLot : parkingLots) {
//            result += "\n";
//            result += "__" + parkingLot.detailReport();
//        }
        return result;
    }

    public void addParkingLot(ParkingLot parkingLot) {
        parkingLots.add(parkingLot);
    }
}
