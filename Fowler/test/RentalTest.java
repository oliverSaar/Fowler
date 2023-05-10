
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RentalTest {

    private Rental rental;
    private Movie movie;

    @BeforeEach
    public void setUp() {
        movie = mock(Movie.class);
        rental = mock(Rental.class);
    }

    @Test
    public void getDaysRented() {
        when(rental.getDaysRented()).thenReturn(10);
        assertEquals(10, rental.getDaysRented());
    }

    @Test
    public void getMovie() {
        when(rental.getMovie()).thenReturn(movie);
        assertEquals(movie, rental.getMovie());
    }

    @Test
    public void getFrequentRenterPoints() {
        when(rental.getFrequentRenterPoints(1)).thenReturn(1);
        assertEquals(1, rental.getFrequentRenterPoints(1));
    }

    @Test
    public void getCharge() {
        when(rental.getCharge()).thenReturn(14.0);
        assertEquals(14.0, rental.getCharge(), 0);
    }
}
