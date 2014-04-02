import java.util.List;

class NormalParkinglotChooser implements ParkinglotChooser {
    @Override
    public ParkingLot findParkinglot(List<ParkingLot> parkingLots) {
        ParkingLot result = parkingLots.get(0);
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getSpace() != 0) {
                result = parkingLot;
            }
        }
        return result;
    }
}
