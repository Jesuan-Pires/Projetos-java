package com.atos.projeto.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.atos.projeto.models.Entrega;
import com.atos.projeto.models.Entregador;
import com.atos.projeto.repository.EntregaRepository;
import com.atos.projeto.repository.EntregadorRepository;

@Controller
public class EntregadorController {

	@Autowired
	private EntregadorRepository er;
	
	@Autowired
	private EntregaRepository eer;

	@RequestMapping(value = "/cadastrarEntregador", method = RequestMethod.GET)
	public String form() {

		return "entregadores/formEntregador";
	}

	@RequestMapping(value ="/cadastrarEntregador", method=RequestMethod.POST)
	public String form(@Valid Entregador entregador, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()){
		 attributes.addFlashAttribute("mensagem", "verifique os campos!");
		 return "redirect:/cadastrarEntregador";
	   }
		er.save(entregador);
		attributes.addFlashAttribute("mensagem", "Entregador cadastrado com sucesso!");
		return "redirect:/cadastrarEntregador";
	}
	
	@RequestMapping("/lista")
	public ModelAndView listaEntregadores() {
		ModelAndView mv = new ModelAndView("index");
		Iterable<Entregador> entregadores = er.findAll();
		mv.addObject("entregadores", entregadores);
		return mv;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET )
	public ModelAndView detalhesEntregador(@PathVariable("id") long id){
		Entregador entregador = er.findById(id);
		ModelAndView mv = new ModelAndView("entregadores/detalhesEntregador");
		mv.addObject("entregador", entregador);

		Iterable<Entrega> entregas = eer.findByEntregador(entregador);
		mv.addObject("entregas", entregas);
		return mv;
	}
	
	@RequestMapping("/deletar")
	public String deletarEntregador(long id) {
		Entregador entregador = er.findById(id);
		er.delete(entregador);
		return "redirect:/lista"; 
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.POST)
	public String detalhesEntregadorPost(@PathVariable("id") long id, @Valid Entrega entrega, BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "IMPORTANTE campos obrigatórios \"Bairro, Valor e Data\"");
			return "redirect:/{id}";
		}
		Entregador entregador = er.findById(id); 
		entrega.setEntregador(entregador);
		eer.save(entrega);
		attributes.addFlashAttribute("mensagem", "Entrega adicionada com sucesso!");
		return "redirect:/{id}";
	}
	
	@RequestMapping("/deletarEntrega")
	public String deletarEntrega(int codigo) {
		Entrega entrega = eer.findByCodigo(codigo);
		eer.delete(entrega);
		
		Entregador entregador = entrega.getEntregador();
		long codigoLong = entregador.getId();
		return "redirect:/"+codigoLong;
	}
	
	// Formulario edição entregador
    @RequestMapping(value = "/editarEntregador", method = RequestMethod.GET)
    public ModelAndView editarEntregador(long id) {
        Entregador entregador = er.findById(id);
        ModelAndView mv = new ModelAndView("entregadores/updateEntregador");
        mv.addObject("entregador", entregador);
        return mv;
    }

    // Updating entregador
    @RequestMapping(value = "/editarEntregador", method = RequestMethod.POST)
    public String updateEntregador(@Valid Entregador entregador, BindingResult result, RedirectAttributes attributes) {
        er.save(entregador);
        attributes.addFlashAttribute("success", "Evento alterado com sucesso!");
        return "redirec:/";
    }
	
	
}
