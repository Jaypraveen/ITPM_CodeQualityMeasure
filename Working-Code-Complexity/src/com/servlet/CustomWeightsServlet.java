package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Methods;
import com.model.Size;
import com.model.Variables;

/**
 * Servlet implementation class GetUserWeights
 */
@WebServlet("/GetUserWeights")
public class CustomWeightsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomWeightsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Size size = new Size();
		Variables variables = new Variables();
		Methods methods = new Methods();

		// TODO Auto-generated method stub
		// Weights of
		// Size---------------------------------------------------------------------------
		if (request.getParameter("hiddenValue").equals("size")) {
			int userInputKeywordWeight = Integer.parseInt(request.getParameter("inputKeywordWeight"));
			size.setKeyword(userInputKeywordWeight);

			int userInputIdentifiersWeight = Integer.parseInt(request.getParameter("inputIdentifiersWeight"));
			size.setIdentifier(userInputIdentifiersWeight);

			int userInputOperatorWeight = Integer.parseInt(request.getParameter("inputOperatorWeight"));
			size.setOperator(userInputOperatorWeight);

			int userInputNumericsWeight = Integer.parseInt(request.getParameter("inputNumericsWeight"));
			size.setNumerics(userInputNumericsWeight);

			int userInputStringsWeight = Integer.parseInt(request.getParameter("inputStringsWeight"));
			size.setStrings(userInputStringsWeight);
			
			

		} else

		// Weights of
		// Variables---------------------------------------------------------------------------
		if (request.getParameter("hiddenValue").equals("variable")) {
			int userInputGlobalWeight = Integer.parseInt(request.getParameter("inputGlobalWeight"));
			variables.setGlobalVar(userInputGlobalWeight);

			int userInputLocalWeight = Integer.parseInt(request.getParameter("inputLocalWeight"));
			variables.setLocalVar(userInputLocalWeight);

			int userInputPrimitiveVariableWeight = Integer
					.parseInt(request.getParameter("inputPrimitiveVariableWeight"));
			variables.setPrimitiveTypeVar(userInputPrimitiveVariableWeight);

			int userInputCompositeVariableWeight = Integer
					.parseInt(request.getParameter("inputCompositeVariableWeight"));
			variables.setCompositeTypeVar(userInputCompositeVariableWeight);
		} else

		// Weights of
		// Methods---------------------------------------------------------------------------
		if (request.getParameter("hiddenValue").equals("method")) {
			int inputPrimitiveReturnWeight = Integer.parseInt(request.getParameter("inputPrimitiveReturnWeight"));
			methods.setPrimitiveReturnType(inputPrimitiveReturnWeight);

			int userInputCompositeReturnWeight = Integer.parseInt(request.getParameter("inputCompositeReturnWeight"));
			methods.setCompositeReturnType(userInputCompositeReturnWeight);

			int userInputVoidReturnWeight = Integer.parseInt(request.getParameter("inputVoidReturnWeight"));
			methods.setVoidReturnType(userInputVoidReturnWeight);

			int userInputPrimitiveParaWeight = Integer.parseInt(request.getParameter("inputPrimitiveParaWeight"));
			methods.setPrimitiveReturnType(userInputPrimitiveParaWeight);

			int userInputCompositeParaWeight = Integer.parseInt(request.getParameter("inputCompositeParaWeight"));
			methods.setCompoisteDataType(userInputCompositeParaWeight);
		} else {
			System.out.println("Keep the default weights");
		}

	}
	
}
