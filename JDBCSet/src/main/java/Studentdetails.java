import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Student.DBConnection;

/**
* Servlet implementation class ProductDetails
*/
@WebServlet("/Studentdetails")
public class Studentdetails extends HttpServlet {
        private static final long serialVersionUID = 1L;
       
    /**
* @see HttpServlet#HttpServlet()
*/
    public Studentdetails() {
        super();
        // TODO Auto-generated constructor stub
    }

        /**
         * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                // TODO Auto-generated method stub
                
                try {
                         PrintWriter out = response.getWriter();
                         out.println("<html><body>");
                         
                        InputStream in = getServletContext().getResourceAsStream("/WEB-INF/config.properties");
                        Properties props = new Properties();
                        props.load(in);
                        
                        
                        com.Student.DBConnection conn = new com.Student.DBConnection(props.getProperty("url"), props.getProperty("userid"), props.getProperty("password"));
                        CallableStatement stmt = conn.getConnection().prepareCall("{call add_studentdetails(?, ?)}");
                        stmt.setString(1, "name");
						stmt.setInt(2,(456));
                        executeUpdate();
                        
                        out.println("Stored procedure has been executed.<Br>");
                        stmt.close();
                        
                        
                        out.println("</body></html>");
                        conn.closeConnection();
                        
                } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                } catch (SQLException e) {
                        e.printStackTrace();
                }
        }

		private void executeUpdate() {
			// TODO Auto-generated method stub
			
		}

        /**
         * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                // TODO Auto-generated method stub
                doGet(request, response);
        }

}
