package com.bejond.AOP;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import java.util.Date;

/**
 * Created by bejond on 16-2-15.
 */
@Aspect
public class Logger {
	@Before(value="execution(public void com.bejond.DAO.impl.UserDAOImpl.save(com.bejond.model.User))")
	public void beforeMethod() {
		System.out.println("We are doing things before invoke method.");
		setDate1(new Date());
		System.out.println(getDate1());
	}

	@After("execution(public * com.bejond.DAO.impl.*.*(..))")
	public void afterMethod() {
		System.out.println("We are doing things after invoke method.");
		setDate2(new Date());
		System.out.println(getDate2());
	}

	public Date getDate1() {
		return date1;
	}

	public Date getDate2() {
		return date2;
	}

	public void setDate1(Date date1) {
		this.date1 = date1;
	}

	public void setDate2(Date date2) {
		this.date2 = date2;
	}

	private Date date1;
	private Date date2;
}
