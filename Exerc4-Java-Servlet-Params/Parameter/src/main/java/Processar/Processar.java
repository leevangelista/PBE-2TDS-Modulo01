package Processar;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class Processar
 */
@WebServlet("/Processar")
public class Processar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub  
		String nome = request.getParameter("nome");
        
        // Configura a resposta para ser HTML
        response.setContentType("text/html");
        
        // Escreve a resposta no navegador
        response.getWriter().println("<h1>Olá, " + nome + "!</h1>");
        response.getWriter().println("<p>Seu nome foi recebido com sucesso.</p>");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtém o parâmetro enviado no corpo da requisição
        String nome = request.getParameter("nome");

        // Configura a resposta para ser HTML
        response.setContentType("text/html");

        // Escreve a resposta no navegador
        response.getWriter().println("<h1>Olá, " + nome + "!</h1>");
        response.getWriter().println("<p>Seu nome foi recebido via POST com sucesso.</p>");

    }

}
