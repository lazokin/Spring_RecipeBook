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
		model.addAttribute("selectedIndex", -1);
		return "recipes-none";
	}
	
	@GetMapping("/{id}")
	public String showRecipe(@PathVariable int id, Model model) {
		List<Recipe> recipes = this.service.findAll();
		model.addAttribute("recipes", recipes);
		model.addAttribute("recipe", this.service.findById(id));
		model.addAttribute("selectedIndex", id);
		return "recipes-detail";
	}
	
	@GetMapping("/{id}/edit")
	public String editRecipe(@PathVariable int id, Model model) {
		List<Recipe> recipes = this.service.findAll();
		model.addAttribute("recipes", recipes);
		model.addAttribute("recipe", this.service.findById(id));
		model.addAttribute("selectedIndex", id);
		return "recipes-edit";
	}
	
	@GetMapping("/new")
	public String newRecipe(Model model) {
		model.addAttribute("recipes", this.service.findAll());
		model.addAttribute("selectedIndex", -1);
		return "recipes-new";
	}
	
}
