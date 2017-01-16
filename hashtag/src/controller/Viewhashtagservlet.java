package controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.hashtagfeed;

/**
 * Servlet implementation class Viewhashtagservlet
 */

public class Viewhashtagservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Viewhashtagservlet() {
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
		// TODO Auto-generated method stub
		String button = request.getParameter("button");
		hashtagfeed t1=new hashtagfeed();
		if(button.equals("post")){
		String ct=request.getParameter("text");
		String t=request.getParameter("title");
		
		t1.setHashtagfeed1(t);
		t1.setContent(ct);
		t1.setParentFeed(0); //initialized to 0 because we are taking it for post
	    t1.hashfeed1();
	    
	    t1.setHashtagfeed1(t);
		Map map= t1.setHashfeed1();    //store return value from hashtagfeed 
		request.setAttribute("map", map);
		
		request.setAttribute("title", t);
		RequestDispatcher rd=request.getRequestDispatcher("viewHashtag.jsp");
	    rd.forward(request, response);
	    
		}else{
			String content = request.getParameter("reply");
			String hashtag = request.getParameter("title");
			int id = Integer.parseInt(request.getParameter("id"));
			t1.setHashtagfeed1(hashtag);
			t1.setContent(content);
			t1.setParentFeed(id); 
		    t1.hashfeed1();
		    
		    
		   
			t1.setHashtagfeed1(hashtag);
			Map map= t1.setHashfeed1();    //store return value from hashtagfeed 
			request.setAttribute("map", map);
			
			request.setAttribute("title", hashtag);
			RequestDispatcher rd=request.getRequestDispatcher("viewHashtag.jsp");
		    rd.forward(request, response);
		    
		}
	}

}
