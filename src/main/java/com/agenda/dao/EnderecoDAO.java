package com.agenda.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import com.agenda.model.Contato;
import com.agenda.model.Endereco;
import com.agenda.model.Pessoa;
import com.agenda.util.ConnectionFactory;
import com.mysql.jdbc.Connection;

public class EnderecoDAO {
	private Connection connection;

	public void cadastrarEndereco(Endereco endereco) {

		String SQL = "insert into endereco (logradouro, cep) values (?,?)";

		try {

			this.connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = this.connection.prepareStatement(SQL);
//			stmt.setLong(1, endereco.getId());
			stmt.setString(1, endereco.getLogradouro());
			stmt.setString(2, endereco.getCEP());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Endereco> buscarEndereco() {

		String SQL = "select * from endereco";

		try {

			this.connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = this.connection.prepareStatement(SQL);

			List<Endereco> enderecos = new ArrayList<Endereco>();

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Endereco endereco = new Endereco();
				endereco.setId(rs.getLong("id"));
				endereco.setLogradouro(rs.getString("logradouro"));
				endereco.setCEP(rs.getString("cep"));

				enderecos.add(endereco);
			}

			stmt.close();
			this.connection.close();
			return enderecos;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
}
