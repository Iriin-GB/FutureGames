package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Jogo;

/**
 * Servlet implementation class BuscarJogoController
 */
@WebServlet("/BuscarJogoController")
public class BuscarJogoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarJogoController() {
        super();

    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String nome = request.getParameter("nome");
		ArrayList<Jogo> jogos = new Jogo().buscarJogoPorNome(nome);

		if (jogos != null && !jogos.isEmpty()) {
		    for (Jogo jogo : jogos) {
		        System.out.println("[JOGO]: " + jogo.getNome());
		    }
		} else {
		    System.out.println("Nenhum jogo encontrado");
		}

		
		
	}

}
