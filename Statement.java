import java.util.Enumeration;

public abstract class Statement {

    public abstract String getTitle(Customer aCustomer);
    public abstract String getRentedMovies(Rental aRental);
    public abstract String getCustomerInfo(Customer aCustomer);

    public String value(Customer aCustomer){
        Enumeration rentals = aCustomer.getRentals();
        String result = getTitle(aCustomer);
        while (rentals.hasMoreElements()) {
           Rental each = (Rental) rentals.nextElement();
           result +=  getRentedMovies(each);
        }
        //add footer lines
        result += getCustomerInfo(aCustomer);
        return result;
    }
}
