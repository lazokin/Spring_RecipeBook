package com.lazokin.recipebook.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lazokin.recipebook.domain.Ingredient;

@Controller
@RequestMapping("/shopping-list")
public class ShoppingListController {
	
	private List<Ingredient> ingredients = new ArrayList<>();

	public ShoppingListController() {
		init();
	}

	@GetMapping
	public String shoppingList(Model model) {
		model.addAttribute("ingredients", findAll());
		model.addAttribute("ingredient", Ingredient.builder().build());
		return "shopping-list";
	}

	@PostMapping("/add")
	public String addIngredient(@ModelAttribute Ingredient ingredient) {
		save(ingredient);
		return "redirect:/shopping-list";
	}
	
	private void init() {
		this.ingredients.add(Ingredient.builder().name("Apple").amount(5).build());
		this.ingredients.add(Ingredient.builder().name("Tomato").amount(10).build());
	}
	
	private List<Ingredient> findAll() {
		return List.copyOf(this.ingredients);
	}
	
	private Ingredient save(Ingredient ingredient) {
		this.ingredients.add(ingredient);
		return ingredient;
	}

}
