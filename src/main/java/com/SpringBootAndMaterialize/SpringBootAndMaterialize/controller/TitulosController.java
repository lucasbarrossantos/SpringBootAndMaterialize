package com.SpringBootAndMaterialize.SpringBootAndMaterialize.controller;

import com.SpringBootAndMaterialize.SpringBootAndMaterialize.model.Titulo;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * Created by lucasbarros on 16/05/17.
 */

@Controller
@RequestMapping("/titulos")
public class TitulosController {

    private static final String VIEWER = "titulo/CadastrarTitulo";

    @RequestMapping("/novo")
    public ModelAndView novo(Titulo titulo) {
        return new ModelAndView(VIEWER);
    }

    @RequestMapping(value = "/novo", method = RequestMethod.POST)
    public ModelAndView salvar(@Valid Titulo titulo, BindingResult result, RedirectAttributes attributes) {

        if (result.hasErrors()) {
            return novo(titulo);
        }

        attributes.addFlashAttribute("mensagem", "Título salva com sucesso.");
        return new ModelAndView("redirect:/entidades/novo");
    }

}
