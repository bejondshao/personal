/******************************************************************************                                        
 *  Compilation:  javac Calculator.java                                                                                
 *  Execution:    java Calculator                                                                                      
 *  Dependencies: FlexStack.java                                                                                           
 *
 *  Adapted from EvaluteDeluxe.java at                                                                                 
 *    https://algs4.cs.princeton.edu/13stacks/EvaluateDeluxe.java.html                                                 
 *
 *  A command-line four-function calculator that evaluates arithmetic                                                  
 *  expressions using Dijkstra's two-stack algorithm.                                                                  
 *  Handles the following binary operators: +, -, *, / and parentheses.                                                
 *
 *  Limitation                                                                                                       
 *  --------------                                                                                                     
 *    -  can add additional operators and precedence orders, but they                                                  
 *       must be left associative (exponentiation is right associative)                                                
 *
 *  Improvement
 *  --------------
 *    -  can handle empty line of input. E.g. enter
 *    -  can indicate invalid operands or operators. E.g. #12+2
 *    -  can indicate insufficient operands around operators. E.g. 12+-2
 *    -  can indicate insufficient operators. E.g. 12 21
 *    -  can indicate extraneous/unbalanced parentheses. E.g. 12+(12-1
 *    -  can indicate division by zero. E.g. 12/0
 *
 ******************************************************************************/

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class Calculator {
	// all operators -- for now -- as a string
	private static String opsString = "()+-/*";

	// result of applying binary operator op to two operands val1 and val2
	public static double eval(String op, double val1, double val2) {
		if (op.equals("+")) return val1 + val2;
		if (op.equals("-")) return val1 - val2;
		if (op.equals("/")) {
			if (val2 == 0.0) {
				throw new RuntimeException("Division by zero is not allowed.");
			}
			return val1 / val2;
		}
		if (op.equals("*")) return val1 * val2;
		throw new RuntimeException("Extraneous/unbalanced parentheses.");
	}

	/**
	 * Just put spaces around operators to simplify tokenizing
	 * No need to catch exception
	 */
	public static String separateOps(String in) {
		for (int i = 0; i < opsString.length(); i++) {
			char c = opsString.charAt(i);
			in = in.replace(Character.toString(c), " " + c + " ");
		}
		return in.trim(); // remove leading and trailing spaces
	}

	public static int precedence(String op) {
		// operator precedence: "(" ")" << "+" "-" << "*" "/"
		return opsString.indexOf(op) / 2;
	}

	public static Double evaluate(String[] tokens) throws RuntimeException {
		// Edsger Dijkstra's shunting-yard (two-stack) algorithm
		Stack<String> ops = new Stack<String>();
		Stack<Double> vals = new Stack<Double>();
		// evaluate the input one token at a time
		for (String s : tokens) {
			// token is a value
			if (!opsString.contains(s)) {
				try {
					vals.push(Double.parseDouble(s));
				} catch (NumberFormatException nfe) {
					throw new NumberFormatException("Invalid operands: " + s + ". Operands contains non-numeric character.");
				}
				continue;
			}
			// token is an operator
			while (true) {
				// the last condition ensures that the operator with
				// higher precedence is evaluated first
				if (ops.isEmpty() || s.equals("(") ||
						(precedence(s) > precedence(ops.peek()))) {
					ops.push(s);
					break;
				}
				// evaluate expression
				String op = ops.pop();
				// ignore left parentheses
				if (op.equals("("))
					break;
				else {
					// evaluate operator and two operands;
					// push result to value stack
					Values values = checkValues(vals, op);
					vals.push(eval(op, values.getVal1(), values.getVal2()));
				}
			}
		}

		if (ops.isEmpty()) {
			throw new RuntimeException("Insufficient operators.");
		}
		// evaluate operator and operands remaining on two stacks
		while (!ops.isEmpty()) {
			String op = ops.pop();
			Values values = checkValues(vals, op);
			vals.push(eval(op, values.getVal1(), values.getVal2()));
		}
		// last value on stack is value of expression
		return vals.pop();
	}

	/**
	 * Values stores two values between operator
	 */
	private static class Values {

		private double val2;

		private double val1;

		public Values(double val2, double val1) {
			this.val2 = val2;
			this.val1 = val1;
		}

		public double getVal2() {
			return val2;
		}

		public void setVal2(double val2) {
			this.val2 = val2;
		}

		public double getVal1() {
			return val1;
		}

		public void setVal1(double val1) {
			this.val1 = val1;
		}
	}

	private static Values checkValues(Stack<Double> vals, String op) throws RuntimeException {
		double val2;
		double val1;
		try {
			val2 = vals.pop();
			val1 = vals.pop();
		} catch (EmptyStackException ese) {
			throw new RuntimeException("Insufficient operands: Operands required around operator.");
		}

		return new Values(val2, val1);
	}


	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			// read in next line as a string
			String ln = input.nextLine();
			if (ln.isEmpty()) {
				// avoid empty string or enter
				continue;
			}
			// tokenize -- separate operands and operators into a string array
			String[] tokens = separateOps(ln).split("\\s+");
			// evaluate and print
			try {
				System.out.println(evaluate(tokens));
			} catch (NumberFormatException nfe) {
				System.out.println(nfe.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}