package com.metacube.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * This class is used to create filter for validate all sevlet. Servlet Filter
 * implementation class ServletFilters
 */
@WebFilter(urlPatterns = { "/EditEmployee", "/FriendList", "/ParkingPlan",
		"/UpdateEmployee", "/VehicleDetails", "/homepage.jsp",
		"/FriendProfile.jsp", "/VehicleDetails.jsp", "/ChoosePlan.jsp" })
public class ServletFilters implements Filter {

	/**
	 * Default constructor.
	 */

	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * This method is used to create filter for all sevlet.
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest requestOne = (HttpServletRequest) request;
		HttpServletResponse responseOne = (HttpServletResponse) response;

		HttpSession session = requestOne.getSession();
		String email = (String) session.getAttribute("email");

		if (email != null) {
			// pass the request along the filter chain
			chain.doFilter(requestOne, responseOne);
		} else {
			// if not logged in redirect to index page
			responseOne.sendRedirect("index.html");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
