package com.SpringBootAndMaterialize.SpringBootAndMaterialize.controller;

import com.SpringBootAndMaterialize.SpringBootAndMaterialize.model.Entidade;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * Created by lucasbarros on 05/05/17.
 */

@Controller
@RequestMapping("/entidades")
public class ClientesController {

    private static final String VIEWER = "entidade/CadastrarEntidade";

    @RequestMapping("/novo")
    public ModelAndView novo(Entidade entidade) {
        return new ModelAndView(VIEWER);
    }

    @RequestMapping(value = "/novo", method = RequestMethod.POST)
    public ModelAndView salvar(@Valid Entidade entidade, BindingResult result, RedirectAttributes attributes) {

        if (result.hasErrors()) {
            return novo(entidade);
        }

        attributes.addFlashAttribute("mensagem", "Entidade salva com sucesso.");
        return new ModelAndView("redirect:/entidades/novo");
    }

}
