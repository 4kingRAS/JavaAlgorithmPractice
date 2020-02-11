package com.unitest;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * @author Yulin.Wang
 * @date 2020/2/11
 * @description
 */

public class UnitTest {

    private String msg = "dadsads";
    private Unit unit = new Unit(this.msg, 2);

    @Test
    public void testPrint() {
        assertEquals(msg, unit.print());
    }

}
