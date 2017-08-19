package br.com.Andiara.CaixaEletronico.Model;

public class CaixaEletronico {

	private int codigo;
	private double saldo_caixa;
	
	public CaixaEletronico(int codigo,double saldo_caixa) {
		setCodigo(codigo);
		setSaldo_caixa(saldo_caixa);
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getSaldo_caixa() {
		return saldo_caixa;
	}

	public void setSaldo_caixa(double saldo_caixa) {
		this.saldo_caixa = saldo_caixa;
	}

}
