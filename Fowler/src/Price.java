abstract class Price {
    abstract int getPriceCode();

    public abstract double getCharge(int daysRented);

    int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
