import java.util.List;

class GeniusChooser implements ParkingLotChooser {

    @Override
    public ParkingLot findParkingLot(List<ParkingLot> parkingLots) {
        ParkingLot result = parkingLots.get(0);
        for (int i = 1; i < parkingLots.size(); i++) {
            if (result.getEmptyRatio() < parkingLots.get(i).getEmptyRatio()) {
                result = parkingLots.get(i);
            }
        }
        return result;
    }
}
