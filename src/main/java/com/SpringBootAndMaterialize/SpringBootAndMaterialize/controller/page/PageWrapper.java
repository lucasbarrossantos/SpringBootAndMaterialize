package com.SpringBootAndMaterialize.SpringBootAndMaterialize.controller.page;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;
import org.springframework.web.util.UriComponentsBuilder;

public class PageWrapper<T> {

    private Page<T> page;
    private UriComponentsBuilder uriBuilder;

    public PageWrapper(Page<T> page, HttpServletRequest httpServletRequest) {
        this.page = page;
        String httpUrl = httpServletRequest.getRequestURL().append(
                httpServletRequest.getQueryString() != null ? "?" + httpServletRequest.getQueryString() : "")
                .toString().replaceAll("\\+", "%20");
        this.uriBuilder = UriComponentsBuilder.fromHttpUrl(httpUrl);
    }

    public List<T> getConteudo(){
        return page.getContent();
    }

    public boolean isVazia(){
        return page.getContent().isEmpty();
    }

    public int getAtual(){
        return page.getNumber();
    }

    public boolean isPrimeira(){
        return page.isFirst();
    }

    public boolean isUltima(){
        return page.isLast();
    }

    public int getTotal(){
        return page.getTotalPages();
    }

    /**
     *
     * Se tiver "page" na url, então troca pelo numero da página
     * Se não tiver, adiciona
     */
    public String urlParaPagina(int pagina) {
        return uriBuilder.replaceQueryParam("page", pagina).build(true).encode().toUriString();
    }

}