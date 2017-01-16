package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.sql.Statement;

import DAO.DBconnect;

public class hashtag {
	private String hashtag1;
	
	
	public String getHashtag1() {
		return hashtag1;
	}

	public void sethashtag1(String hashtag1) {
		this.hashtag1 = hashtag1;
	}
	//* method1 is created to insert values in the database
	
public boolean method1()
{
	int ch =0;
DBconnect db=new DBconnect();
Connection c=db.getConnection(); 
Date d=new Date();
DateFormat df=new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
String date1=df.format(d);
try {
PreparedStatement ps=c.prepareStatement("insert into hashtag values(?,?)");
ps.setString(1,getHashtag1());
ps.setString(2,date1);
ch = ps.executeUpdate();
if(ch!=0)
{
	//System.out.println("method1"+ch);
	return true;
	}
}
catch (SQLException e) {
	// TODO Auto-generated catch block	
	e.printStackTrace();
}

return false;
}

//public boolean searchMethod() {
//
//	DBconnect db=new DBconnect();//* "Sorry this hashtag does not exist//
//	Connection c=db.getConnection(); 
//	try{
//		Statement st=c.createStatement();
//		ResultSet rs=st.executeQuery("select nameofhashtag from Hashtag where nameofhashtag='"+getHashtag1()+"'");
//	if(rs.next()){
//		c.close();
//		return true;
//	             }
//	}catch(Exception e){
//		e.printStackTrace();
//	  }
//return false;
//
//}

public boolean searchMethod() {  // to select nameofhashtAG
	// TODO Auto-generated method stub
	
	DBconnect db=new DBconnect();//* "Sorry this hashtag does not exist//
	Connection c=db.getConnection(); 
	try{
		Statement st=c.createStatement();
		ResultSet rs=st.executeQuery("select nameofhashtag from Hashtag where nameofhashtag='"+getHashtag1()+"'");
	if(rs.next()){
		c.close();
		return true;
	             }
	}catch(Exception e){
		e.printStackTrace();
	  }
return false;


	
}

}

