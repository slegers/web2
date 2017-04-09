package view.ui;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Dynamic
 */
@WebServlet("/DynamischePagina")
public class Dynamic extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Dynamic() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		//out.println(
			//	"<!DOCTYPE html><html><head><meta charset=\"UTF-8\"><title>First page</title></head><body><h1>A first page</h1><a href=\"/DynamischePagina\">second page</a></body></html>");

		String tekst = "<h1> hsl kleuren </h1> \n";
		int een = 0;
		int twee = 0;
		int drie = 0;
		for(int i = 0; i < 3600;i++){
			tekst+="<div class=blokje style=\"background-color:hsl(" + een +"," + twee  + "%," + drie + "%);\"> <p> hsl(" + een +"," + twee  + "%," + drie + "%) </p>  </div>";
			drie = drie + 10;
			if(drie > 100){
				drie = 0;
				twee = twee + 10;
			}if(twee > 100){
				twee = 0;
				een = een + 10;
			}
		}
		
		out.print("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">"
                	+
                "<title>Page Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                tekst +
                "</body>\n" +
                "</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
