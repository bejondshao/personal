package org.bejond.designpattern.interpreter;

import org.junit.Test;

public class InterpreterTest {

	@Test
	public void testInterpreter() {

		Person person = new Person("David", 17, Gender.MALE);
		Person person1 = new Person("Julia", 19, Gender.FEMALE);
		Expression expression = new PersonInterpreter();
		System.out.println(person.getName() + " is adult: " + expression.adult(person));
		System.out.println(person.getName() + " is male: " + expression.male(person));
		System.out.println(person1.getName() + " is adult: " + expression.adult(person1));
		System.out.println(person1.getName() + " is male: " + expression.male(person1));
	}
}
