package com.service;

import java.util.ArrayList;

import utils.IndividualFunction;
import utils.StatementLine;

public class MethodComplexity {
	// Working but there are some issues
	public static ArrayList<StatementLine> methodByReturnType(ArrayList<IndividualFunction> functionList,
			String[] codeArray) {
		int x;
		int y;
		int z;
		int a;
		int start;
		int end;
		boolean isLinePresent;

		int wmrt;
		int wmrtp;
		int wmrtc;

		ArrayList<StatementLine> statementList = new ArrayList<StatementLine>();

		String[] divideBySpaces;
		if (functionList.size() == 0) {
			return null;
		}

		for (x = 0; x < functionList.size(); x++) {
			IndividualFunction f1 = functionList.get(x);
			start = f1.getStart();
			end = f1.getEnd();

			while (start != end + 1) {
				wmrt = 0;
				wmrtp = 0;
				wmrtc = 0;
				System.out.println("Line number " + start + " : " + codeArray[start]);

				if (codeArray[start].contains("public") && codeArray[start].contains("void")) {
					System.out.println("A method with a \"void\"");
					break;
				}

				divideBySpaces = codeArray[start].split("\\s");
				for (y = 0; y < divideBySpaces.length; y++) {
					if (divideBySpaces[y].contains("public") && divideBySpaces[y].contains("boolean")
							|| divideBySpaces[y].contains("byte") || divideBySpaces[y].contains("char")
							|| divideBySpaces[y].contains("short") || divideBySpaces[y].contains("long")
							|| divideBySpaces[y].contains("double") || divideBySpaces[y].contains("int")
							|| divideBySpaces[y].contains("float")) {
						if (codeArray[start].contains("//")) {
							System.out.println("Comment-----------------------------------");
							break;
						} else {
							System.out.println("Primitive return type");
							wmrtp++;
						}

					}
				}

				for (y = 0; y < divideBySpaces.length; y++) {
					if (divideBySpaces[y].contains("public") && divideBySpaces[y].contains("String")
							|| divideBySpaces[y].contains("Array") || divideBySpaces[y].contains("ArrayList")
							|| divideBySpaces[y].contains("List") || divideBySpaces[y].contains("LinkedList")) {
						if (codeArray[start].contains("//")) {
							System.out.println("Comment-----------------------------------");
							break;
						} else {
							System.out.println("Primitive return type");
							wmrtc += 2;
						}
					}

				}
				wmrt = wmrtp + wmrtc;
				// ---------------------------------

				StatementLine s1 = new StatementLine(start, wmrt);
				statementList.add(s1);
				start++;
			}
			System.out.println("");
		}

		ArrayList<StatementLine> displayWmrtList = new ArrayList<StatementLine>();

		for (y = 0; y < codeArray.length; y++) {
			isLinePresent = true;
			for (a = 0; a < statementList.size(); a++) {
				if (statementList.get(a).getLineNumber() == y) {
					isLinePresent = false;
				}
			}
			if (isLinePresent) {
				statementList.add(new StatementLine(y, 0));
			}
		}

		for (y = 1; y <= statementList.size(); y++) {
			for (z = 0; z < statementList.size(); z++) {
				if (statementList.get(z).getLineNumber() + 1 == y) {
					StatementLine s1 = new StatementLine(y, statementList.get(z).getComplexity());
					displayWmrtList.add(s1);
				}
			}
		}
		return displayWmrtList;
	}

	//Working but there are some issues
	public static ArrayList<StatementLine> methodByPrimDataTypePara(ArrayList<IndividualFunction> functionList,

			String[] codeArray) {
		int x;
		int y;
		int z;
		int a;
		int start;
		int end;
		boolean isLinePresent;

		int wpdtp;

		ArrayList<StatementLine> statementList = new ArrayList<StatementLine>();

		String[] divideBySpaces;
		if (functionList.size() == 0) {
			return null;
		}

		for (x = 0; x < functionList.size(); x++) {
			IndividualFunction f1 = functionList.get(x);
			start = f1.getStart();
			end = f1.getEnd();

			while (start != end + 1) {
				wpdtp = 0;
				System.out.println("Line number " + start + " : " + codeArray[start]);

				if (codeArray[start].contains("public") && codeArray[start].contains("void")) {
					System.out.println("A method with a \"void\"");
					break;
				}

				divideBySpaces = codeArray[start].split("\\s");
				for (y = 0; y < divideBySpaces.length; y++) {
					if (codeArray[start].contains("public") && divideBySpaces[y].contains("boolean")
							|| divideBySpaces[y].contains("byte") || divideBySpaces[y].contains("char")
							|| divideBySpaces[y].contains("short") || divideBySpaces[y].contains("long")
							|| divideBySpaces[y].contains("double") || divideBySpaces[y].contains("int")
							|| divideBySpaces[y].contains("float") && codeArray[start].contains("(")
									&& divideBySpaces[y].contains("boolean")
							|| divideBySpaces[y].contains("byte") || divideBySpaces[y].contains("char")
							|| divideBySpaces[y].contains("short") || divideBySpaces[y].contains("long")
							|| divideBySpaces[y].contains("double") || divideBySpaces[y].contains("int")
							|| divideBySpaces[y].contains("float") && divideBySpaces[y].contains(")")
									&& divideBySpaces[y].contains("{")) {
						if (codeArray[start].contains("//")) {
							System.out.println("Comment-----------------------------------");
							break;
						} else {
							System.out.println("Primitive return type parameters");
							wpdtp++;
						}
					}
					/*
					 * if(codeArray[start].contains("public") &&
					 * codeArray[start].contains("boolean") || codeArray[start].contains("byte")) {
					 * System.out.println("Primitive return type"); wmrt += 2; }
					 */
				}
				StatementLine s1 = new StatementLine(start, wpdtp);
				statementList.add(s1);
				start++;
			}
			System.out.println("");
		}

		ArrayList<StatementLine> displayWpdtpList = new ArrayList<StatementLine>();

		for (y = 0; y < codeArray.length; y++) {
			isLinePresent = true;
			for (a = 0; a < statementList.size(); a++) {
				if (statementList.get(a).getLineNumber() == y) {
					isLinePresent = false;
				}
			}
			if (isLinePresent) {
				statementList.add(new StatementLine(y, 0));
			}
		}

		for (y = 1; y <= statementList.size(); y++) {
			for (z = 0; z < statementList.size(); z++) {
				if (statementList.get(z).getLineNumber() + 1 == y) {
					StatementLine s1 = new StatementLine(y, statementList.get(z).getComplexity());
					displayWpdtpList.add(s1);
				}
			}
		}
		return displayWpdtpList;

	}

	//Working
	public static ArrayList<StatementLine> methodByCompDataTypePara(ArrayList<IndividualFunction> functionList,
			String[] codeArray) {
		int x;
		int y;
		int z;
		int a;
		int start;
		int end;
		boolean isLinePresent;

		int wcdtp;

		ArrayList<StatementLine> statementList = new ArrayList<StatementLine>();

		String[] divideBySpaces;
		if (functionList.size() == 0) {
			return null;
		}

		for (x = 0; x < functionList.size(); x++) {
			IndividualFunction f1 = functionList.get(x);
			start = f1.getStart();
			end = f1.getEnd();

			while (start != end + 1) {
				wcdtp = 0;
				System.out.println("Line number " + start + " : " + codeArray[start]);

				if (codeArray[start].contains("public") && codeArray[start].contains("void")) {
					System.out.println("A method with a \"void\"");
					break;
				}

				divideBySpaces = codeArray[start].split("\\s");
				for (y = 0; y < divideBySpaces.length; y++) {
					if (codeArray[start].contains("public") && divideBySpaces[y].contains("String")
							|| divideBySpaces[y].contains("Array") || divideBySpaces[y].contains("ArrayList")
							|| divideBySpaces[y].contains("List")
							|| divideBySpaces[y].contains("LinkedList") && divideBySpaces[y].contains("(")
									&& divideBySpaces[y].contains("String")
							|| divideBySpaces[y].contains("Array") || divideBySpaces[y].contains("ArrayList")
							|| divideBySpaces[y].contains("List") || divideBySpaces[y].contains("LinkedList")) {
						if (codeArray[start].contains("//")) {
							System.out.println("Comment-----------------------------------");
							break;
						} else {
							System.out.println("Composite return type parameters");
							wcdtp += 2;
						}
					}
				}
				StatementLine s1 = new StatementLine(start, wcdtp);
				statementList.add(s1);
				start++;
			}
			System.out.println("");
		}

		ArrayList<StatementLine> displayWcdtpList = new ArrayList<StatementLine>();

		for (y = 0; y < codeArray.length; y++) {
			isLinePresent = true;
			for (a = 0; a < statementList.size(); a++) {
				if (statementList.get(a).getLineNumber() == y) {
					isLinePresent = false;
				}
			}
			if (isLinePresent) {
				statementList.add(new StatementLine(y, 0));
			}
		}

		for (y = 1; y <= statementList.size(); y++) {
			for (z = 0; z < statementList.size(); z++) {
				if (statementList.get(z).getLineNumber() + 1 == y) {
					StatementLine s1 = new StatementLine(y, statementList.get(z).getComplexity());
					displayWcdtpList.add(s1);
				}
			}
		}
		return displayWcdtpList;

	}

}
