package com.vandana.sample;

import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class SanityTest {

    @Test
    public void testSanity() {
        // Simple test to verify TestNG and build configuration
        assertTrue(true, "Sanity check should always pass");
    }


}



