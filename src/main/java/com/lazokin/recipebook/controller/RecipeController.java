package com.lazokin.recipebook.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lazokin.recipebook.domain.Recipe;
import com.lazokin.recipebook.service.RecipeService;

@Controller
@RequestMapping("/recipes")
public class RecipeController {
	
	private RecipeService service;
	
	public RecipeController(RecipeService service) {
		this.service = service;
	}

	@GetMapping
	public String showRecipes(Model model) {
		model.addAttribute("recipes", this.service.findAll());
		return "recipes";
	}
	
	@GetMapping("/{id}")
	public String showSelectedRecipe(@PathVariable int id, Model model) {
		List<Recipe> recipes = this.service.findAll();
		model.addAttribute("recipes", recipes);
		model.addAttribute("selectedRecipe", this.service.findById(id));
		return "recipes";
	}
	
}
