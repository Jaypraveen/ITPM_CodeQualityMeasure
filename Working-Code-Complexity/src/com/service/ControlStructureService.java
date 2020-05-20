package com.service;

import java.util.ArrayList;

import utils.IndividualFunction;
import utils.StatementLine;


public class ControlStructureService {
	public static ArrayList<StatementLine> calculateComplexityByType(ArrayList<IndividualFunction> functionList,
			String[] codeArray) {

		int x; 
		int m;
		int y;
		int z;
		int a;
		int start;
		int end;
		int switchStart, switchEnd;
		int numberOfCases;
		String[] lineToChars;
		ArrayList<String> bracketCheckSwitch = new ArrayList<String>();
		boolean isLinePresent;

		int Ctc;

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
				Ctc = 0;
				numberOfCases = 0;
				System.out.println("Line number " + start + " : " + codeArray[start]);

				if (codeArray[start].contains("if") && codeArray[start].contains("(")
						&& codeArray[start].contains(")")) {
					System.out.println("Line number " + start + " has a if statement");
					Ctc++;

					divideBySpaces = codeArray[start].split("\\s");
					for (y = 0; y < divideBySpaces.length; y++) {
						if (divideBySpaces[y].equals("&&") || divideBySpaces[y].equals("||")
								|| divideBySpaces[y].equals("&") || divideBySpaces[y].equals("|")) {
							Ctc++;
						}
					}
				}

				if (codeArray[start].contains("for") && codeArray[start].contains("(") && codeArray[start].contains(")")
						&& codeArray[start].contains("{")) {
					System.out.println("Line number " + start + " has a for statement");
					Ctc = Ctc + 2;

					divideBySpaces = codeArray[start].split("\\s");
					for (y = 0; y < divideBySpaces.length; y++) {
						if (divideBySpaces[y].equals("&&") || divideBySpaces[y].equals("||")
								|| divideBySpaces[y].equals("&") || divideBySpaces[y].equals("|")) {
							Ctc++;
						}
					}
				}

				if (codeArray[start].contains("while") && codeArray[start].contains("(")
						&& codeArray[start].contains(")") && codeArray[start].contains("{")) {
					System.out.println("Line number " + start + " has a While statement");
					Ctc = Ctc + 2;

					divideBySpaces = codeArray[start].split("\\s");
					for (y = 0; y < divideBySpaces.length; y++) {
						if (divideBySpaces[y].equals("&&") || divideBySpaces[y].equals("||")
								|| divideBySpaces[y].equals("&") || divideBySpaces[y].equals("|")) {
							Ctc++;
						}
					}
				}

				if (codeArray[start].contains("do") && codeArray[start].contains("{")) {
					System.out.println("Line number " + start + " has a do statement");
					Ctc = Ctc + 2;

					divideBySpaces = codeArray[start].split("\\s");
					for (y = 0; y < divideBySpaces.length; y++) {
						if (divideBySpaces[y].equals("&&") || divideBySpaces[y].equals("||")
								|| divideBySpaces[y].equals("&") || divideBySpaces[y].equals("|")) {
							Ctc++;
						}
					}
				}

				if (codeArray[start].contains("catch") && codeArray[start].contains("(")
						&& codeArray[start].contains(")") && codeArray[start].contains("{")) {
					System.out.println("Line number " + start + " has a Catch statement");
					Ctc++;

				}

				if (codeArray[start].contains("switch") && codeArray[start].contains("(")
						&& codeArray[start].contains(")") && codeArray[start].contains("{")) {
					System.out.println("Line number " + start + " has a Switch statement");

					divideBySpaces = codeArray[start].split("\\s");
					for (y = 0; y < divideBySpaces.length; y++) {
						if (divideBySpaces[y].equals("{")) {
							bracketCheckSwitch.add("{");
						}
					}

					for (z = start + 1; z < end; z++) {
						lineToChars = codeArray[z].split("(?!^)");
						for (a = 0; a < lineToChars.length; a++) {

							if (lineToChars[a].contains("{")) {
								bracketCheckSwitch.add("{");
								System.out.println("{");
								System.out.println(bracketCheckSwitch.toString());
							}
							if (lineToChars[a].contains("}")) {
								bracketCheckSwitch.remove(bracketCheckSwitch.size() - 1);
								System.out.println("}");
								System.out.println(bracketCheckSwitch.toString());
							}

						}
						if (bracketCheckSwitch.toString() == "[]") {
							break;
						}
					}
					System.out.println("Switch is from " + start + " to " + z);
					switchStart = start;
					switchEnd = z;

					while (switchStart < switchEnd + 1) {
						if (codeArray[switchStart].contains("case")) {
							numberOfCases++;
						}
						switchStart++;
					}

					Ctc = Ctc + numberOfCases;
				}

				StatementLine s1 = new StatementLine(start, Ctc);
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

	public static ArrayList<StatementLine> calculateComplexityByNestingControlStructure(
			ArrayList<IndividualFunction> functionList, String[] codeArray) {

		int x, a, y, z;
		int start;
		int end;
		int Cnc;
		boolean isLinePresent;
		String[] lineToChars;
		ArrayList<String> bracketNesting = new ArrayList<String>();

		ArrayList<StatementLine> StatementList = new ArrayList<StatementLine>();
		for (x = 0; x < functionList.size(); x++) {

			IndividualFunction f1 = functionList.get(x);
			start = f1.getStart();
			end = f1.getEnd();

			while (start != end + 1) {
				Cnc = 0;

				if ((codeArray[start].contains("if") && codeArray[start].contains("(")
						&& codeArray[start].contains("("))
						|| (codeArray[start].contains("for") && codeArray[start].contains("(")
								&& codeArray[start].contains("(") && codeArray[start].contains("{"))
						|| (codeArray[start].contains("while") && codeArray[start].contains("(")
								&& codeArray[start].contains("("))
						|| (codeArray[start].contains("for") && codeArray[start].contains("(")
								&& codeArray[start].contains("(") && codeArray[start].contains("{"))
						|| (codeArray[start].contains("do") && codeArray[start].contains("{"))
						|| (codeArray[start].contains("switch") && codeArray[start].contains("(")
								&& codeArray[start].contains("(") && codeArray[start].contains("{"))) {
					lineToChars = codeArray[start].split("(?!^)");

					for (a = 0; a < lineToChars.length; a++) {
//						 System.out.println(lineToChars[a]);
						if (lineToChars[a].contains("{")) {
							bracketNesting.add("{");
							System.out.println(bracketNesting.get(bracketNesting.size() - 1));
						}
						if (lineToChars[a].contains("}")) {
							bracketNesting.remove(bracketNesting.size() - 1);
						}
					}
				}

				lineToChars = codeArray[start].split("(?!^)");

				for (a = 0; a < lineToChars.length; a++) {
//					 System.out.println(lineToChars[a]);
					if (bracketNesting.toString() == "[]") {
						break;
					}
					if (lineToChars[a].contains("}")) {
						bracketNesting.remove(bracketNesting.size() - 1);
					}
				}
				Cnc = Cnc + bracketNesting.size();
//				 System.out.println("Cnc ------------------------------------------------------------------------------------");
//				 System.out.println("Linu number" + (start+1) + "Cnc is" +Cnc);

				StatementLine s1 = new StatementLine(start, Cnc);
				StatementList.add(s1);
				start++;
			}

		}

		ArrayList<StatementLine> displayCtcList = new ArrayList<StatementLine>();

		for (y = 0; y < codeArray.length; y++) {
			isLinePresent = true;
			for (a = 0; a < StatementList.size(); a++) {
				if (StatementList.get(a).getLineNumber() == y) {
					isLinePresent = false;
				}
			}
			if (isLinePresent) {
				StatementList.add(new StatementLine(y, 0));
			}
		}

		for (y = 1; y <= StatementList.size(); y++) {
			for (z = 0; z < StatementList.size(); z++) {
				if (StatementList.get(z).getLineNumber() + 1 == y) {
					StatementLine s1 = new StatementLine(y, StatementList.get(z).getComplexity());
					displayCtcList.add(s1);
				}
			}
		}
		return displayCtcList;
	}
}
