package com.lazokin.recipebook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lazokin.recipebook.domain.Ingredient;
import com.lazokin.recipebook.service.ShoppingListService;

@Controller
@RequestMapping("/shopping-list")
public class ShoppingListController {
	
	private ShoppingListService service;

	public ShoppingListController(ShoppingListService service) {
		this.service = service;
	}

	@GetMapping
	public String shoppingList(Model model) {
		model.addAttribute("ingredients", this.service.findAll());
		model.addAttribute("ingredient", Ingredient.builder().build());
		return "shopping-list";
	}

	@PostMapping("/add")
	public String addIngredient(@ModelAttribute Ingredient ingredient) {
		this.service.save(ingredient);
		return "redirect:/shopping-list";
	}

}
