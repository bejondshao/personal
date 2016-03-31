package com.bejond.test;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * Created by bejond on 16-3-24.
 */
public class TestPhantomRefQueue {

   public static void main(String[] args)
			throws InterruptedException {

      Object obj = new Object();
      final ReferenceQueue queue = new ReferenceQueue();

      PhantomReference pRef =
		new PhantomReference(obj,queue);

      obj = null;

      new Thread(new Runnable() {
         public void run() {
           try {
             System.out.println("Awaiting for GC");

  	     // This will block till it is GCd
             PhantomReference pRef =
		(PhantomReference) queue.remove();

             System.out.println("Referenced GC'd");

            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
        }).start();

        // Wait for 2nd thread to start
        Thread.sleep(2000);

        System.out.println("Invoking GC");
        System.gc();
    }
}

