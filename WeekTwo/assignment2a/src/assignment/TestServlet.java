package assignment;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("THis is a call to the init() method");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("THis is a call to the destory() method");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("This is a call to the doPost() method");
		if(request.getParameter("firstName") == null || request.getParameter("firstName") == "") {
			request.getRequestDispatcher("TestError.jsp").forward(request, response);
		}
		else if(request.getParameter("lastName") == null || request.getParameter("lastName") == "") {
			request.getRequestDispatcher("TestError.jsp").forward(request, response);
		}
		request.setAttribute("firstName", request.getParameter("firstName"));
		request.setAttribute("lastName", request.getParameter("lastName"));
		request.getRequestDispatcher("TestResponse.jsp").forward(request, response);
	}

}
