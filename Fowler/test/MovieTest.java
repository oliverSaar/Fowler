
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MovieTest {

    private Movie movie;

    @BeforeEach
    public void setUp() {
        movie = mock(Movie.class);

    }

    @Test
    public void getPriceCode() {
        when(movie.getPriceCode()).thenReturn(0);
        assertEquals(0, movie.getPriceCode());
    }

    @Test
    public void getTitle() {
        when(movie.getTitle()).thenReturn("title");
        assertEquals("title", movie.getTitle());
    }

    @Test
    public void getFrequentRenterPoints() {
        when(movie.getFrequentRenterPoints(0)).thenReturn(1);
        assertEquals(1, movie.getFrequentRenterPoints(0));
    }

    @Test
    public void getCharge() {
        when(movie.getCharge(10)).thenReturn(14.0);
        assertEquals(14.0, movie.getCharge(10), 0);
    }
}
