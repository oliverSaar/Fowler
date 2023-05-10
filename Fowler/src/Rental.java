class Rental {
    private final Movie movie;
    private final int daysRented;

    public Rental(Movie newmovie, int newdaysRented) {
        movie = newmovie;
        daysRented = newdaysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public double getCharge() {
        double thisAmount = 0;
        switch (getMovie().getPriceCode()) {
            case Movie.REGULAR -> {
                thisAmount += 2;
                if (getDaysRented() > 2)
                    thisAmount += (getDaysRented() - 2) * 1.5;
            }
            case Movie.NEW_RELEASE -> thisAmount += getDaysRented() * 3;
            case Movie.CHILDRENS -> {
                thisAmount += 1.5;
                if (getDaysRented() > 3)
                    thisAmount += (getDaysRented() - 3) * 1.5;
            }
        }
        return thisAmount;
    }

    public Movie getMovie() {
        return movie;
    }
}
