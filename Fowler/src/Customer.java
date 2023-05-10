
import java.util.Enumeration;
import java.util.Vector;

class Customer {
    private String name;
    private Vector<Rental> rentals = new Vector<Rental>();

    public Customer(String newname) {
        name = newname;
    }

    ;

    public void addRental(Rental arg) {
        rentals.addElement(arg);
    }

    ;

    public String getName() {
        return name;
    }

    ;

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration<Rental> enum_rentals = rentals.elements();
        StringBuilder result = new StringBuilder("Rental Record for " + this.getName() + "\n");
        result.append("\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n");

        while (enum_rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental rental = enum_rentals.nextElement();
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
            totalAmount += rental.getCharge();
        }
        //add footer lines
        result.append("Amount owed is ").append(String.valueOf(totalAmount)).append("\n");
        result.append("You earned ").append(String.valueOf(frequentRenterPoints)).append(" frequent renter points");
        return result.toString();
    }

    private double amountFor(Rental rental) {
        return rental.getCharge();
    }

}
