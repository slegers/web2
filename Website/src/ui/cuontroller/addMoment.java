package ui.cuontroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.db.StudyTracker;
import domain.model.StudieMoment;

/**
 * Servlet implementation class AddVak
 */
@WebServlet("/Add")
public class addMoment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public addMoment() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if("".equals(request.getParameter("uur")) || request.getParameter("uur") == null){
			request.getRequestDispatcher("form.html").forward(request,response);
		}else{
			String dag = request.getParameter("dag_week");
			String vak = request.getParameter("vak");
			double uur = 0;
			if(isDouble(request.getParameter("uur"))){
				uur = Double.parseDouble(request.getParameter("uur"));
				StudieMoment moment = new StudieMoment(uur,vak,dag);
				StudyTracker.getStudyMoment().addStdudyMoment(moment);
				request.setAttribute("aantalUur", StudyTracker.getStudyMoment().getAantalUur());
				request.getRequestDispatcher("overview.jsp").forward(request, response);

			}else{
				request.getRequestDispatcher("form.html").forward(request, response);

			}

		}
	}
	public boolean isDouble(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if("".equals(request.getParameter("uur")) || request.getParameter("uur") == null){
			request.getRequestDispatcher("form.html").forward(request, response);
		}else{
			String dag = request.getParameter("dag_week");
			String vak = request.getParameter("vak");
			double uur = Double.parseDouble(request.getParameter("uur"));
			StudieMoment moment = new StudieMoment(uur,vak,dag);
			StudyTracker.getStudyMoment().addStdudyMoment(moment);
			request.setAttribute("aantalUur", StudyTracker.getStudyMoment().getAantalUur());
			request.getRequestDispatcher("overview.jsp").forward(request, response);
		}		
	}	
}
