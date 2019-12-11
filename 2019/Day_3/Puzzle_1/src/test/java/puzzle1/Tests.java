package puzzle1;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class Tests {
    @Test
    public void test1CalcManhattanDistance() {
        Solution mySolution = new Solution();
        assertEquals(159, mySolution.calcManhattanDistance("test_input_1.txt"));
    }

    @Test
    public void test2CalcManhattanDistance() {
        Solution mySolution = new Solution();
        assertEquals(135, mySolution.calcManhattanDistance("test_input_2.txt"));
    }

    @Test
    public void test3CalcManhattanDistance() {
        Solution mySolution = new Solution();
        assertEquals(6, mySolution.calcManhattanDistance("test_input_3.txt"));
    }
}