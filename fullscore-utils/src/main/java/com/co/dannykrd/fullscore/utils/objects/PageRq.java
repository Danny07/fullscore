package com.co.dannykrd.fullscore.utils.objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PageRq {

	private int number;
	
	private int size;
	
	private String columnOrder;
	
	private TypeOrder typeOrder;
}
