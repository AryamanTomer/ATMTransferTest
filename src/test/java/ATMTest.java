import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ATMTest {
    private ATM atm;

    @BeforeEach
    public void setUp() {
        atm = new ATM(1000.00);  // Initialize ATM with $1000 balance
    }

    @Test
    public void testValidTransfer() {
        String result = atm.transferMoney("12345678", 100.00);
        assertEquals("Success: Amount transferred", result);
        assertEquals(900.00, atm.getAccountBalance());
    }

    @Test
    public void testInvalidAccountNumberShort() {
        String result = atm.transferMoney("123", 10.00);
        assertEquals("Error: Invalid destination account", result);
    }

    @Test
    public void testInvalidAccountNumberNonNumeric() {
        String result = atm.transferMoney("abcdefg123", 25.00);
        assertEquals("Error: Invalid destination account", result);
    }

    @Test
    public void testZeroTransferAmount() {
        String result = atm.transferMoney("98765432", 0.00);
        assertEquals("Error: Amount must be greater than 0", result);
    }

    @Test
    public void testNegativeTransferAmount() {
        String result = atm.transferMoney("12345678", -10.00);
        assertEquals("Error: Amount must be greater than 0", result);
    }

    @Test
    public void testTransferExceedingBalance() {
        String result = atm.transferMoney("98765432", 5000000.00);
        assertEquals("Error: Amount exceeds account balance", result);
    }
}
