package com.SpringBootAndMaterialize.SpringBootAndMaterialize.converter;

import com.SpringBootAndMaterialize.SpringBootAndMaterialize.model.Entidade;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;


public class EntidadeConverter implements Converter<String, Entidade>{

	@Override
	public Entidade convert(String codigo) {
		if(!StringUtils.isEmpty(codigo)){
			Entidade entidade = new Entidade();
			entidade.setCodigo(Long.valueOf(codigo));
			return entidade;
		}
		return null;
	}
	
	
}
