import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserChoiceTest {

    @Test
    public void userChoiceTest() {
        assertThrows(NullPointerException.class, () -> new UserChoice(null));
    }

    @Test
    public void userChoiceTest2() {
        assertThrows(ChoiceNotValidException.class, () -> new UserChoice("33"));
    }

    @Test
    public void userChoiceTest3() {
        assertThrows(ChoiceNotValidException.class, () -> new UserChoice("77"));
    }

    @Test
    public void userChoiceTest4() {
        assertThrows(ChoiceNotValidException.class, () -> new UserChoice("777"));
    }

    @Test
    public void userChoiceTest5() {
        assertThrows(ChoiceNotValidException.class, () -> new UserChoice("111"));
    }

    @Test
    public void isValidChoice() {
        assertTrue(UserChoice.isValidChoice("00"));
    }

    @Test
    public void isValidChoice2() {
        assertTrue(UserChoice.isValidChoice("22"));
    }

    @Test
    public void isValidChoice3() {
        assertFalse(UserChoice.isValidChoice("33"));
    }

    @Test
    public void isValidChoice4() {
        assertFalse(UserChoice.isValidChoice("000"));
    }

    @Test
    public void isValidChoice5() {
        assertFalse(UserChoice.isValidChoice("777"));
    }

    @Test
    public void isValidDigitTest() {
        assertTrue(UserChoice.isValidDigit('0'));
    }


    @Test
    public void isValidDigitTest2() {
        assertTrue(UserChoice.isValidDigit('1'));
    }


    @Test
    public void isValidDigitTest3() {
        assertTrue(UserChoice.isValidDigit('2'));
    }

    @Test
    public void isValidDigitTest4() {
        assertFalse(UserChoice.isValidDigit('3'));
    }

    @Test
    public void toStringTest() throws ChoiceNotValidException {
        String choice = "00";
        assertEquals("(0, 0)", new UserChoice(choice).toString());
    }

    @Test
    public void toStringTest2() throws ChoiceNotValidException {
        String choice = "21";
        assertEquals("(2, 1)", new UserChoice(choice).toString());
    }
}