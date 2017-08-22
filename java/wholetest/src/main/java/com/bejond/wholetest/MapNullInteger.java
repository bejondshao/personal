package com.bejond.wholetest;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class MapNullInteger {

    @Test
    public void testMapNullInteger() {

        Map<String, Integer> map = new HashMap<>();
        // int a = map.get("asdf"); // NPE
        int a = 0;
        if (map.containsKey("asdf")) {
            a = map.get("asdf");
        }
        System.out.println(a);
    }

}
