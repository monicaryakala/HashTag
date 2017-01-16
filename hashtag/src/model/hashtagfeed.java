package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import DAO.DBconnect;

public class hashtagfeed {
	private String hashtagfeed1;
	private String content;
	private int parentFeed;
	

public void hashfeed1(){
	int fd=0;
	DBconnect db=new DBconnect();
	Connection c=db.getConnection(); 
	Date d=new Date();
	DateFormat df=new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
	String date1=df.format(d);
	try{
		
	
	PreparedStatement ps=c.prepareStatement("insert into hashtagfeed values(?,?,?,?,?)");
	ps.setString(1,null);
	ps.setString(2,date1);
	ps.setInt(3,getParentFeed());
	ps.setString(4, getHashtagfeed1());
	ps.setString(5,getContent());
	fd = ps.executeUpdate();
	if(fd!=0)
	{
		System.out.println("hashfeed1"+fd);
		return;
		
	}
}
	catch (SQLException e){
	e.printStackTrace();
	}
}
	
public String getHashtagfeed1() {
	return hashtagfeed1;
}
public void setHashtagfeed1(String hashtagfeed1) {
	this.hashtagfeed1 = hashtagfeed1;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public int getParentFeed() {
	return parentFeed;
}
public void setParentFeed(int parentFeed) {
	this.parentFeed = parentFeed;
}

public Map setHashfeed1(){
DBconnect db=new DBconnect();
Connection c=db.getConnection(); 
List id = new ArrayList();           //* id belongs to post
List post = new ArrayList();
List reply =new ArrayList();
List rep = null;
Map map = new HashMap();
try{
Statement st=c.createStatement();
Statement st1 = c.createStatement();
ResultSet rs=st.executeQuery("select id, content from hashtagfeed where hashtag='"+getHashtagfeed1()+"' and parentfeedid="+0+" order by time DESC");

while(rs.next()){
	int id1 = rs.getInt("id");
id.add(id1);
post.add(rs.getString("content"));

ResultSet rs1=st1.executeQuery("select content from hashtagfeed where hashtag='"+getHashtagfeed1()+"' and parentfeedid="+id1+" order by time DESC"); // for fetching replies for particular post
rep = new ArrayList();
while(rs1.next()){
	rep.add(rs1.getString("content"));
}
reply.add(rep);
}



map.put("id", id);
map.put("post", post);
map.put("reply",reply );
         
}
catch(Exception e){
e.printStackTrace();
}
return map;
}
}
	

