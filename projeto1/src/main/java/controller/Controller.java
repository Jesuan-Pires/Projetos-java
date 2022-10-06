package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO; //<---CLASSE IMPORTADA 
import model.JavaBeans;//<--CLASSE IMPORTADA

@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/select", "/update", "/delete" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JavaBeans javabeans = new JavaBeans();

	public Controller() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			cadastro(request, response);
		} else if (action.equals("/insert")) {
			novoItem(request, response);
		} else if (action.equals("/select")) {
			listarItem(request, response);
		} else if (action.equals("/update")) {
			editarItem(request, response);
		} else if (action.equals("/delete")) {
			excluirItem(request, response);
		} else {
			response.sendRedirect("index.html");
		}

	}

	// LISTAR PRODUTOS
	protected void cadastro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.sendRedirect("cadastro.jsp");
		/** Criando um objeto que irá receber os dados javaBeans **/
		ArrayList<JavaBeans> lista = dao.listarItens();
		// encaminhar a lista redirecionando ao doc cadastro.jsp
		request.setAttribute("javabeans", lista);
		RequestDispatcher rd = request.getRequestDispatcher("cadastro.jsp");
		rd.forward(request, response);
		/** teste de recebimento da lista **/
		/**
		 * for(int i = 0; i < lista.size(); i++) {
		 * System.out.println(lista.get(i).getId());
		 * System.out.println(lista.get(i).getNome());
		 * System.out.println(lista.get(i).getCodigo());
		 * System.out.println(lista.get(i).getCategoria());
		 * System.out.println(lista.get(i).getValor());
		 * System.out.println(lista.get(i).getQuantidade()); }
		 **/
	}

	// Novo produto
	protected void novoItem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * System.out.println(request.getParameter("nome"));
		 * System.out.println(request.getParameter("codigo"));
		 * System.out.println(request.getParameter("categoria"));
		 * System.out.println(request.getParameter("valor"));
		 * System.out.println(request.getParameter("quantidade"));
		 */

		/** Setar as variáveis javabeans **/

		javabeans.setNome(request.getParameter("nome"));
		javabeans.setCodigo(Integer.parseInt(request.getParameter("codigo")));
		javabeans.setCategoria(request.getParameter("categoria"));
		javabeans.setValor(Float.parseFloat(request.getParameter("valor")));
		javabeans.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));

		/* Invocar o método inserirContato passando o objeto contato */
		dao.inserirProduto(javabeans);
		// redirecionar para o documento cadastro.jsp
		response.sendRedirect("main");
	}

	// Editar contato
	protected void listarItem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		// setar a variavel JavaBeans
		javabeans.setId(Integer.parseInt(id));
		// Executar o método selecionarItem(DAO)
		dao.selecionarItem(javabeans);
		// setar os conteúdos do formulario com o conteudo do Javabeans
		request.setAttribute("id", javabeans.getId());
		request.setAttribute("nome", javabeans.getNome());
		request.setAttribute("codigo", javabeans.getCodigo());
		request.setAttribute("categoria", javabeans.getCategoria());
		request.setAttribute("valor", javabeans.getValor());
		request.setAttribute("quantidade", javabeans.getQuantidade());
		// Encaminhar ao documento editar.jsp
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
	}

	protected void editarItem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// teste de recebimento
		/**
		 * System.out.println(request.getParameter("id"));
		 * System.out.println(request.getParameter("nome"));
		 * System.out.println(request.getParameter("codigo"));
		 * System.out.println(request.getParameter("categoria"));
		 * System.out.println(request.getParameter("valor"));
		 * System.out.println(request.getParameter("quantidade"));
		 **/

		// setar as variaveis JavaBenas>armazenar os valores temporariamente em JB

		javabeans.setId(Integer.parseInt(request.getParameter("id")));
		javabeans.setNome(request.getParameter("nome"));
		javabeans.setCodigo(Integer.parseInt(request.getParameter("codigo")));
		javabeans.setCategoria(request.getParameter("categoria"));
		javabeans.setValor(Float.parseFloat(request.getParameter("valor")));
		javabeans.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
		// executar o método alterar contato<DAO>
		dao.alterarItem(javabeans);
		// REDIRECIONAR PARA O DOCUMENTO cadastro.jsp (ATUALIZANDO AS ALTERÇÕES)
		response.sendRedirect("main");
	}

	// REMOVER UM CONTATO
	protected void excluirItem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		// System.out.println(id); teste de recibemento Console

		/** Setar a variável id JavaBeans **/
		javabeans.setId(Integer.parseInt(id));

		// executar o método deletarItem(DAO) passando objeto item
		dao.deletarItem(javabeans);
		// REDIRECIONAR PARA O DOCUMENTO cadastro.jsp (ATUALIZANDO AS ALTERÇÕES)
		response.sendRedirect("main");

	}
}
