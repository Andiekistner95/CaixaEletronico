package br.com.Andiara.CaixaEletronico.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO {

	private final Connection con;

	public ClienteDAO(Connection con) {
		this.con = con;
	}
	
public void imprimeExtratoCliente(int codigo) throws SQLException{
		
		String sql = "SELECT * FROM CLIENTE WHERE CODIGO = ? ";
		
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setInt(1, codigo);
		
		try (ResultSet rs = statement.getResultSet()) {
		
			
			while (rs.next()) {

				int codigoCliente = rs.getInt("codigo");
				String nome = rs.getString("nome");
				double saldo = rs.getInt("saldo_cliente");
				String extrato = "\nCliente: " + codigoCliente + "\nNome: " + nome;
				extrato += "\nSaldo: " + saldo;
				System.out.println(extrato);
				
			}
			
		}
		
	}
	

	public double buscaSaldoCliente(int codigo) throws SQLException {

		String sql = "Select saldo_cliente from cliente where codigo = ?";

		PreparedStatement statement = con.prepareStatement(sql);
		statement.setInt(1, codigo);

		double saldo = 0;
		
		statement.execute();

		try (ResultSet rs = statement.getResultSet()) {

			while (rs.next()) {

				saldo = rs.getDouble("saldo_cliente");
			}

		}
		return saldo;
	}

	public void depositoCliente(int codigo, double valor) throws SQLException {

		String sql = "update cliente set saldo_cliente = (saldo_cliente + ?) where codigo = ?";

		PreparedStatement statement = con.prepareStatement(sql);
		statement.setDouble(1, valor);
		statement.setInt(2, codigo);

		statement.executeUpdate();

	}
	
	public void saqueCliente(int codigo,double valor) throws SQLException{
		
		String sql = "update cliente set saldo_cliente = (saldo_cliente - ?)  where codigo = ?";
		
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setDouble(1, valor);
		statement.setInt(2, codigo);

		statement.executeUpdate();

	}
}
