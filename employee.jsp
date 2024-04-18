<%@page import="java.io.IOException, java.io.PrintWriter,
					 java.sql.Connection,
					 java.sql.DriverManager,
					 java.sql.PreparedStatement,
					 java.sql.SQLException,
					 javax.servlet.ServletException,
					 javax.servlet.http.HttpServlet,
					 javax.servlet.http.HttpServletRequest,
					 javax.servlet.http.HttpServletResponse,
					 java.sql.ResultSet"
 %>
 
 <% 
 		int v1 = Integer.parseInt(request.getParameter("v1"));
 		String v2 = request.getParameter("v2");
 		int f=0;
 		
 		Class.forName("oracle.jdbc.driver.OracleDriver");
 		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ep","ep");
 		PreparedStatement pstmt=con.prepareStatement("select * from login");
        ResultSet rs=pstmt.executeQuery();
        
        while(rs.next()){
        	if(v1 == Integer.parseInt(rs.getString("id")) && v2.equals(rs.getString("pwd"))){
        		f=1;
        		break;
        	}
        	else{
        		f=0;
        	}
        }
        
        if(f==1){
        	out.println("<center> <h1 style='color:green'> "+ "LOGIN SUCESSFULL"+ "</h1> </center>");
        }
        else{
        	out.println("<center> <h1 style='color:red'>"+ "LOGIN UNSUCESSFULL"+ "</h1>  </center>");
        	out.println("<center> <h3 style='color:black'>please check your credentials and try again</h3> </center>");
        	out.println("<center> <button style='background-color:#4CAF50'> <a href = 'lab7p.html'> LOGIN PAGE  </a> </button> </center>");
        }
 %>