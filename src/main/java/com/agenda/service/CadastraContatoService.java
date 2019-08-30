package com.agenda.service;

import java.util.List;

import com.agenda.dao.ContatoDAO;
import com.agenda.dao.EnderecoDAO;
import com.agenda.model.Contato;
import com.agenda.model.Endereco;
import com.agenda.model.Pessoa;

public class CadastraContatoService {
	private ContatoDAO dao;

	public CadastraContatoService() {
		this.dao = new ContatoDAO();
	}
	
	public void Cadastrar(Contato contato) {
		this.dao.cadastrarContato(contato);
	}

	public List<Contato> buscaContatos() {
		return this.dao.buscarContato();
	}	
}
