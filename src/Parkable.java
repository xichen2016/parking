public interface Parkable {
    CarTicket park(Car car);

    Car pick(CarTicket ticket);

    int summarize();

    String report();

    String detailReport();
}
