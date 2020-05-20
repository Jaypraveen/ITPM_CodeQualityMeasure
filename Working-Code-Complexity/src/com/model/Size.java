package com.model;

public class Size {

	private int keyword;
	private int identifier;
	private int operator;
	private int numerics;
	private int strings;
	
	public Size() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Size(int keyword, int identifier, int operator, int numerics, int strings) {
		super();
		this.keyword = keyword;
		this.identifier = identifier;
		this.operator = operator;
		this.numerics = numerics;
		this.strings = strings;
	}

	

	public int getKeyword() {
		return keyword;
	}

	public void setKeyword(int keyword) {
		this.keyword = keyword;
		System.out.println(keyword);
	}

	public int getIdentifier() {
		return identifier;
	}

	public void setIdentifier(int identifier) {
		this.identifier = identifier;
		System.out.println(identifier);
	}

	public int getOperator() {
		return operator;
	}

	public void setOperator(int operator) {
		this.operator = operator;
		System.out.println(operator);
	}

	public int getNumerics() {
		return numerics;
	}

	public void setNumerics(int numerics) {
		this.numerics = numerics;
		System.out.println(numerics);
	}

	public int getStrings() {
		return strings;
	}

	public void setStrings(int strings) {
		this.strings = strings;
		System.out.println(strings);
	}
	
	
	/*
	private int complexitySize;
	private int weightOfKeyWords;
	private int numberOfKeyWords;
	private int weightOfOperators;
	private int numberOfOperators;
	private int weightOfIdentfiers;
	private int numberOfIdentifiers;
	private int weightOfNumerics;
	private int numberOfNumerics;
	private int weightOfStrings;
	private int nNumberOfStrings;
	private int totalWeightOfOperators;
	private int totalWeightOfKeywords;

	public Size() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Size(int complexitySize, int weightOfKeyWords, int numberOfKeyWords, int weightOfOperators,
			int numberOfOperators, int weightOfIdentfiers, int numberOfIdentifiers, int weightOfNumerics,
			int numberOfNumerics, int weightOfStrings, int nNumberOfStrings, int totalWeightOfOperators,
			int totalWeightOfKeywords) {
		super();
		this.complexitySize = complexitySize;
		this.weightOfKeyWords = weightOfKeyWords;
		this.numberOfKeyWords = numberOfKeyWords;
		this.weightOfOperators = weightOfOperators;
		this.numberOfOperators = numberOfOperators;
		this.weightOfIdentfiers = weightOfIdentfiers;
		this.numberOfIdentifiers = numberOfIdentifiers;
		this.weightOfNumerics = weightOfNumerics;
		this.numberOfNumerics = numberOfNumerics;
		this.weightOfStrings = weightOfStrings;
		this.nNumberOfStrings = nNumberOfStrings;
		this.totalWeightOfOperators = totalWeightOfOperators;
		this.totalWeightOfKeywords = totalWeightOfKeywords;
	}

	public int getComplexitySize() {
		return complexitySize;
	}

	public void setComplexitySize(int complexitySize) {
		this.complexitySize = complexitySize;
	}

	public int getWeightOfKeyWords() {
		return weightOfKeyWords;
	}

	public void setWeightOfKeyWords(int weightOfKeyWords) {
		this.weightOfKeyWords = weightOfKeyWords;
	}

	public int getNumberOfKeyWords() {
		return numberOfKeyWords;
	}

	public void setNumberOfKeyWords(int numberOfKeyWords) {
		this.numberOfKeyWords = numberOfKeyWords;
	}

	public int getWeightOfOperators() {
		return weightOfOperators;
	}

	public void setWeightOfOperators(int weightOfOperators) {
		this.weightOfOperators = weightOfOperators;
	}

	public int getNumberOfOperators() {
		return numberOfOperators;
	}

	public void setNumberOfOperators(int numberOfOperators) {
		this.numberOfOperators = numberOfOperators;
	}

	public int getWeightOfIdentfiers() {
		return weightOfIdentfiers;
	}

	public void setWeightOfIdentfiers(int weightOfIdentfiers) {
		this.weightOfIdentfiers = weightOfIdentfiers;
	}

	public int getNumberOfIdentifiers() {
		return numberOfIdentifiers;
	}

	public void setNumberOfIdentifiers(int numberOfIdentifiers) {
		this.numberOfIdentifiers = numberOfIdentifiers;
	}

	public int getWeightOfNumerics() {
		return weightOfNumerics;
	}

	public void setWeightOfNumerics(int weightOfNumerics) {
		this.weightOfNumerics = weightOfNumerics;
	}

	public int getNumberOfNumerics() {
		return numberOfNumerics;
	}

	public void setNumberOfNumerics(int numberOfNumerics) {
		this.numberOfNumerics = numberOfNumerics;
	}

	public int getWeightOfStrings() {
		return weightOfStrings;
	}

	public void setWeightOfStrings(int weightOfStrings) {
		this.weightOfStrings = weightOfStrings;
	}

	public int getnNumberOfStrings() {
		return nNumberOfStrings;
	}

	public void setnNumberOfStrings(int nNumberOfStrings) {
		this.nNumberOfStrings = nNumberOfStrings;
	}

	public int getTotalWeightOfOperators() {
		return totalWeightOfOperators;
	}

	public void setTotalWeightOfOperators(int totalWeightOfOperators) {
		this.totalWeightOfOperators = totalWeightOfOperators;
	}

	public int getTotalWeightOfKeywords() {
		return totalWeightOfKeywords;
	}

	public void setTotalWeightOfKeywords(int totalWeightOfKeywords) {
		this.totalWeightOfKeywords = totalWeightOfKeywords;
	}
*/
}
