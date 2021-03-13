import java.util.Enumeration;

public class TextStatement extends Statement {

    public String getTitle(Customer aCustomer){
        return ("Rental Record for " + aCustomer.getName() + "\n");
    }

    public String getRentedMovies(Rental aRental){
        return ("\t" + aRental.getMovie().getTitle()+ "\t" + String.valueOf(aRental.getCharge()) + "\n");
    }

    public String getCustomerInfo(Customer aCustomer) {
        return(
            "Amount owed is " 
            + String.valueOf(aCustomer.getTotalCharge()) 
            + "\n"
            + "You earned " 
            + String.valueOf(aCustomer.getTotalFrequentRenterPoints()) 
            + " frequent renter points");
    }

    public String value(Customer aCustomer) {
        Enumeration rentals = aCustomer.getRentals();
        String result = "Rental Record for " + aCustomer.getName() + "\n";
        while (rentals.hasMoreElements()) {
        Rental each = (Rental) rentals.nextElement();
        result += "\t" + each.getMovie().getTitle()+ "\t" +
            String.valueOf(each.getCharge()) + "\n";
        }
        result +=  "Amount owed is " + String.valueOf(aCustomer.getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(aCustomer.getTotalFrequentRenterPoints()) +
                " frequent renter points";
        return result;
    }
}

