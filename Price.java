public abstract class Price {
    public abstract int getPriceCode();
    private Rental _rental;

    public double getCharge(int daysRented) {
        double thisAmount = 0;
        switch (_rental.getMovie().getPriceCode()) {
                case Movie.REGULAR:
                    thisAmount += 2;
                    if (_rental.getDaysRented() > 2)
                    thisAmount += (_rental.getDaysRented() - 2) * 1.5;
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount += _rental.getDaysRented() * 3;
                    break;
                case Movie.CHILDRENS:
                    thisAmount += 1.5;
                    if (_rental.getDaysRented() > 3)
                    thisAmount += (_rental.getDaysRented() - 3) * 1.5;
                    break;
                    }
            return thisAmount;
    }
}

