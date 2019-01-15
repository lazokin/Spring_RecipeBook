package com.lazokin.recipebook.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder ()
@AllArgsConstructor
public class Recipe {
	
	private String name;
	private String description;
	private String imageUrl;
	
	@Builder.Default
	private List<Ingredient> ingredients = new ArrayList<>();
	
}
