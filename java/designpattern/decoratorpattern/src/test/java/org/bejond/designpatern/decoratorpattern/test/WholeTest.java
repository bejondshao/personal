package org.bejond.designpatern.decoratorpattern.test;

import org.bejond.designpattern.decoratorpattern.Phone;
import org.bejond.designpattern.decoratorpattern.decorator.PhoneDecorator;
import org.bejond.designpattern.decoratorpattern.decorator.VivoPhoneDecorator;
import org.bejond.designpattern.decoratorpattern.impl.XiaomiPhone;
import org.junit.Test;

public class WholeTest {

	@Test
	public void testDecorator() {

		Phone xiaomiPhone = new XiaomiPhone();
		xiaomiPhone.takePhoto();
		System.out.println("=====================");
		System.out.println("Now let's take some decoratation.");
		System.out.println("=====================");
		PhoneDecorator vivoPhoneDecorator = new VivoPhoneDecorator(xiaomiPhone);
		vivoPhoneDecorator.takePhoto();
	}

}
