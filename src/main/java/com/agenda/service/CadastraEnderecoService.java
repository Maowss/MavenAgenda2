package com.agenda.service;

import java.util.List;

import com.agenda.dao.EnderecoDAO;
import com.agenda.dao.PessoaDAO;
import com.agenda.model.Endereco;
import com.agenda.model.Pessoa;

public class CadastraEnderecoService {

	private EnderecoDAO dao;

	public CadastraEnderecoService() {
		this.dao = new EnderecoDAO();
	}
	
	public void Cadastrar(Endereco endereco) {
		this.dao.cadastrarEndereco(endereco);
	}
	

	public List<Endereco> buscaEnderecos() {
		return this.dao.buscarEndereco();
	}	
}
