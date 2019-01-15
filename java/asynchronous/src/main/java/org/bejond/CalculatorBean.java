package org.bejond;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import java.util.Date;
import java.util.concurrent.Future;

@Stateless
@Asynchronous
public class CalculatorBean {
	public Future<Integer> asyncAdd(StringBuilder sb, int num1, int num2) {

		sb.append("start running asyncAdd in thread " + Thread.currentThread().getName() + "<br/>");
		try {

			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("Error occured while trying to make this thread asleep.");
			e.printStackTrace();
		}
		int result = num1 + num2;
		sb.append("Addition calculation is finished: " + new Date() + "<br/>");
		sb.append("Finished running asyncAdd in thread " + Thread.currentThread().getName()+ "<br/>");
		return new AsyncResult<Integer>(result);
	}

	public Future<Integer> asyncSubtract(StringBuilder sb, int num1, int num2) {

		sb.append("Start running asyncSubtract in thread " + Thread.currentThread().getName()+"<br/>");
		try {

// sleep to pretend this calculation needs some time to finish
			Thread.sleep(2000);
		} catch(InterruptedException e) {
			System.out.println("Error occured while trying to make this thread asleep.");
			e.printStackTrace();
		}
		int result = num1 - num2;
		sb.append("Subtraction calculation is finished: " + new Date() + "<br/>");
		sb.append("Finished running asyncSubtract in thread " + Thread.currentThread().getName()+ "<br/>");
		return new AsyncResult<Integer>(result);

	}
}
