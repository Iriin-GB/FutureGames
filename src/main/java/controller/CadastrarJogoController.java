package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Jogo;


/**
 * Servlet implementation class CadastrarJogoController
 */
@WebServlet("/CadastrarJogoController")
public class CadastrarJogoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarJogoController() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	String mensagem;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String mensagem;		

		
		String url = request.getParameter("imagemUrl");
		String nome = request.getParameter("nome");
		String data = request.getParameter("dataLancamento");
		String produtora = request.getParameter("empresaProducao");
		String publicadora = request.getParameter("empresaPublicacao");
		
		//System.out.println("Teste: " + url + " " + nome + " " + data + " " + produtora + " " + publicadora);
	

		RequestDispatcher dispatcher = request.getRequestDispatcher("cadastro.jsp");
		if (url == null || url.isEmpty()
		        || nome == null || nome.isEmpty()
		        || data == null || data.isEmpty()
		        || produtora == null || produtora.isEmpty()
		        || publicadora == null || publicadora.isEmpty()) {
		    mensagem = "Erro no cadastramento, preencha todos os campos";
		} else {
		    mensagem = "Cadastrado com sucesso";
			Jogo jogo = new Jogo(url, nome, data, produtora, publicadora);
		    jogo.salvar();
		    
		}
		request.setAttribute(mensagem, mensagem);
		dispatcher.forward(request, response);
		System.out.println(mensagem);
	}


}
