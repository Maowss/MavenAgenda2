package com.agenda.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.agenda.model.Contato;
import com.agenda.model.Endereco;
import com.agenda.model.Pessoa;
import com.agenda.service.CadastraContatoService;
import com.agenda.service.CadastraEnderecoService;
import com.agenda.service.CadastraUsuarioService;

@WebServlet("/busca-contatos")
public class ListaUsuariosServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private CadastraUsuarioService service;
	private CadastraEnderecoService endService;
	private CadastraContatoService contService;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			this.service = new CadastraUsuarioService();
			this.contService = new CadastraContatoService();
			this.endService = new CadastraEnderecoService();
			
//			List<Pessoa> pessoas = this.service.buscaPessoas();
			List<Contato> contatos = this.contService.buscaContatos();
//			List<Endereco> enderecos = this.endService.buscaEnderecos();

//			request.setAttribute("contatos", contatos);
			request.setAttribute("pessoas", contatos);
//			request.setAttribute("enderecos", enderecos);
			request.getRequestDispatcher("lista-contatos.jsp").forward(request, response);
		} catch (Exception e) {
			throw new ServletException("A lógica de negócios causou uma exceção", e);
		}
	}

}
