package br.com.cadastro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.cadastro.model.Candidato;
import br.com.cadastro.service.CandidatoService;

@Controller
public class CadastroController {

	private static final String FORM_INDEX = "/indexCadastro";
	private static final String FORM_CADASTRO = "/formCadastro";
	
	private static final String LIST = "list";
	private static final String MODEL = "model";
	
	@Autowired
	private CandidatoService candidatoService;
	
	@RequestMapping("/index.do")
	public ModelAndView index(){
		return new ModelAndView(FORM_INDEX).addObject(LIST, candidatoService.listarTodos());
	}
	
	@RequestMapping("/novo.do")
	public ModelAndView novo(){
		return new ModelAndView(FORM_CADASTRO).addObject(MODEL, new Candidato());
	}
	
	@RequestMapping("/salvar.do")
	public ModelAndView salvar(Candidato candidato){
		candidatoService.salvar(candidato);
		return index();
	}
	
	@RequestMapping("/editar.do")
	public ModelAndView editar(@RequestParam("id") Long id){
		Candidato candidato = candidatoService.findById(id);
		return new ModelAndView(FORM_CADASTRO).addObject(MODEL, candidato);
	}
	
	@RequestMapping("/excluir.do")
	public ModelAndView excluir(@RequestParam("id") Long id){
		Candidato candidato = candidatoService.findById(id);
		candidatoService.delete(candidato);
		return index();
	}
}
