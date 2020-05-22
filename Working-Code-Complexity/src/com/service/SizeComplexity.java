package com.service;

import java.util.ArrayList;

import com.servlet.AccessFileServlet;

import utils.IndividualFunction;
import utils.StatementLine;

public class SizeComplexity {

	// Working - not exactly
	/**
	 * Take a count of operators and calculate
	 * 
	 * @param functionList
	 * @param codeArray
	 * @return
	 */
	public static ArrayList<StatementLine> sizeByOperators(ArrayList<IndividualFunction> functionList,
			String[] codeArray) {
		int x;
		int y;
		int z;
		int a;
		int start;
		int end;
		boolean isLinePresent;
		int wop;

		ArrayList<StatementLine> statementList = new ArrayList<StatementLine>();

		AccessFileServlet accessFileServlet = new AccessFileServlet();

		String[] divideBySpaces;
		// Checking whether the function list is null or not
		if (functionList.size() == 0) {
			return null;
		}

		for (x = 0; x < functionList.size(); x++) {
			IndividualFunction f1 = functionList.get(x);
			start = f1.getStart();
			end = f1.getEnd();

			while (start != end + 1) {
				wop = 0;
				System.out.println("Line number " + start + " : " + codeArray[start]);

				divideBySpaces = codeArray[start].split("\\s");
				for (y = 0; y < divideBySpaces.length; y++) {
					if (divideBySpaces[y].equals("&&") || divideBySpaces[y].equals("||")
							|| divideBySpaces[y].equals("&") || divideBySpaces[y].equals("|")
							|| divideBySpaces[y].equals("+") || divideBySpaces[y].equals("-")
							|| divideBySpaces[y].equals("*") || divideBySpaces[y].equals("<")
							|| divideBySpaces[y].equals("/") || divideBySpaces[y].equals(">=")
							|| divideBySpaces[y].equals("%") || divideBySpaces[y].equals("<=")
							|| divideBySpaces[y].equals("++") || divideBySpaces[y].equals("^")
							|| divideBySpaces[y].equals("--") || divideBySpaces[y].equals("~")
							|| divideBySpaces[y].equals("==") || divideBySpaces[y].equals("<<")
							|| divideBySpaces[y].equals("!>") || divideBySpaces[y].equals(">>")
							|| divideBySpaces[y].equals(">") || divideBySpaces[y].equals("<<<")
							|| divideBySpaces[y].equals(">>>") || divideBySpaces[y].equals("<<=")
							|| divideBySpaces[y].equals("+-") || divideBySpaces[y].equals(">>=")
							|| divideBySpaces[y].equals("-=") || divideBySpaces[y].equals("^=")
							|| divideBySpaces[y].equals("*=") || divideBySpaces[y].equals("!")
							|| divideBySpaces[y].equals("/=") || divideBySpaces[y].equals(",")
							|| divideBySpaces[y].equals("=") || divideBySpaces[y].equals("->")
							|| divideBySpaces[y].equals(">>>=") || divideBySpaces[y].equals(".")
							|| divideBySpaces[y].equals("|=") || divideBySpaces[y].equals("::")
							|| divideBySpaces[y].equals("&=") || divideBySpaces[y].equals("%=")) {
						if (codeArray[start].contains("//")) {
							System.out.println("Comment--------------------------------------------");
							//break;
						} else {
							wop += AccessFileServlet.userInputOperatorWeight;
						}
					}
				}
				StatementLine s1 = new StatementLine(start, wop);
				statementList.add(s1);
				start++;
			}
			System.out.println("");
		}

		ArrayList<StatementLine> displayWopList = new ArrayList<StatementLine>();

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
					displayWopList.add(s1);
				}
			}
		}
		return displayWopList;

	}

	// Not working
	public static ArrayList<StatementLine> sizeByNumbers(ArrayList<IndividualFunction> functionList,
			String[] codeArray) {

		int x;
		int y;
		int z;
		int a;
		int start;
		int end;
		boolean isLinePresent;

		int wnv;
		AccessFileServlet accessFileServlet = new AccessFileServlet();
		ArrayList<StatementLine> statementList = new ArrayList<StatementLine>();

		String[] divideBySpaces;
		// String code = "";
		if (functionList.size() == 0) {
			return null;
		}

		for (x = 0; x < functionList.size(); x++) {
			IndividualFunction f1 = functionList.get(x);
			start = f1.getStart();
			end = f1.getEnd();

			while (start != end + 1) {
				wnv = 0;
				System.out.println("Line number " + start + " : " + codeArray[start]);

				boolean isPreviousDigit = false;

				divideBySpaces = codeArray[start].split("\\s");
				for (y = 0; y < divideBySpaces.length; y++) {
					if (Character.isDigit(codeArray[start].charAt(y))) {
						if (!isPreviousDigit) {
							if (codeArray[start].contains("{") || codeArray[start].contains("//")) {
								//break;
								System.out.println("Comment------------------------");
							} else {
								wnv += AccessFileServlet.userInputNumericsWeight;
								isPreviousDigit = true;
							}
						}
					} else {
						isPreviousDigit = false;
					}
				}
				StatementLine s1 = new StatementLine(start, wnv);
				statementList.add(s1);
				start++;
			}
			System.out.println("");
		}

		ArrayList<StatementLine> displayWnvList = new ArrayList<StatementLine>();

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
					displayWnvList.add(s1);
				}
			}
		}
		return displayWnvList;
	}

	// Working
	public static ArrayList<StatementLine> sizeByStrings(ArrayList<IndividualFunction> functionList,
			String[] codeArray) {
		int x;
		int y;
		int z;
		int a;
		int start;
		int end;
		boolean isLinePresent;

		int wsl;
		AccessFileServlet accessFileServlet = new AccessFileServlet();
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
				wsl = 0;
				System.out.println("Line number " + start + " : " + codeArray[start]);

				divideBySpaces = codeArray[start].split("\\s");
				for (y = 0; y < divideBySpaces.length; y++) {
					if (divideBySpaces[y].contains("\"") && (divideBySpaces[y].contains("\""))) {
						if (codeArray[start].contains("//")) {
							System.out.println("Comment--------------------------------------------");
							//break;
						} else {
							wsl += AccessFileServlet.userInputStringsWeight;
						}
					}
				}
				StatementLine s1 = new StatementLine(start, wsl);
				statementList.add(s1);
				start++;
			}
			System.out.println("");
		}

		ArrayList<StatementLine> displayCtcList = new ArrayList<StatementLine>();

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
					displayCtcList.add(s1);
				}
			}
		}
		return displayCtcList;

	}

	// Working
	public static ArrayList<StatementLine> sizeByKeyWords(ArrayList<IndividualFunction> functionList,
			String[] codeArray) {
		int x;
		int y;
		int z;
		int a;
		int start;
		int end;
		boolean isLinePresent;

		int wkw;

		AccessFileServlet accessFileServlet = new AccessFileServlet();

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
				wkw = 0;
				// System.out.println("Value of wkw is = " + wkw);
				System.out.println("Line number " + start + " : " + codeArray[start]);

				divideBySpaces = codeArray[start].split("\\s");
				for (y = 0; y < divideBySpaces.length; y++) {
					if (divideBySpaces[y].equals("abstract") || divideBySpaces[y].equals("assert")
							|| divideBySpaces[y].equals("break") || divideBySpaces[y].equals("const")
							|| divideBySpaces[y].equals("class") || divideBySpaces[y].equals("catch")
							|| divideBySpaces[y].equals("default") || divideBySpaces[y].equals("else")
							|| divideBySpaces[y].equals("extends") || divideBySpaces[y].equals("goto")
							|| divideBySpaces[y].equals("finally") || divideBySpaces[y].equals("fales")
							|| divideBySpaces[y].equals("implements") || divideBySpaces[y].equals("import")
							|| divideBySpaces[y].equals("instanceOf") || divideBySpaces[y].equals("interface")
							|| divideBySpaces[y].equals("native") || divideBySpaces[y].equals("new")
							|| divideBySpaces[y].equals("null") || divideBySpaces[y].equals("package")
							|| divideBySpaces[y].equals("private") || divideBySpaces[y].equals("protected")
							|| divideBySpaces[y].equals("public") || divideBySpaces[y].equals("return")
							|| divideBySpaces[y].equals("static") || divideBySpaces[y].equals("trictfp")
							|| divideBySpaces[y].equals("super") || divideBySpaces[y].equals("synchronized")
							|| divideBySpaces[y].equals("this") || divideBySpaces[y].equals("throw")
							|| divideBySpaces[y].equals("transient") || divideBySpaces[y].equals("true")
							|| divideBySpaces[y].equals("try") || divideBySpaces[y].equals("void")
							|| divideBySpaces[y].equals("volatile") || divideBySpaces[y].equals("continue")) {
						if (codeArray[start].contains("//")) {
							System.out.println("Comment--------------------------------------------");
							//break;
						} else {
							wkw += AccessFileServlet.userInputKeywordWeight;
						}
					}
				}
				StatementLine s1 = new StatementLine(start, wkw);
				statementList.add(s1);
				start++;
			}
			System.out.println("");
		}

		ArrayList<StatementLine> displayWkwList = new ArrayList<StatementLine>();

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
					displayWkwList.add(s1);
				}
			}
		}
		return displayWkwList;

	}

	// working
	public static ArrayList<StatementLine> sizeByKeyIdentifires(ArrayList<IndividualFunction> functionList,
			String[] codeArray) {
		int x;
		int y;
		int z;
		int a;
		int start;
		int end;
		boolean isLinePresent;

		int wid;

		ArrayList<StatementLine> statementList = new ArrayList<StatementLine>();

		AccessFileServlet accessFileServlet = new AccessFileServlet();

		String[] divideBySpaces;
		if (functionList.size() == 0) {
			return null;
		}

		for (x = 0; x < functionList.size(); x++) {
			IndividualFunction f1 = functionList.get(x);
			start = f1.getStart();
			end = f1.getEnd();

			while (start != end + 1) {
				wid = 0;
				System.out.println("Line number " + start + " : " + codeArray[start]);

				divideBySpaces = codeArray[start].split("\\s");
				for (y = 0; y < divideBySpaces.length; y++) {
					if (codeArray[y].contains("if")
							|| codeArray[y].contains("while") && codeArray[y].contains("(")
									&& codeArray[y].contains("boolean")
							|| codeArray[y].contains("byte") || codeArray[y].contains("char")
							|| codeArray[y].contains("short") || codeArray[y].contains("long")
							|| codeArray[y].contains("double") || codeArray[y].contains("int")
							|| codeArray[y].contains("float") && codeArray[y].contains(")")
									&& codeArray[y].contains("{")) {
						System.out.println("If statement or while");
						if (codeArray[start].contains("//")) {
							System.out.println("Comment--------------------------------------------");
							//break;
						} else {
							wid += AccessFileServlet.userInputIdentifiersWeight;
						}

					}
					else

					if (codeArray[y].contains("do") && codeArray[y].contains("{")
							&& codeArray[y].contains("while") && codeArray[y].contains("(")
							&& codeArray[y].contains("boolean") || codeArray[y].contains("byte")
							|| codeArray[y].contains("char") || codeArray[y].contains("short")
							|| codeArray[y].contains("long") || codeArray[y].contains("double")
							|| codeArray[y].contains("int")
							|| codeArray[y].contains("float") && codeArray[y].contains(")")) {
						System.out.println("Do while loop statement");
						if (codeArray[start].contains("//")) {
							System.out.println("Comment--------------------------------------------");
							//break;
						} else {
							wid += AccessFileServlet.userInputIdentifiersWeight;
						}

					}
					else

					if (codeArray[y].contains("switch") && codeArray[y].contains("(")
							&& codeArray[y].contains("while") && codeArray[y].contains("boolean")
							|| codeArray[y].contains("byte") || codeArray[y].contains("char")
							|| codeArray[y].contains("short") || codeArray[y].contains("long")
							|| codeArray[y].contains("double") || codeArray[y].contains("int")
							|| codeArray[y].contains("float") && codeArray[y].contains(")")
									&& codeArray[y].contains("{")) {
						System.out.println("Do while loop statement");
						if (codeArray[start].contains("//")) {
							System.out.println("Comment--------------------------------------------");
							//break;
						} else {
							wid += AccessFileServlet.userInputIdentifiersWeight;
						}

					}
				}

				StatementLine s1 = new StatementLine(start, wid);
				statementList.add(s1);
				start++;
			}
			System.out.println("");
		}

		ArrayList<StatementLine> displayWidList = new ArrayList<StatementLine>();

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
					displayWidList.add(s1);
				}
			}
		}
		return displayWidList;

	}

}
