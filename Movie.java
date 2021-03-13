public class Movie {

    public static final int  CHILDRENS = 2;
    public static final int  REGULAR = 0;
    public static final int  NEW_RELEASE = 1;
    private Rental _rental;

    private String _title;
    private Price _price;

    public Movie(String title, int priceCode) {
        _title = title;
        setPriceCode(priceCode);
    }

    public int getPriceCode() {
        return _price.getPriceCode();
    }

    public void setPriceCode(int arg) {
        switch (arg) {
           case REGULAR:
              _price = new RegularPrice();
              break;
           case CHILDRENS:
              _price = new ChildrensPrice();
              break;
           case NEW_RELEASE:
              _price = new NewReleasePrice();
              break;
           default:
              throw new IllegalArgumentException("Incorrect Price Code");
        }
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