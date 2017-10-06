package au.com.bywave.randomizer;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class RandomizeUnitTest {

    @Test
    public void unitTest() throws Exception{
        assertEquals(5, Calculator.add(1, 4));
    }


    @Test
    public void unitTest2() throws Exception{
        assertEquals(2, Calculator.sub(4, 2));
    }
}
