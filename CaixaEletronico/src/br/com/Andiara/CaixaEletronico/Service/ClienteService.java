package br.com.Andiara.CaixaEletronico.Service;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.Andiara.CaixaEletronico.Model.Cliente;
import br.com.Andiara.CaixaEletronico.dao.ClienteDAO;
import br.com.Andiara.CaixaEletronico.jdbc.oracle.ConnectionPoolOracle;

public class ClienteService {

	public void imprimeExtratoCliente(Cliente cliente) throws SQLException {
		try (Connection con = new ConnectionPoolOracle().getConnection()) {
			new ClienteDAO(con).imprimeExtratoCliente(cliente.getCodigo());

		}
	}

	public void buscaSaldoCliente(Cliente cliente) throws SQLException {
		try (Connection con = new ConnectionPoolOracle().getConnection()) {
			System.out.println(new ClienteDAO(con).buscaSaldoCliente(cliente.getCodigo()));
		}
	}

	public void depositoCliente(int codigo, double valor) throws SQLException {
		try (Connection con = new ConnectionPoolOracle().getConnection()) {
			new ClienteDAO(con).depositoCliente(codigo, valor);
		}

	}

	public void saqueCliente(int codigo, double valor) throws SQLException {
		try (Connection con = new ConnectionPoolOracle().getConnection()) {

			ClienteDAO clienteDAO = new ClienteDAO(con);

			double saldo = clienteDAO.buscaSaldoCliente(codigo);

			if (saldo < valor) {
				System.out.println("saldo insuficiente");
			} else {

				clienteDAO.saqueCliente(codigo, valor);
			}
		}

	}
}
