package de.hfu;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UtilTest {

	
	@Test
    public void testIstErstesHalbjahr() {        
        assertEquals(true, Util.istErstesHalbjahr(1));
    }

}
