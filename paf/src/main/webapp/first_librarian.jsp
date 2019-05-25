<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
     <%@ page import="com.model.register_GS" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>lms_librarian_first</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<link href="resources/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="resources/css/bootstrap.css">
<script type="text/javascript" src="resources/js/cufon-yui.js"></script>
<script type="text/javascript" src="resources/js/arial.js"></script>
<script type="text/javascript" src="resources/js/cuf_run.js"></script>
<script src="js/validation.js" type="text/javascript"></script>
</head>
<body>
<div class="main">
  <div class="header">
    <div class="header_resize">
      <div class="logo">
         <h1><a href="#"><small>SellNBye </small><span>E-commerce</span> System</a></h1>
      </div>
      <div class="menu_nav">
        <ul>
          <li><a href="index.jsp"><span><span>Home</span></span></a></li>
          <li><a href="logout.jsp"><span><span>Logout</span></span></a></li>
          <li><a href="about.jsp"><span><span>About Us</span></span></a></li>
          <li><a href="contact.jsp"><span><span>Contact Us</span></span></a></li>
        </ul>
      </div>
      <div class="clr"></div>
    </div>
  </div>
  <div class="hbg">&nbsp;</div>
  <div class="content">
    <div class="content_resize">
      <div class="mainbar">
        <div class="article">
		<div class="input-group mb-3">
                         <form action="search1" method="post">
                                        <div class="input-group mb-3">
                                                <div class="input-group-prepend">
                                                    <span class="input-group-text" id="search" >Search Product</span>
                                                </div>
                                            <input type="text" class="form-control" name="search" placeholder="Enter book title or author name" id="search">&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;
                                            <button type="submit" class="btn btn-outline-secondary" id="createbutton" >Search</button>
                                        </div>
                                </form>
                            </div>
          </div>
       
      </div>
           <div class="sidebar">
        <div class="gadget">
          <h2 class="star">Menu</h2>
          <div class="clr"></div>
          <ul class="sb_menu">
            <li><a href="#">Home</a></li>
            <li><a href="#">Cart</a></li>
            <li><a href="#">Product</a></li>
            <li><a href="#">Profile</a></li>
            <li><a href="#">Archives</a></li>
          </ul>
        </div>
        <div class="gadget">
          <h2 class="star"><span>Sponsors</span></h2>
          <div class="clr"></div>
          <ul class="ex_menu">
            <li><a href="https://www.keells.com/">John keels holding</a><br />
              Sri Lanka's largest listed conglomerate in the Colombo Stock Exchange.</li>
            <li><a href="https://www.virtusa.com/">Virtusa</a><br />
              Provider of end-to-end digital transformation and IT outsourcing services to Global 2000 companies.</li>
            <li><a href="https://www.ifsworld.com/lk/">IFS</a><br />
              Global enterprise software solution provider.</li>
            <li><a href="https://www.99xtechnology.com/">99xtechnology</a><br />
              Leading software services provider that specialises in product engineering.</li>
            <li><a href="https://www.lseg.com/lseg-technology">Millenium IT</a><br />
              Sri Lanka-based information technology firm that specialises in electronic trading systems</li>
          </ul>
        </div>
      </div>
      <div class="clr"></div>
    </div>
  </div>
  <div class="fbg">
    <div class="fbg_resize">
      <div class="col c1">
        <h2><span>About</span></h2>
        <img src="images/white.jpg" width="56" height="56" alt="" />
        <p>---------------------------------------------------------------------</p>
      </div>
      <div class="col c2">
        <h2><span></span></h2>
        <ul class="sb_menu">
        </ul>
      </div>
      <div class="col c3">
        <h2>Contact</h2>
        <p>If you have any clarification don't hesitate to contact us...</p>
        <p><a href="#">support@yoursite.com</a></p>
        <p>+94 771905002<br />
          +94 702845193</p>
        <p>Address: 123, nagahawatta road, colombo 7</p>
      </div>
      <div class="clr"></div>
    </div>
  </div>
  <div class="footer">
    <div class="footer_resize">
      <p class="lf">Group No: WE_19_20 </p>
      <p class="rf"> ITPM Group project </p>
	  <p class="rf">2019/ </p>
      <div class="clr"></div>
    </div>
  </div>
</div>
</html>