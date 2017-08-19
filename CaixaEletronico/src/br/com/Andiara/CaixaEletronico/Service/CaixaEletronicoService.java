package br.com.Andiara.CaixaEletronico.Service;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.Andiara.CaixaEletronico.Model.CaixaEletronico;
import br.com.Andiara.CaixaEletronico.dao.CaixaEletronicoDAO;
import br.com.Andiara.CaixaEletronico.jdbc.oracle.ConnectionPoolOracle;


public class CaixaEletronicoService {

	
	public void buscaSaldoCliente(CaixaEletronico caixa) throws SQLException {
		try (Connection con = new ConnectionPoolOracle().getConnection()) {
			System.out.println(new CaixaEletronicoDAO(con).buscaSaldoCaixa(caixa.getCodigo()));
		}
	}

	public void depositoCaixa(int codigo, double valor) throws SQLException {
		try (Connection con = new ConnectionPoolOracle().getConnection()) {
			new CaixaEletronicoDAO(con).depositoCaixa(codigo, valor);
		}

	}

	public void saqueCaixa(int codigo, double valor) throws SQLException {
		try (Connection con = new ConnectionPoolOracle().getConnection()) {

			CaixaEletronicoDAO caixaDAO = new CaixaEletronicoDAO(con);

			double saldo = caixaDAO.buscaSaldoCaixa(codigo);

			if (saldo < valor) {
				System.out.println("valor indisponivel no caixa");
			} else {

				caixaDAO.saqueCaixa(codigo, valor);
			}
		}

	}
}
