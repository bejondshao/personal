package org.bejond.wholetest;

/**
 * Created by bejond on 16-4-1.
 */

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class OOMHeapTest {
    public static void main(String[] args){
        oom();
    }

    private static void oom(){
        Map<String, Pilot> map = new HashMap<String, Pilot>();
        Object[] array = new Object[100000000];
        for(int i=0; i<100000000; i++){
            String d = new Date().toString();
            Pilot p = new Pilot(d, i);
            map.put(i+"rosen jiang", p);
            array[i]=p;
        }
	    System.out.println("finished");
    }
}