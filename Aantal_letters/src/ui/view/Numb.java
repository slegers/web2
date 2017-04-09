package ui.view;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.client.methods.RequestBuilder;

import domain.Counter;

/**
 * Servlet implementation class Numb
 */
@WebServlet("/Numb")
public class Numb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Numb() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String woord = request.getParameter("woord");
		String letter = request.getParameter("letter");
		System.out.println(woord);
		System.out.println(letter);
		Counter c = new Counter(woord);
		System.out.println(c.count("p"));
		request.setAttribute("count", c.count(letter));
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher d = request.getRequestDispatcher("test.jsp");
		d.forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
