import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private int capacity;
    private List<Car> cars = new ArrayList<Car>();

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public CarTicket park(Car car) {
        if (this.cars.size() >= this.capacity){
            return null;
        }
        cars.add(car);
        return new CarTicket(car);
    }

    public Car pick(CarTicket ticket) {
        Car car = ticket.getCar();
        if(cars.contains(car)){
            cars.remove(car);
            return car;
        }

        return null;
    }

    public int getSpace() {
        return capacity - cars.size();
    }

    public double getEmptyRatio() {
        return 1 - cars.size() / (double)capacity;
    }

    public int summarize() {
        return cars.size();
    }

    public String report() {
        return "____ParkingLot: " + String.valueOf(summarize());
    }

    public String detailReport() {
        return report();
    }
}
