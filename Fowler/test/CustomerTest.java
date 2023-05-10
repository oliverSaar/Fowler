
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class CustomerTest {

    private final Customer customer = mock(Customer.class);

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void getName() {
        when(customer.getName()).thenReturn("Test");
        assertEquals("Test", customer.getName());
    }
}
