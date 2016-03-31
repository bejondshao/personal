package com.bejond.test;

import java.lang.ref.SoftReference;

/**
 * Created by bejond on 16-3-24.
 */
public class TestSoftRef {
    public static void main(String[] args) {

        // Initial Strong Ref
        Object obj = new Object();
        System.out.println("Instance : " + obj);

       // Make a Soft Reference on obj
        SoftReference<Object> softReference =
                    new SoftReference<Object>(obj);

        // Make obj eligible for GC !
        obj = null;

        System.gc();    // Run GC

        // should be null if GC collected
        System.out.println("Instance : " + softReference.get());
    }
}