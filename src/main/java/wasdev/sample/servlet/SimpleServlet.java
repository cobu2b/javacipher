package wasdev.sample.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet("/SimpleServlet")
public class SimpleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().print("Hello World!");

        String cipherSuite = (String) req.getAttribute("javax.servlet.request.cipher_suite");
 
	if (cipherSuite != null) {
    		X509Certificate certChain[] = (X509Certificate[]) req.getAttribute("javax.servlet.request.X509Certificate");
    		if (certChain != null) {
        		for (int i = 0; i < certChain.length; i++) {
				response.getWriter().print("Client Certificate [" + i + "] = "+ certChain[i].toString());
        		}
    		}
	}
    }

}
