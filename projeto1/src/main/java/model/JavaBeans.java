package model;

public class JavaBeans {
	private int id;
	private String nome;
	private int codigo;
	private String categoria;
	private float valor;
	private int quantidade;

	public JavaBeans() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JavaBeans(int id, String nome, int codigo, String categoria, float valor, int quantidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.codigo = codigo;
		this.categoria = categoria;
		this.valor = valor;
		this.quantidade = quantidade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;

	}

}
