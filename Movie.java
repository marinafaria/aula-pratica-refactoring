public class Movie {

    public static final int  CHILDRENS = 2;
    public static final int  REGULAR = 0;
    public static final int  NEW_RELEASE = 1;
    private Rental _rental;

    private String _title;
    private int _priceCode;

    public Movie(String title, int priceCode) {
        _title = title;
        _priceCode = priceCode;
    }

    public int getPriceCode() {
        return _priceCode;
    }

    public void setPriceCode(int arg) {
        _priceCode = arg;
    }

    public String getTitle (){
        return _title;
    }

    public double getCharge(int daysRented){
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

    public int getFrequentRenterPoints(int daysRented){
        if ((_rental.getMovie().getPriceCode() == Movie.NEW_RELEASE)
        && _rental.getDaysRented() > 1) return 2;
        return 1;
    }
}