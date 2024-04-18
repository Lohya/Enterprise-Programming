import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class login extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String v1=request.getParameter("fn");
		String v2=request.getParameter("ln");
		int v3= Integer.parseInt(request.getParameter("a"));
		int v4=Integer.parseInt(request.getParameter("id"));
		String v5=request.getParameter("e");
		String v6=request.getParameter("pwd");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-NN0NJJD:1521:xe","ep","ep"); // DESKTOP-NN0NJJD
			String q = "insert into login values(?,?,?,?,?,?)";
			PreparedStatement pstmt=con.prepareStatement(q);
			pstmt.setString(1, v1);
			pstmt.setString(2, v2);
			pstmt.setInt(3, v3);
			pstmt.setInt(4, v4);
			pstmt.setString(5, v5);
			pstmt.setString(6, v6);
			pstmt.executeQuery();
			con.close();
			out.println("Sucess");
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
