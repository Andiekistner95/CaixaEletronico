package br.com.Andiara.CaixaEletronico.Teste;

import java.sql.SQLException;

import br.com.Andiara.CaixaEletronico.Service.TransacoesClienteCaixaService;

public class TransacoesClienteCaixaTeste {

	public static void main(String[] args) throws SQLException {

		TransacoesClienteCaixaService tccs = new TransacoesClienteCaixaService();

		tccs.deposito(1, 900);
		tccs.saque(2, 20000);

	}
}