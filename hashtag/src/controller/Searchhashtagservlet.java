package controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.hashtag;
import model.hashtagfeed;

/**
 * Servlet implementation class Searchhashtagservlet
 */
public class Searchhashtagservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Searchhashtagservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search=request.getParameter("search");
		
		
		hashtag gh = new hashtag();
		gh.sethashtag1(search);
		boolean b = gh.searchMethod();
		System.out.println(b);
		if(b){
			hashtagfeed tg=new hashtagfeed();     // creating an object for hashtagfeed
			tg.setHashtagfeed1(search);
			Map map= tg.setHashfeed1();      //store return value from hashtagfeed 
			request.setAttribute("map", map);
			System.out.println(map.get("id"));
			
			request.setAttribute("title", search);
			RequestDispatcher rd=request.getRequestDispatcher("viewHashtag.jsp");
		    rd.forward(request, response);
		    
		}
			else{
			request.setAttribute("error","Sorry this hashtag does not exist");
		    RequestDispatcher rd=request.getRequestDispatcher("search.jsp");
		    rd.forward(request, response);
			}
	}
	
	    

}
