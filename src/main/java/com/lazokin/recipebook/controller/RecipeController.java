package com.lazokin.recipebook.controller;

import java.util.List;
import java.util.stream.IntStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.lazokin.recipebook.domain.Recipe;

@Controller
public class RecipeController {
	
	@GetMapping("/recipes")
	public String showRecipes(Model model) {
		model.addAttribute("recipes", findAll());
		return "recipes";
	}
	
	@GetMapping("/recipes/{name}")
	public String showSelectedRecipe(@PathVariable String name, Model model) {
		List<Recipe> recipes = findAll();
		model.addAttribute("recipes", recipes);
		model.addAttribute("selectedRecipe", findByName(recipes, name));
		return "recipes";
	}
	
	private Recipe findByName(List<Recipe> recipes, String name) {
		return recipes.stream()
				.filter(recipe -> recipe.getName().equals(name))
				.findFirst()
				.orElse(null);
	}

	private List<Recipe> findAll() {
		return List.of(
			Recipe.builder()
				.name("Chipotle chicken tacos")
				.description("Take your taste buds to Mexico with these flavoursome tacos. Succulent chicken breast fillets are coated in spicy Chipotle seasoning for a weeknight dinner your family will love!")
				.imageUrl("https://img.taste.com.au/fF1NhAd6/w643-h428-cfill-q90/taste/2018/12/chipotle-chicken-tacos-144989-1.jpg")
				.build(),
			Recipe.builder()
				.name("Fish tacos")
				.description("Fish makes a healthy taco filling, and it tastes absolutely delicious.")
				.imageUrl("https://img.taste.com.au/qqy4eglS/w643-h428-cfill-q90/taste/2016/11/fish-tacos-95173-1.jpeg")
				.build()
		);
	}

}
