package com.co.dannykrd.fullscore.utils.objects;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum TypeOrder {

	 ASC("ASC"),
	 DESC("DESC");
	
	@Getter
	private String tipoOrden;
}
