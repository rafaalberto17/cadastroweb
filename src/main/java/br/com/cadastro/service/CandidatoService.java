package br.com.cadastro.service;

import java.util.List;

import br.com.cadastro.dao.GenericDao;
import br.com.cadastro.model.Candidato;

public interface CandidatoService extends GenericDao<Candidato>{
	void salvar(Candidato candidato);
	List<Candidato> listarTodos();
}
