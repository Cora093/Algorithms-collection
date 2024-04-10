package test;

import org.junit.jupiter.api.Test;
import suixianglu.backtracking.Bt04;

class Bt04Test {


    @Test
    void testCombinationSum3() {
        Bt04 bt04 = new Bt04();
        System.out.println(bt04.combinationSum3(3, 7));
        bt04.clearRes();
        System.out.println(bt04.combinationSum3(3, 9));
        bt04.clearRes();
        System.out.println(bt04.combinationSum3(3, 13));
        bt04.clearRes();

    }
}