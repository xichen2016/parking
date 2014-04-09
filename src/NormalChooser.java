import java.util.List;

class NormalChooser implements ParkingLotChooser {

    @Override
    public ParkingLot findParkingLot(List<ParkingLot> parkingLots) {
        ParkingLot result = parkingLots.get(0);
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getSpace() != 0) {
                result = parkingLot;
            }
        }
        return result;
    }
}
