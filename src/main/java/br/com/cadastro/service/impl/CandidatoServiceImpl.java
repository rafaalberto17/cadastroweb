package br.com.cadastro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cadastro.dao.CandidatoDao;
import br.com.cadastro.dao.impl.GenericDaoImpl;
import br.com.cadastro.model.Candidato;
import br.com.cadastro.service.CandidatoService;

@Service
public class CandidatoServiceImpl extends GenericDaoImpl<Candidato> implements CandidatoService{

	@Autowired
	CandidatoDao candidatoDao;
	
	public void salvar(Candidato candidato) {
		candidatoDao.save(candidato);
	}

	public List<Candidato> listarTodos() {
		return candidatoDao.findAll();
	}
}
