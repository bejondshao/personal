package org.bejond.designpattern.interpreter;

public class PersonInterpreter implements Expression {

	@Override
	public boolean adult(Object object) {

		if (object instanceof Person) {
			if(((Person) object).getAge() > 18) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean male(Object object) {

		if (object instanceof Person) {
			if(((Person) object).getGender() == Gender.MALE) {
				return true;
			}
		}
		return false;
	}
}
