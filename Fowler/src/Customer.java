
import java.util.Enumeration;
import java.util.Vector;

class Customer {
    private final String name;
    private final Vector<Rental> rentals = new Vector<>();

    public Customer(String newname) {
        name = newname;
    }


    public void addRental(Rental arg) {
        rentals.addElement(arg);
    }


    public String getName() {
        return name;
    }

    public String getTotalCharge() {
        return "";
    }

    public String statement() {
        int frequentRenterPoints = 0;
        Enumeration<Rental> rentals = this.rentals.elements();
        StringBuilder result = new StringBuilder("Rental Record for " + this.getName() + "\n");
        result.append("\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n");

        while (rentals.hasMoreElements()) {
            double thisAmount;
            Rental rental = rentals.nextElement();

            // add frequentrenterpoints
            frequentRenterPoints += rental.getFrequentRenterPoints(rental.getDaysRented());

            //bonus for two-day new release rental

            //determine amounts for each line

            thisAmount = rental.getCharge();

            switch (rental.getMovie().getPriceCode()) {
                case Movie.REGULAR -> {
                    thisAmount += 2;
                    if (rental.getDaysRented() > 2)
                        thisAmount += (rental.getDaysRented() - 2) * 1.5;
                }
                case Movie.NEW_RELEASE -> thisAmount += rental.getDaysRented() * 3;
                case Movie.CHILDRENS -> {
                    thisAmount += 1.5;
                    if (rental.getDaysRented() > 3)
                        thisAmount += (rental.getDaysRented() - 3) * 1.5;
                }
            }


            // add frequent renter points
            frequentRenterPoints++;
            // add bonus for a two-day new release rental
            if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && rental.getDaysRented() > 1)
                frequentRenterPoints++;
            //show figures for this rental
            result.append("\t").append(rental.getMovie().getTitle()).append("\t").append("\t").append(rental.getDaysRented()).append("\t").append(rental.getCharge()).append("\n");

        }
        //add footer lines
        result.append("Amount owed is ").append(getTotalCharge()).append("\n");
        result.append("You earned ").append(String.valueOf(frequentRenterPoints)).append(" frequent renter points");
        return result.toString();
    }

}
