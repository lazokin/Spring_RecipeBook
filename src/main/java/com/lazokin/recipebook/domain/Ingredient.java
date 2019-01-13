package com.lazokin.recipebook.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Ingredient {
	
	private String name;
	private int amount;
	
}
