import java.util.List;

class SmarterChooser implements ParkingLotChooser {

    @Override
    public ParkingLot findParkingLot(List<ParkingLot> parkingLots) {
        ParkingLot result = new ParkingLot(0);
        for (ParkingLot parkingLot : parkingLots) {
            if(result.getSpace() < parkingLot.getSpace()) {
                result = parkingLot;
            }
        }
        return result;
    }
}
