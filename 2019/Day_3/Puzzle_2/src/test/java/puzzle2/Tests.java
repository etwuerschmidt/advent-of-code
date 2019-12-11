package puzzle2;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class Tests {
    @Test
    public void test1CalcSignalDelay() {
        Solution mySolution = new Solution();
        assertEquals(610, mySolution.calcSignalDelay("test_input_1.txt"));
    }

    @Test
    public void test2CalcSignalDelay() {
        Solution mySolution = new Solution();
        assertEquals(410, mySolution.calcSignalDelay("test_input_2.txt"));
    }

    @Test
    public void test3CalcSignalDelay() {
        Solution mySolution = new Solution();
        assertEquals(30, mySolution.calcSignalDelay("test_input_3.txt"));
    }
}