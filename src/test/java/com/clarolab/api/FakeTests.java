package com.clarolab.api;

import org.junit.Ignore;
import org.junit.Test;

public class FakeTests {

    @Test
    public void testPasses() {
        assert true;
    }

    @Test
    public void testFails() {
        assert false;
    }

    @Test
    @Ignore
    public void testIgnored() {
        assert true;
    }

}
