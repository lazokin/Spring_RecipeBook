package com.lazokin.recipebook.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.lazokin.recipebook.domain.Ingredient;

@Controller
public class ShoppingListController {
	
	@GetMapping("shopping-list")
	public String shoppingList(Model model) {
		List<Ingredient> ingredients = List.of(
				Ingredient.builder().name("Apple").amount(5).build(),
				Ingredient.builder().name("Tomato").amount(10).build()
		);
		model.addAttribute("ingredients", ingredients);
		return "shopping-list";
	}

}
