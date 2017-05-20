package com.SpringBootAndMaterialize.SpringBootAndMaterialize.controller;

import com.SpringBootAndMaterialize.SpringBootAndMaterialize.controller.page.PageWrapper;
import com.SpringBootAndMaterialize.SpringBootAndMaterialize.model.Situacao;
import com.SpringBootAndMaterialize.SpringBootAndMaterialize.model.Tipo;
import com.SpringBootAndMaterialize.SpringBootAndMaterialize.model.Titulo;
import com.SpringBootAndMaterialize.SpringBootAndMaterialize.repository.Entidades;
import com.SpringBootAndMaterialize.SpringBootAndMaterialize.service.TitulosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by lucasbarros on 16/05/17.
 */

@Controller
@RequestMapping("/titulos")
public class TitulosController {

    private static final String VIEWER = "titulo/CadastrarTitulo";

    @Autowired
    private Entidades entidades;

    @Autowired
    private TitulosService titulosService;

    @RequestMapping("/novo")
    public ModelAndView novo(Titulo titulo) {
        ModelAndView mv = new ModelAndView(VIEWER);
        mv.addObject("entidades", entidades.findAll());
        mv.addObject("todosTiposTitulo", Tipo.values());
        mv.addObject("todasAsSituacoes", Situacao.values());
        return mv;
    }

    @RequestMapping(value = "/novo", method = RequestMethod.POST)
    public ModelAndView salvar(@Valid Titulo titulo, BindingResult result, RedirectAttributes attributes) {

        if (result.hasErrors()) {
            return novo(titulo);
        }

        titulosService.salvar(titulo);
        attributes.addFlashAttribute("mensagem", "Título salva com sucesso.");
        return new ModelAndView("redirect:/titulos/novo");
    }

    @RequestMapping
    public ModelAndView pesquisar(Titulo titulo, @PageableDefault(size = 5) Pageable pageable,
                                  HttpServletRequest httpServletRequest) {

        ModelAndView mv = new ModelAndView("titulo/PesquisarTitulo");
        PageWrapper<Titulo> paginaWrapper = new PageWrapper<>(titulosService.filtrar(titulo, pageable), httpServletRequest);
        mv.addObject("pagina", paginaWrapper);
        return mv;
    }

    @RequestMapping("{codigo}")
    public ModelAndView adicao(@PathVariable("codigo") Titulo titulo) {
        ModelAndView mv = new ModelAndView(VIEWER);
        mv.addObject("entidades", entidades.findAll());
        mv.addObject("todosTiposTitulo", Tipo.values());
        mv.addObject("todasAsSituacoes", Situacao.values());
        mv.addObject(titulo);
        return mv;
    }

    @RequestMapping(value = "{codigo}", method = RequestMethod.DELETE)
    public String excluir(@PathVariable("codigo") Long codigo, RedirectAttributes attributes) {
        titulosService.excluir(codigo);
        attributes.addFlashAttribute("mensagem", "Título excluída com sucesso.");
        return "redirect:/titulos";
    }

}
