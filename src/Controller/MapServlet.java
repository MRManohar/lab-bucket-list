package Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.TouristPlace;
import service.MapOperations;


@WebServlet(urlPatterns= {"/map"})
public class MapServlet extends HttpServlet {
	
	Map<Integer,String> map = new HashMap<Integer, String>();

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String destination = request.getParameter("travel");
		String rank = request.getParameter("rank");
		String add = request.getParameter("add");
		
		String sortRandom = request.getParameter("sortrandomly");
		String sortInEntryOrder = request.getParameter("sortinentryorder");
		String sortAlphabetically = request.getParameter("sortalphabetically");
		String remove = request.getParameter("delete");
		String reset = request.getParameter("reset");
		
		TouristPlace place = new TouristPlace(name,destination,rank);
		place.setName(name);
		place.setDestination(destination);
		place.setRank(rank);		
			
		MapOperations mapOperations = new MapOperations();
		
		if(add!=null) {
			// call the add method and store the return value in a map variable
			
			map = mapOperations.add(place);
			
			request.setAttribute("bucketList",map /*return variable */);
			request.setAttribute("message", "user added successfully");
			RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/map.jsp");
			rd.forward(request, response);
		}

		if(remove!=null) {
			// call the remove method and store the return value in a map variable
			
			map = mapOperations.remove(place);
			request.setAttribute("bucketList",map /*return variable */);
			RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/map.jsp");
			rd.forward(request, response);
		}

		
		if(sortRandom!=null) {
			// call the sortRandomly method and store the return value in a map variable
			
			map = mapOperations.sortRandomly(place);
			request.setAttribute("bucketList",map/*return variable */);
			RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/map.jsp");
			rd.forward(request, response);
		}

		if(sortInEntryOrder!=null) {
			// call the sortInEntryOrder and store the return value in a map variable
			
			Map<Integer,String> map1 = new HashMap<Integer, String>();
			map1 = mapOperations.sortInEntryOrder(map);
			
			request.setAttribute("bucketList",map1 /*return variable */);
			RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/map.jsp");
			rd.forward(request, response);
		}
		if(sortAlphabetically!=null) {
			// call the sort Alphabetically and store the return value in a map variable
			
			Map<Integer,String> map2 = new HashMap<Integer, String>();
			map2 = mapOperations.sortAlphabetically(map);
			
			request.setAttribute("bucketList",map2/*return variable */);
			RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/map.jsp");
			rd.forward(request, response);
		}

		if(reset!=null) {	
			// call the reset method and store the return value in a map variable
			
			Map<Integer,String> map3 = new HashMap<Integer, String>();
			map3 = (Map<Integer, String>) mapOperations.reset(map);
			
			
			request.setAttribute("bucketList",map3 /*return variable */);
			RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/map.jsp");
			rd.forward(request, response);
		}

	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

