package puzzle1;

import static org.junit.Assert.*;
import org.junit.Test;

public class Tests {
    @Test
    public void test1validPassword() {
        Solution mySolution = new Solution();
        assertTrue(mySolution.validPassword(111111));
    }

    @Test   
    public void test2validPassword() {
        Solution mySolution = new Solution();
        assertFalse(mySolution.validPassword(223450));
    }

    @Test
    public void test3validPassword() {
        Solution mySolution = new Solution();
        assertFalse(mySolution.validPassword(123789));
    }
}