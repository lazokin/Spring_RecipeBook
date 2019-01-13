package com.lazokin.recipebook.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.lazokin.recipebook.domain.Ingredient;
import com.lazokin.recipebook.domain.Recipe;

@Controller
public class IndexController {
	
	@GetMapping("/")
	public String index(Model model) {
		List<Recipe> recipes = List.of(
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
		List<Ingredient> ingredients = List.of(
				Ingredient.builder().name("Apple").amount(5).build(),
				Ingredient.builder().name("Tomato").amount(10).build()
		);
		model.addAttribute("recipes", recipes);
		model.addAttribute("ingredients", ingredients);
		return "index";
	}

}
