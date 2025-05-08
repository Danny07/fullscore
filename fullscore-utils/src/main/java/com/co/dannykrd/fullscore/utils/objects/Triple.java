package com.co.dannykrd.fullscore.utils.objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Triple<X,Y,Z> {
	
	private X Left;
	
	private Y center;
	
	private Z right;

}
