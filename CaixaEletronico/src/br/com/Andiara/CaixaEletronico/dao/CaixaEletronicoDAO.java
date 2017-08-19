package br.com.Andiara.CaixaEletronico.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CaixaEletronicoDAO {

	private final Connection con;

	public CaixaEletronicoDAO(Connection con) {
		this.con = con;
	}

	public double buscaSaldoCaixa(int codigo) throws SQLException {

		String sql = "Select saldo_caixa from CAIXA_ELETRONICO where codigo = ?";

		PreparedStatement statement = con.prepareStatement(sql);
		statement.setInt(1, codigo);
		statement.execute();

		double saldo = 0;

		try (ResultSet rs = statement.getResultSet()) {

			while (rs.next()) {

				saldo = rs.getDouble("saldo_caixa");
			}

		}
		return saldo;
	}

	public void depositoCaixa(int codigo, double valor) throws SQLException {

		String sql = "update CAIXA_ELETRONICO set saldo_caixa = (saldo_caixa + ?) where codigo = ?";

		PreparedStatement statement = con.prepareStatement(sql);
		statement.setDouble(1, valor);
		statement.setInt(2, codigo);

		statement.executeUpdate();

	}

	public void saqueCaixa(int codigo, double valor) throws SQLException {

		String sql = "update CAIXA_ELETRONICO set saldo_caixa = (saldo_caixa - ?)  where codigo = ?";

		PreparedStatement statement = con.prepareStatement(sql);
		statement.setDouble(1, valor);
		statement.setInt(2, codigo);

		statement.executeUpdate();

	}

}
