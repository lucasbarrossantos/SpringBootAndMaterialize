package com.SpringBootAndMaterialize.SpringBootAndMaterialize.controller;

import com.SpringBootAndMaterialize.SpringBootAndMaterialize.controller.page.PageWrapper;
import com.SpringBootAndMaterialize.SpringBootAndMaterialize.dto.EntidadeDTO;
import com.SpringBootAndMaterialize.SpringBootAndMaterialize.exception.NegocioException;
import com.SpringBootAndMaterialize.SpringBootAndMaterialize.model.Entidade;
import com.SpringBootAndMaterialize.SpringBootAndMaterialize.repository.Entidades;
import com.SpringBootAndMaterialize.SpringBootAndMaterialize.service.EntidadesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by lucasbarros on 05/05/17.
 */

@Controller
@RequestMapping("/entidades")
public class ClientesController {

    private static final String VIEWER = "entidade/CadastrarEntidade";

    @Autowired
    private EntidadesService entidadesService;

    @Autowired
    private Entidades entidades;

    @RequestMapping("/novo")
    public ModelAndView novo(Entidade entidade) {
        return new ModelAndView(VIEWER);
    }

    @RequestMapping(value = "/novo", method = RequestMethod.POST)
    public ModelAndView salvar(@Valid Entidade entidade, BindingResult result, RedirectAttributes attributes) {

        if (result.hasErrors()) {
            return novo(entidade);
        }

        entidadesService.salvar(entidade);
        attributes.addFlashAttribute("mensagem", "Entidade salva com sucesso.");
        return new ModelAndView("redirect:/entidades/novo");
    }

    @RequestMapping
    public ModelAndView pesquisar(Entidade entidade, @PageableDefault(size = 2) Pageable pageable,
                                  HttpServletRequest httpServletRequest){

        ModelAndView mv = new ModelAndView("entidade/PesquisarEntidade");
        PageWrapper<Entidade> paginaWrapper = new PageWrapper<>(entidadesService.filtrar(entidade, pageable), httpServletRequest);
        mv.addObject("pagina", paginaWrapper);
        return mv;
    }

    @RequestMapping("{codigo}")
    public ModelAndView adicao(@PathVariable("codigo") Entidade entidade){
        ModelAndView mv = new ModelAndView(VIEWER);
        mv.addObject(entidade);
        return mv;
    }

    @RequestMapping(value = "{codigo}", method = RequestMethod.DELETE)
    public String excluir(@PathVariable("codigo") Long codigo, RedirectAttributes attributes){
        try {
            entidadesService.excluir(codigo);
        }catch (NegocioException e){
            attributes.addFlashAttribute("mensagemErro", e.getMessage());
            return "redirect:/entidades";
        }

        attributes.addFlashAttribute("mensagem", "Entidade excluída com sucesso.");
        return "redirect:/entidades";
    }

    @GetMapping(value = "/filtro")
    public @ResponseBody List<EntidadeDTO> pesquisar(String nome){
        return entidades.clientesFiltrados(nome.toLowerCase());
    }
}
