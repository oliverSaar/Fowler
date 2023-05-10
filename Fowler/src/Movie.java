public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    private final String title;
    private int priceCode;


    public Movie(String newtitle, int newpriceCode) {
        title = newtitle;
        setPriceCode(newpriceCode);
    }

    public int getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int arg) {
        Price price;
        switch (arg) {
            case REGULAR -> price = new RegularPrice();
            case CHILDRENS -> price = new ChildrensPrice();
            case NEW_RELEASE -> price = new NewReleasePrice();
            default -> throw new IllegalArgumentException("Incorrect Price Code");
        }
    }


    public double getCharge(int daysRented) {
        double thisAmount = 0;
        switch (getPriceCode()) {
            case Movie.REGULAR -> {
                thisAmount += 2;
                if (daysRented > 2)
                    thisAmount += (daysRented - 2) * 1.5;
            }
            case Movie.NEW_RELEASE -> thisAmount += daysRented * 3;
            case Movie.CHILDRENS -> {
                thisAmount += 1.5;
                if (daysRented > 3)
                    thisAmount += (daysRented - 3) * 1.5;
            }
        }
        return thisAmount;
    }


    public String getTitle() {
        return title;
    }

    int getFrequentRenterPoints(int daysRented) {
        if ((getPriceCode() == Movie.NEW_RELEASE) && daysRented > 1)
            return 2;
        else
            return 1;
    }


}
