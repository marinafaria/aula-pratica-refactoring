public abstract class Price {
    private Rental _rental;

    public abstract int getPriceCode();
    public abstract double getCharge(int daysRented);

    public int getFrequentRenterPoints(int daysRented) {
        if ((_rental.getMovie().getPriceCode() == Movie.NEW_RELEASE)
        && _rental.getDaysRented() > 1) return 2;
        return 1;

     }
}

