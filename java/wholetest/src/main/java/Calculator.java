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
 ******************************************************************************/

import java.util.Stack;
import java.util.Scanner;

public class Calculator {
	// all operators -- for now -- as a string
	private static String opsString = "()+-/*";

	// result of applying binary operator op to two operands val1 and val2
	public static double eval(String op, double val1, double val2) {
		if (op.equals("+")) return val1 + val2;
		if (op.equals("-")) return val1 - val2;
		if (op.equals("/")) return val1 / val2;
		if (op.equals("*")) return val1 * val2;
		throw new RuntimeException("Invalid operator");
	}

	// put spaces around operators to simplify tokenizing
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

	public static Double evaluate(String[] tokens) {
		// Edsger Dijkstra's shunting-yard (two-stack) algorithm
		Stack<String> ops  = new Stack<String>();
		Stack<Double> vals = new Stack<Double>();
		// evaluate the input one token at a time
		for (String s : tokens) {
			// token is a value
			if (! opsString.contains(s)) {
				vals.push(Double.parseDouble(s));
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
					double val2 = vals.pop();
					double val1 = vals.pop();
					vals.push(eval(op, val1, val2));
				}
			}
		}

		// evaluate operator and operands remaining on two stacks
		while (!ops.isEmpty()) {
			String op = ops.pop();
			double val2 = vals.pop();
			double val1 = vals.pop();
			vals.push(eval(op, val1, val2));
		}
		// last value on stack is value of expression
		return vals.pop();
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			// read in next line as a string
			String ln = input.nextLine();
			// tokenize -- separate operands and operators into a string array
			String[] tokens = separateOps(ln).split("\\s+");
			// evaluate and print
			System.out.println(evaluate(tokens));
		}
	}
}