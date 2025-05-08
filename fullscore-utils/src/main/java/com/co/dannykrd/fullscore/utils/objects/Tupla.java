package com.co.dannykrd.fullscore.utils.objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Tupla<T,X> {
	
	private T left;
	
	private X right;

}
