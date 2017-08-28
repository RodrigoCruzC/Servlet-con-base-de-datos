package servletHTML;

/**
 *
 * @author EMMANUEL
 */
import BD.cDatos;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletLogin extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
            String usr = request.getParameter("user");
            String pswd = request.getParameter("password");
            
            String boton1 = request.getParameter("boton1");
            
            if(boton1 != null)
            {
                cDatos sql = new cDatos();
                String x = "";
            
                try
                {
                    
                    sql.conectar();
                    ResultSet rsX = sql.consulta("select usr , pass  from datos where usr = '"+usr+"' and pass = '"+pswd+"'");
                    if(rsX.next())
                    {
                       
                        
                        response(resp, "logeo correcto");
                    }
                    else
                    {
                        response(resp, "logeo incorrecto");
                        sql.cierraConexion();
                    }
                }
                catch(Exception e)
                {
                    x = e.getMessage();
                }
            }
            else
            {
                
            }
		
	}

	private void response(HttpServletResponse resp, String msg)
			throws IOException {
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<t1>" + msg + "</t1>");
		out.println("</body>");
		out.println("</html>");
	}
}