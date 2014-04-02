import java.util.List;

class SmarterChooser implements ParkinglotChooser {
    public ParkingLot findParkinglot(List<ParkingLot> parkingLots) {
        ParkingLot result = new ParkingLot(0);
        for (ParkingLot parkingLot : parkingLots) {
            if(result.getSpace() < parkingLot.getSpace()) {
                result = parkingLot;
            }
        }
        return result;
    }
}
