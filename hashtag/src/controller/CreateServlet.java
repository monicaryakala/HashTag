package controller;

import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.hashtag;

/**
 * Servlet implementation class CreateServlet
 */
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CreateServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String create=request.getParameter("search");
	 hashtag h=new hashtag();  // to create object for hashtag class
	//System.out.println(create);
	//String pattern="[!@#$%^&*(){}><?{}[];\',.\"/\\]";
	// String special_char="[(^|(?<=[\\s>.(])|[{\\[])\"((?:(?:\\([^)]+\\))|(?:\\{[^}]+\\})|(?:\\[[^]]+\\])|(?:<(?!>)|(?<!<)>|<>|=|[()]+(?! )))*)([^\"]+?)(?:\\(([^)]+?)\\)(?=\"))?\":([\\w\"$_.+!*'(),\";/?:@=&%#{}|^~\\[\\]`-]+?)(/)?([^\\w/;]*?)([]}]|(?=\\s|$|\\)))0-9 ]";
    
  
    //* to check whether the hashtag consists of any special characters	
	 
        Pattern p=Pattern.compile("[^A-Za-z0-9]");
        Matcher m=p.matcher(create);
   
	boolean b = m.find();
    if (b)
    {
    	request.setAttribute("error","There is a special character in your string ");
         RequestDispatcher rd=request.getRequestDispatcher("createpg.jsp");
         rd.forward(request, response);
    }
     else{
   
	h.sethashtag1(create); // to set object
	
	boolean b1=h.method1();
	//System.out.println(b);
	if(b1){
		RequestDispatcher rd=request.getRequestDispatcher("search.jsp");
	    rd.forward(request, response);  
	    
	}
		else{
		request.setAttribute("error","The hashtag already exist, please choose a different name");
	    RequestDispatcher rd=request.getRequestDispatcher("createpg.jsp");
	    rd.forward(request, response);
		}
	    
	}
}

	}


