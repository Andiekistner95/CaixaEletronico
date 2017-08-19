package br.com.Andiara.CaixaEletronico.Service;

import java.sql.SQLException;

public class TransacoesClienteCaixaService {

	public void saque(int codigo, double valor) throws SQLException{
		CaixaEletronicoService caixaService = new CaixaEletronicoService();
		ClienteService clienteService = new ClienteService();
		
		caixaService.saqueCaixa(codigo, valor);
		clienteService.saqueCliente(codigo, valor);
	}
	
	public void deposito(int codigo, double valor) throws SQLException{
		CaixaEletronicoService caixaService = new CaixaEletronicoService();
		ClienteService clienteService = new ClienteService();
		
		caixaService.depositoCaixa(codigo, valor);
		clienteService.depositoCliente(codigo, valor);
	}
}
