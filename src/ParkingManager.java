import java.util.ArrayList;
import java.util.List;

public class ParkingManager implements Parkable {
    private List<Parkable> parkerList = new ArrayList<Parkable>();

    public void add(Parkable parker) {
        parkerList.add(parker);
    }

    public CarTicket park(Car car) {
        for (Parkable parker : parkerList) {
            CarTicket carTicket = parker.park(car);
            if (carTicket != null) {
                return carTicket;
            }
        }
        return null;
    }

    public Car pick(CarTicket carTicket) {
        for (Parkable parker : parkerList) {
            Car car = parker.pick(carTicket);
            if (car != null) {
                return car;
            }
        }
        return null;
    }

    @Override
    public int summarize() {
        int result=0;
        for (Parkable parkable : parkerList) {
            result += parkable.summarize();
        }
        return result;
    }

    @Override
    public String detailReport() {
        String result = "ParkingManager: " + String.valueOf(summarize());
        for (Parkable parkable : parkerList) {
            result += "\n" + parkable.detailReport();
        }
        return result.replace("\n", "\n__");
    }
}
