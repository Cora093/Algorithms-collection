package test;

import org.junit.Test;
import suixianglu.backtracking.Bt02;

public class Bt02Test {

    Bt02 bt02 = new Bt02();

    @Test
    public void testCombine() {

        System.out.println(bt02.combine(4, 2));
        bt02.clearResult();
        System.out.println(bt02.combine(1, 1));
        bt02.clearResult();
        System.out.println(bt02.combine(9, 3));
    }

}