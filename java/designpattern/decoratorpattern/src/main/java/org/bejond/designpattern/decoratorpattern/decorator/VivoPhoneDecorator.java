package org.bejond.designpattern.decoratorpattern.decorator;

import org.bejond.designpattern.decoratorpattern.Phone;

public class VivoPhoneDecorator extends PhoneDecorator {

	public VivoPhoneDecorator(Phone decoratedPhone) {

		super(decoratedPhone);
	}

	@Override
	public void takePhoto() {

		prepare();
		decoratedPhone.takePhoto();
		thinnerFace(decoratedPhone);
	}

	private void prepare() {

		System.out.println("Let's take some preparation.");
	}

	private void thinnerFace(Phone decoratedPhone) {

		System.out.println("This phone can make your face thinner. It's done by Vivo.");
	}

}
