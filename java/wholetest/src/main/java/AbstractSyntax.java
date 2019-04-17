// A simple Abstract Syntax structure for F-Calc.                                                                      
// Four variables used as follows:                                                                                     
//  type -- one of the four types of statements in F-Calc:                                                             
//          "eval", "assign", "def", "call"                                                                            
//  name -- var name for assignment, function name for "def" and "call"                                                
//  params -- parameters for "def" and "call"                                                                          
//  exp -- the expression to be evaluated, not used for "call"                                                         

import java.util.Arrays;

public class AbstractSyntax {
	private String type;
	private String name;
	private String[] params; // several parameters
	private String[] exp; // one component

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getParams() {
		return params;
	}

	public void setParams(String[] params) {
		this.params = params;
	}

	public String[] getExp() {
		return exp;
	}

	public void setExp(String[] exp) {
		this.exp = exp;
	}

	@Override
	public String toString() {
		return "[" + type + "," + name + "," + Arrays.toString(params) + "," + Arrays.toString(exp) + "]";
	}
}