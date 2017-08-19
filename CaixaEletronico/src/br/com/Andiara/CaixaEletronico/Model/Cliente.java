package br.com.Andiara.CaixaEletronico.Model;

public class Cliente {

	private int codigo;
	private String nome;
	private double saldo_cliente;

	public Cliente(int codigo,String nome,double saldo_cliente) {
	setCodigo(codigo);
	setNome(nome);
	setSaldo_cliente(saldo_cliente);
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSaldo_cliente() {
		return saldo_cliente;
	}

	public void setSaldo_cliente(double saldo_cliente) {
		this.saldo_cliente = saldo_cliente;
	}

}
