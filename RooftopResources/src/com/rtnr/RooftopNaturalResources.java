package com.rtnr;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rtnr.engine.Analyzer;
import com.rtnr.vo.Analysis;
import com.rtnr.vo.Parcel;

/**
 * Servlet implementation class RooftopNaturalResources
 */
@WebServlet("/RooftopNaturalResources")
public class RooftopNaturalResources extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RooftopNaturalResources() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		out.println(request.getQueryString());
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		double latitude = Double.parseDouble(request.getParameter("latitude"));
		double longitude = Double.parseDouble(request.getParameter("longitude"));
		String address = request.getParameter("address");
		Parcel p = new Parcel();
		p.setAddress(address);
		p.setLatitude(latitude);
		p.setLongitude(longitude);
		Analysis a = Analyzer.analyze(p);
	
		out.println(a.getWaterSavings());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
