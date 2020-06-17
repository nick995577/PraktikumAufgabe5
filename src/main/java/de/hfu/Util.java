package de.hfu;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Util {

	public static boolean istErstesHalbjahr(int monat){
		if ((monat < 1) || (monat > 12)) throw new IllegalArgumentException();
		if(monat <= 7) return true;
		return false;
	}
	
	@Test
    public void testIstErstesHalbjahr() {        
        assertEquals(true, istErstesHalbjahr(1));
    }

}
