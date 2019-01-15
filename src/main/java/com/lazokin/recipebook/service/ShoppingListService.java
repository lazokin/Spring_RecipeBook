package com.lazokin.recipebook.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lazokin.recipebook.domain.Ingredient;

@Service
public class ShoppingListService {
	
	private List<Ingredient> ingredients = new ArrayList<>();

	public ShoppingListService() {
		init();
	}
	
	private void init() {
		this.ingredients.add(Ingredient.builder()
			.name("Apple")
			.amount(5)
			.build()
		);
		this.ingredients.add(Ingredient.builder()
			.name("Tomato")
			.amount(10)
			.build()
		);
	}
	
	public List<Ingredient> findAll() {
		return List.copyOf(this.ingredients);
	}
	
	public Ingredient save(Ingredient ingredient) {
		this.ingredients.add(ingredient);
		return ingredient;
	}
}
