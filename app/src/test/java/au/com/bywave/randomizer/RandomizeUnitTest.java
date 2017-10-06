package au.com.bywave.randomizer;

import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertEquals;

public class RandomizeUnitTest {

    @Test
    public void unitTest() throws Exception{
        assertEquals(5, Calculator.add(1, 4));
        assertFalse(5 == 6);
    }
}
