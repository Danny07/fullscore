package com.co.dannykrd.fullscore.utils.objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestFind<T> {

	private T body;

	private PageRq pageRequest;
}
