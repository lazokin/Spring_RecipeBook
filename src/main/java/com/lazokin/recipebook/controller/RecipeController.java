package com.lazokin.recipebook.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lazokin.recipebook.domain.Recipe;

@Controller
@RequestMapping("/recipes")
public class RecipeController {
	
	private List<Recipe> recipes = new ArrayList<>();

	public RecipeController() {
		init();
	}
	
	@GetMapping
	public String showRecipes(Model model) {
		model.addAttribute("recipes", findAll());
		return "recipes";
	}
	
	@GetMapping("/{name}")
	public String showSelectedRecipe(@PathVariable String name, Model model) {
		List<Recipe> recipes = findAll();
		model.addAttribute("recipes", recipes);
		model.addAttribute("selectedRecipe", findByName(name));
		return "recipes";
	}
	
	private void init() {
		this.recipes.add(Recipe.builder()
			.name("Chipotle chicken tacos")
			.description("Take your taste buds to Mexico with these flavoursome tacos. Succulent chicken breast fillets are coated in spicy Chipotle seasoning for a weeknight dinner your family will love!")
			.imageUrl("https://img.taste.com.au/fF1NhAd6/w643-h428-cfill-q90/taste/2018/12/chipotle-chicken-tacos-144989-1.jpg")
			.build()
		);
		this.recipes.add(Recipe.builder()
			.name("Fish tacos")
			.description("Fish makes a healthy taco filling, and it tastes absolutely delicious.")
			.imageUrl("https://img.taste.com.au/qqy4eglS/w643-h428-cfill-q90/taste/2016/11/fish-tacos-95173-1.jpeg")
			.build()
		);
	}
	
	private List<Recipe> findAll() {
		return List.copyOf(this.recipes);
	}
	
	private Recipe findByName(String name) {
		return this.recipes.stream()
				.filter(recipe -> recipe.getName().equals(name))
				.findFirst()
				.orElse(null);
	}

}
