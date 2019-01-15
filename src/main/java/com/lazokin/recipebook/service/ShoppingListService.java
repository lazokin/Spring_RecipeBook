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
	
	public void save(Ingredient ingredient) {
		this.ingredients.stream()
			.filter(i -> i.getName().equals(ingredient.getName()))
			.findFirst()
			.ifPresentOrElse(
				i -> {
					i.setAmount(i.getAmount() + ingredient.getAmount());
				},
				() -> {
					this.ingredients.add(ingredient);
				}		
			);
	}
	
}
