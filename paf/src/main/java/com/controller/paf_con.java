package com.controller;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.model.Addbook;
import com.model.Addproduct;
import com.model.booking;
import com.model.register_GS;
import com.service.Deletebookdb;
import com.service.addadmin;
import com.service.addbookavailability;
import com.service.addbookdb;
import com.service.addbooktocart;
import com.service.addlibrarian;
import com.service.addproductdb;
import com.service.addtoqueue;
import com.service.check_login;
import com.service.check_loginCredential;
import com.service.deletebookavailability;
import com.service.hgetcopycount;
import com.service.hststus;
import com.service.hupdatecopycount;
import com.service.hupdatestatus;
import com.service.onequeueitemcount;
import com.service.register_Q;
import com.service.removecart;
import com.service.searchanja;
import com.service.searchbook;
import com.service.updateavailability;
import com.service.updatebookdb;
import com.service.viewCart;
import com.service.viewliadmin;
import com.service.viewlibrarians;
import com.service.viewqueue;

@Controller
public class paf_con{
		
		@RequestMapping("/register")
		
		public ModelAndView insert(HttpServletRequest request,HttpServletResponse respond) throws ClassNotFoundException, SQLException
		{
			String btn_name = request.getParameter("st");
			ModelAndView mv = new ModelAndView();
			
			if(btn_name.equals("useradd")) {
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String phone = request.getParameter("phone");
			String birthday = request.getParameter("birthday");
			String nic = request.getParameter("nic");
			String mail = request.getParameter("email");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			register_GS obj = new register_GS();
			
			obj.setName(name);
			obj.setAddress(address);
			obj.setPhone(phone);
			obj.setBirthday(birthday);
			obj.setNic(nic);
			obj.setEmail(mail);
			obj.setUsername(username);
			obj.setPassword(password);
			
			register_Q us = new register_Q();
			us.adduser(obj);
			
			System.out.println(name);
			mv.setViewName("login.jsp");
			
			}
			else if(btn_name.equals("libadd")) {
				String name = request.getParameter("name");
				String address = request.getParameter("address");
				String phone = request.getParameter("phone");
				String birthday = request.getParameter("birthday");
				String nic = request.getParameter("nic");
				String mail = request.getParameter("email");
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				
				register_GS obj = new register_GS();
				
				obj.setName(name);
				obj.setAddress(address);
				obj.setPhone(phone);
				obj.setBirthday(birthday);
				obj.setNic(nic);
				obj.setEmail(mail);
				obj.setUsername(username);
				obj.setPassword(password);
				
				addadmin us = new addadmin();
				us.addadmin(obj);
				
				System.out.println(name);
				viewliadmin lib = new viewliadmin();
				ArrayList list = lib.viewlib(obj);
				
				
				mv.setViewName("librarians.jsp");
				mv.addObject("result",list);
				
				}
			return mv;
			
		}
		@RequestMapping("/login")
		public ModelAndView login(HttpServletRequest request,HttpServletResponse respond)throws ClassNotFoundException, SQLException
		{
			String uname = request.getParameter("username");
			String password = request.getParameter("password");
			
			ModelAndView mv = new ModelAndView();
			
			register_GS obj2 = new register_GS();
			
			obj2.setUsername(uname);
			obj2.setPassword(password);
			
			check_loginCredential lc = new check_loginCredential();
			boolean result = lc.loginUserService(obj2);
			System.out.println(result);
			//-------------------------
			//Get if user or admin
			register_GS obj3 = new register_GS();
			
			obj3.setUsername(uname);
			obj3.setPassword(password);
		
			check_login cl  = new check_login();
			String check = cl.check_login(obj3);
			
			//----------------------------
			
			if(result == true && check.equals("Admin"))
			{
				//recordLoginTime LT = new recordLoginTime();
				//LT.logingRecord(uname);
				
				HttpSession session = request.getSession(true);  
				
				
				 
		        session.setAttribute("currentSessionUser",obj3); 
		       
		        
		   
		        //Pass daily attendance!!!!
		       // getEmployeeService ES= new getEmployeeService();
				//ArrayList search_list = ES.searchEmployeeNames();

				//search4Service US = new search4Service();//Create Search4 service object
				//ArrayList search_list2 = US.getDailyStatus();
				
				mv.setViewName("first_librarian.jsp");//logged-in Admin page  
				
			}
			else if(result == true && check.equals("User"))
			{
				//recordLoginTime LT = new recordLoginTime();
				//LT.logingRecord(uname); 
		        
				HttpSession session = request.getSession(true);  
		        session.setAttribute("currentSessionUser",obj3); 
		       
				mv.setViewName("first_member.jsp");//logged-in User page    
			}
			else
			{
				String erorr = "Eneter Correct Credentials!!";
				mv.addObject("result",erorr);
				mv.setViewName("LoginError.jsp");
			}
			
			return mv;
		}
		
@RequestMapping("/addbook")
		
		public ModelAndView addbook(HttpServletRequest request,HttpServletResponse respond)
		{
			String productno = request.getParameter("productno");
			String title = request.getParameter("title");
			int copy = Integer.parseInt(request.getParameter("copyno"));
			int price = Integer.parseInt(request.getParameter("price"));
			String description = request.getParameter("description");
			
			Addproduct objb = new Addproduct();
			
			objb.setProductId(productno);
			objb.setProductTitle(title);
			objb.setPrice(price);
			objb.setDescription(description);
			objb.setTotalcopy(copy);
			
			addproductdb bk = new addproductdb();
			bk.addproductdb(objb);
			
			ModelAndView mv = new ModelAndView();
			mv.setViewName("first_librarian.jsp");
			
			return mv;
		}



@RequestMapping("/viewupdate_book")

public ModelAndView viewupdate_book(HttpServletRequest request,HttpServletResponse respond) throws ClassNotFoundException, SQLException
{
	
	String btn_name = request.getParameter("st");
String bookno = request.getParameter("bookno");
ModelAndView mv = new ModelAndView();
Addproduct objb = new Addproduct();
	
	objb.setBookId(bookno);
	if(btn_name.equals("update"))
	{
	
	searchanja se = new searchanja();
	ArrayList list = se.searchbook(objb);
	
	System.out.println(bookno);
	
	
	mv.setViewName("updatebook.jsp");
	mv.addObject("result",list);
	}
	else if(btn_name.equals("delete"))
	{
		deletebookavailability de = new deletebookavailability();
		de.Deletebookdb(objb);
		Deletebookdb del = new Deletebookdb();
		del.Deletebookdb(objb);
		
		mv.setViewName("first_librarian.jsp");
	}
	
	return mv;
}

@RequestMapping("/search1")

public ModelAndView search1(HttpServletRequest request,HttpServletResponse respond) throws ClassNotFoundException, SQLException
{
	String search = request.getParameter("search");
	
	register_GS objb = new register_GS();
	
	objb.setSearch(search);
	
	searchbook se = new searchbook();
	ArrayList list = se.searchbook(objb);
	
	System.out.println(search);
	
	ModelAndView mv = new ModelAndView();
	mv.setViewName("viewsearch_librarian.jsp");
	mv.addObject("result",list);
	
	return mv;
}

@RequestMapping("/updatebook")

public ModelAndView updatebook(HttpServletRequest request,HttpServletResponse respond) throws ClassNotFoundException, SQLException
{	ModelAndView mv = new ModelAndView();
	String btn_name = request.getParameter("st");
	String bookno = request.getParameter("bookno");
	int copyno = Integer.parseInt(request.getParameter("copies"));
	int addcopy = Integer.parseInt(request.getParameter("newcopies"));
	
	Addbook objb = new Addbook();
	
	objb.setBookId(bookno);
	objb.setCopy_No(copyno);
	objb.setAddcopy(addcopy);
	
System.out.println(addcopy);
	
	System.out.println(bookno);
	if(btn_name.equals("update"))
	{
	updatebookdb se = new updatebookdb();
	se.updatebookdb(objb);
	
	updateavailability se2 = new updateavailability();
	se2.updatebookdb(objb);
	
	searchanja se1 = new searchanja();
	ArrayList list = se1.searchbook(objb);
	
	System.out.println(bookno);
	
	mv.setViewName("viewbook_librarian.jsp");
	mv.addObject("result",list);
	}
	
	return mv;
	
}




}
