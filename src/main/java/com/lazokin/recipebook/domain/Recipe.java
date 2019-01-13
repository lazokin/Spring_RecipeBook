package com.lazokin.recipebook.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Recipe {
	
	private String name;
	private String description;
	private String imageUrl;
	
}
