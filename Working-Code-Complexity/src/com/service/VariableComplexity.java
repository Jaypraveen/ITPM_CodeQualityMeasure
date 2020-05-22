package com.service;

import java.util.ArrayList;

import com.servlet.AccessFileServlet;

import utils.IndividualFunction;
import utils.StatementLine;

public class VariableComplexity {
	//There is a small issue
	public static ArrayList<StatementLine> variableByScope(ArrayList<IndividualFunction> functionList,
			String[] codeArray) {
		
		
		int x;
		int y;
		int z;
		int a;
		int start;
		int end;
		boolean isLinePresent;
		
		int wvs;
		int wvsg;
		int wvsl;
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
				wvs = 0;
				wvsg = 0;
				wvsl = 0;
				System.out.println("Line number " + start + " : " + codeArray[start]);

				divideBySpaces = codeArray[start].split("\\s");
				for (y = 0; y < divideBySpaces.length; y++) {
					if (divideBySpaces[y].equals("private") || divideBySpaces[y].equals("public")
							|| divideBySpaces[y].equals("protected") && divideBySpaces[y].equals("static")
									&& divideBySpaces[y].contains("boolean")
							|| divideBySpaces[y].contains("byte") || divideBySpaces[y].contains("char")
							|| divideBySpaces[y].contains("short") || divideBySpaces[y].contains("long")
							|| divideBySpaces[y].contains("double") || divideBySpaces[y].contains("int")
							|| divideBySpaces[y].contains("float")) {
						if (codeArray[start].contains("{") || codeArray[start].contains("//")) {
							break;
						} else {
							System.out.println("A globle variable");
							wvsg += AccessFileServlet.userInputGlobalWeight;
						}

					}

					if (divideBySpaces[y].contains("boolean") || divideBySpaces[y].contains("byte")
							|| divideBySpaces[y].contains("char") || divideBySpaces[y].contains("short")
							|| divideBySpaces[y].contains("long") || divideBySpaces[y].contains("double")
							|| divideBySpaces[y].contains("int")
							|| divideBySpaces[y].contains("float")) {
						if (codeArray[start].contains("{") || codeArray[start].contains("//")) {
							break;
						} else {
							System.out.println("A local variable");
							wvsl+=AccessFileServlet.userInputLocalWeight;
						}

					}
				}
				wvs = wvsg + wvsl;
				StatementLine s1 = new StatementLine(start, wvs);
				statementList.add(s1);
				start++;
			}
			System.out.println("");
		}

		ArrayList<StatementLine> displayWvsList = new ArrayList<StatementLine>();

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
					displayWvsList.add(s1);
				}
			}
		}
		return displayWvsList;

	}
	//There is a small issue - same issue
	public static ArrayList<StatementLine> variableByPremDataType(ArrayList<IndividualFunction> functionList,
			String[] codeArray) {
		int x;
		int y;
		int z;
		int a;
		int start;
		int end;
		boolean isLinePresent;

		int wpdtv;
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
				wpdtv = 0;
				System.out.println("Line number " + start + " : " + codeArray[start]);

				divideBySpaces = codeArray[start].split("\\s");
				for (y = 0; y < divideBySpaces.length; y++) {
					if (divideBySpaces[y].contains("boolean") || divideBySpaces[y].contains("byte")
							|| divideBySpaces[y].contains("char") || divideBySpaces[y].contains("short")
							|| divideBySpaces[y].contains("long") || divideBySpaces[y].contains("double")
							|| divideBySpaces[y].contains("int")
							|| divideBySpaces[y].contains("float")) {
						if (codeArray[start].contains("{") || codeArray[start].contains("//")) {
							break;
						} else {
							System.out.println("A primitive data type variable");
							wpdtv+=AccessFileServlet.userInputPrimitiveVariableWeight;
						}
					}
				}

				StatementLine s1 = new StatementLine(start, wpdtv);
				statementList.add(s1);
				start++;
			}
			System.out.println("");
		}

		ArrayList<StatementLine> displayWpdtvList = new ArrayList<StatementLine>();

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
					displayWpdtvList.add(s1);
				}
			}
		}
		return displayWpdtvList;

	}

	public static ArrayList<StatementLine> variableByCompDataType(ArrayList<IndividualFunction> functionList,
			String[] codeArray) {
		int x;
		int y;
		int z;
		int a;
		int start;
		int end;
		boolean isLinePresent;

		int wcdtv;
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
				wcdtv = 0;
				System.out.println("Line number " + start + " : " + codeArray[start]);

				divideBySpaces = codeArray[start].split("\\s");
				for (y = 0; y < divideBySpaces.length; y++) {

					if (codeArray[start].contains("//")) {
						System.out.println("Comment-----------------------");
					} else {
						if (divideBySpaces[y].contains("private") || divideBySpaces[y].contains("public")
								|| divideBySpaces[y].contains("protected") && divideBySpaces[y].contains("String")
										&& divideBySpaces[y].contains(";")) {
							if (codeArray[start].contains("{") || codeArray[start].contains("//")) {
								break;
							} else {
								System.out.println("A composite data type variable");
								wcdtv += AccessFileServlet.userInputCompositeVariableWeight;
							}

						}

					}
					for (y = 0; y < divideBySpaces.length; y++) {
						if (codeArray[start].contains("=") && divideBySpaces[y].equals("new")) {
							if (codeArray[start].contains("{") || codeArray[start].contains("//")) {
								break;
							} else {
								System.out.println("A composite data type variable");
								wcdtv += AccessFileServlet.userInputCompositeVariableWeight;
							}

						}
					}
				}

				StatementLine s1 = new StatementLine(start, wcdtv);
				statementList.add(s1);
				start++;
			}
			System.out.println("");
		}

		ArrayList<StatementLine> displayWcdtvList = new ArrayList<StatementLine>();

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
					displayWcdtvList.add(s1);
				}
			}
		}
		return displayWcdtvList;

	}
}
