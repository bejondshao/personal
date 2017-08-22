package org.bejond.designpattern.decoratorpattern.decorator;

import org.bejond.designpattern.decoratorpattern.Phone;

public abstract class PhoneDecorator implements Phone {

	protected Phone decoratedPhone;

	public PhoneDecorator(Phone decoratedPhone) {

		this.decoratedPhone = decoratedPhone;
	}

}
