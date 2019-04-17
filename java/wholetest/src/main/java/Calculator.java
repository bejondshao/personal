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
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Calculator {

	// all operators -- for now -- as a string
	private static String opsString = "()+-/*";

	private static String LEFT_PARENTHESIS = "\\("; // escape "\", which is "\\", in the end, "\\(" is escaping "("

	private static String RIGHT_PARENTHESIS = "\\)";

	private static final String COLON = ":";

	private static final String COMMA = ",";

	private static String ASSIGNMENT = "=";

	private static String TYPE_ASSIGN = "assign";

	private static String TYPE_DEF = "def";

	private static String TYPE_DEF_ = "def ";

	private static String TYPE_EVAL = "eval";

	private static String TYPE_CALL = "call";

	private static String WS = " ";

	private static String REGEX_START_WITH_ALPHA_NUM = "^[a-zA-Z][a-zA-Z0-9]*";  // "^[a-zA-Z][a-zA-Z0-9_]*" is better, but not suitable for requirement of assignment

	private static Map<String, Double> variableMap = new HashMap<>();

	private static Map<String, AbstractSyntax> functionMap = new HashMap<>();

	public static AbstractSyntax preDeal(String input) {
		AbstractSyntax abstractSyntax = new AbstractSyntax();
		if (input.contains(ASSIGNMENT)) { // for assignment
			abstractSyntax = dealAssign(input);
		} else if (input.startsWith(TYPE_DEF_)) { // for def
			abstractSyntax = dealDef(input);
		} else if (input.contains(LEFT_PARENTHESIS)) { // for call and expression
			abstractSyntax = dealCallOrExpression(input);
		} else {
			dealExpression(input);
		}

		return abstractSyntax;
	}

	private static AbstractSyntax dealAssign(String input) {
		AbstractSyntax abstractSyntax = new AbstractSyntax();
		String[] variableAndExpression = input.split(ASSIGNMENT); // x = 3 + 2 would be ["x", "3 + 2"]
		if (variableAndExpression.length > 2) {
			throw new RuntimeException("Insufficient assignment: Only one assignment is allowed.");
		}
		abstractSyntax.setType(TYPE_ASSIGN);
		abstractSyntax.setName(variableAndExpression[0].trim());
		abstractSyntax.setExp(new String[]{variableAndExpression[1].trim()});
		Double result = evaluateExpression(variableAndExpression[1].trim());
		variableMap.put(abstractSyntax.getName(), result);
		System.out.println("Result: " + abstractSyntax.getName() + WS + ASSIGNMENT + WS + result);
		return abstractSyntax;
	}

	private static AbstractSyntax dealDef(String input) {
		AbstractSyntax abstractSyntax = new AbstractSyntax();
		String[] def_AndFunction = input.split(TYPE_DEF_, 2); // "def sumOfSquares(x,y) : x * x + y * y" would be ["def ", "sumOfSquares(x,y) : x * x + y * y"]
		abstractSyntax.setType(TYPE_DEF);
		String[] functionAndExpression = def_AndFunction[1].split(COLON); // "sumOfSquares(x,y) : x * x + y * y" would be ["sumOfSquares(x,y) ", " x * x + y * y"]
		String[] functionNameAndParams = functionAndExpression[0].trim().split(LEFT_PARENTHESIS); // "sumOfSquares(x,y) " would be ["sumOfSquares", "x,y)"]

		abstractSyntax.setName(functionNameAndParams[0]);
		abstractSyntax.setExp(new String[]{functionAndExpression[1].trim()});

		String paramsString = functionNameAndParams[1].split(RIGHT_PARENTHESIS)[0]; // "x,y)" would be spilt to ["x,y"], result is "x,y"
		abstractSyntax.setParams(spiltStringToTrimArray(paramsString, COMMA)); // ["x", "y"]
		functionMap.put(abstractSyntax.getName(), abstractSyntax);
		System.out.println("Function: " + abstractSyntax.toString());
		return abstractSyntax;
	}

	private static AbstractSyntax dealCallOrExpression(String input) {
		AbstractSyntax abstractSyntax = new AbstractSyntax();

		/**
		 * "sum(2, 3)" would be ["sum", "2, 3)"]
		 * "x + (2 + y)" would be ["x + ", "2 + y)"]
		 */
		String[] functionNameAndParams = input.split(LEFT_PARENTHESIS, 2);

		// this is a function name
		if (Parser.alphanum(functionNameAndParams[0])) {
			abstractSyntax.setType(TYPE_CALL);
			abstractSyntax.setName(functionNameAndParams[0]);
			String paramsString = functionNameAndParams[1].split(RIGHT_PARENTHESIS)[0]; // "2, 3)" would be "2, 3"
			abstractSyntax.setParams(spiltStringToTrimArray(paramsString, COMMA)); // ["2", "3"]
		} else { // this could only be expression
			abstractSyntax.setType(TYPE_EVAL);
			abstractSyntax.setExp(new String[]{input});
			dealExpression(input);
		}

		return abstractSyntax;
	}

	private static void dealExpression(String input) {
		System.out.println("Expression: " + evaluateExpression(input));
	}

	private static String[] spiltStringToTrimArray(String string, String regex) {
		String[] array = string.split(regex); // "x, y" would be spilt to ["x", " y"]
		for (int i = 0; i < array.length; i++)
			array[i] = array[i].trim();

		return array;
	}


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
					if (Parser.alphanum(s)) { // check variable before parse
						Double value = variableMap.get(s);
						if (value == null) {
							throw new RuntimeException("Undefined variable: " + s);
						}
						vals.push(value);
					} else {
						vals.push(Double.parseDouble(s));
					}
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

	/**
	 * I didn't have Parser, so I write it myself
	 */
	private static class Parser {
		public static boolean alphanum(String varName) {
			return varName.matches(REGEX_START_WITH_ALPHA_NUM);
		}
	}

	/**
	 * Evaluate expression
	 * @param expression
	 * @return
	 */
	public static Double evaluateExpression(String expression) {
		// should not do separateOps before preDeal. Only do separateOps when you are sure this is an expression
		expression = separateOps(expression);
		// tokenize -- separate operands and operators into a string array
		String[] tokens = expression.split("\\s+");
		Double result = evaluate(tokens);
		return result;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			// read in next line as a string
			String ln = input.nextLine();
			if (ln.equals("exit")) {
				break;
			}
			if (ln.isEmpty()) {
				// avoid empty string or enter
				continue;
			}
			// evaluate and print
			try {
				preDeal(ln);
			} catch (NumberFormatException nfe) {
				System.out.println(nfe.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}