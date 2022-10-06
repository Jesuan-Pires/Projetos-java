package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet; //<---JDBC armazena retorno de banco de dados temporariamente em um objeto
import java.util.ArrayList;//<---vetores dinâmicos

public class DAO {
	/** Módulo de conexão **/
	// Parâmetros de conexão
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/projeto1?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "admin";

	// Método de conexão
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/** CRUD CREATE **/
	public void inserirProduto(JavaBeans javabeans) {// <---Passa para a classe controller/Servlet
		String create = "insert into produto(nome, codigo, categoria, valor, quantidade) values (?,?,?,?,?)";
		try {
			// ABRIR CONEXÂO
			Connection con = conectar();
			// PREPARAR A QUERY PARA A EXECUÇÃO NO BANCO DE DADOS
			PreparedStatement pst = con.prepareStatement(create);

			// SUBSTITUIR PARÂMETROS(?) PELO CONTEÚDO DAS VARIAVEIS JavaBeans
			pst.setString(1, javabeans.getNome());
			pst.setInt(2, javabeans.getCodigo());
			pst.setString(3, javabeans.getCategoria());
			pst.setFloat(4, javabeans.getValor());
			pst.setInt(5, javabeans.getQuantidade());
			// EXECUTAR A QUERY
			pst.executeUpdate();// <----comando que insere efetivamente os dados no banco
			// Encerrar a conexão com o banco
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/** CRUD READ **/
	public ArrayList<JavaBeans> listarItens() {// <---------------VETOR DINÂMICO
		// Criando um objeto para acessar a classe javaBeans
		ArrayList<JavaBeans> itens = new ArrayList<>();
		String read = "select * from produto order by nome"; // <-----ordem alfabética "nome" MYSQL
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();// --->Executa a query o camando "select order by nome... "rs" armazena
												// temp"

			// o laço sera executado enquanto houver contatos
			while (rs.next()) {
				// variaveis de apoio que recebem os dados do banco
				String id = rs.getString(1);
				String nome = rs.getString(2);
				String codigo = rs.getString(3);
				String categoria = rs.getString(4);
				String valor = rs.getString(5);
				String quantidade = rs.getString(6);
				// populando o ArrayList
				itens.add(new JavaBeans(Integer.parseInt(id), nome, Integer.parseInt(codigo), categoria,
						Float.parseFloat(valor), Integer.parseInt(quantidade)));
			}
			con.close();
			return itens;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/** CREUD UPDATE **/
	// selecionar o item
	public void selecionarItem(JavaBeans javabeans) {
		String read2 = "select * from produto where id = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setInt(1, javabeans.getId());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				javabeans.setId(rs.getInt(1));
				javabeans.setNome(rs.getString(2));
				javabeans.setCodigo(rs.getInt(3));
				javabeans.setCategoria(rs.getString(4));
				javabeans.setValor(rs.getFloat(5));
				javabeans.setQuantidade(rs.getInt(6));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void alterarItem(JavaBeans javabeans) {
		String create = "update produto set nome=?,codigo=?,categoria=?,valor=?,quantidade=? where id = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, javabeans.getNome());
			pst.setInt(2, javabeans.getCodigo());
			pst.setString(3, javabeans.getCategoria());
			pst.setFloat(4, javabeans.getValor());
			pst.setInt(5, javabeans.getQuantidade());
			pst.setInt(6, javabeans.getId());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	/**CRUD DELETE**/
	public void deletarItem(JavaBeans javabeans) {
		String delete = "delete from produto where id=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setInt(1, javabeans.getId());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
