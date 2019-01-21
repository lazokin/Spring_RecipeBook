package com.lazokin.recipebook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
		model.addAttribute("selectedIndex", -1);
		model.addAttribute("selectedMode", false);
		return "shopping-list";
	}
	
	@GetMapping("/{index}")
	public String shoppingListSelected(@PathVariable int index, Model model) {
		model.addAttribute("ingredients", this.service.findAll());
		model.addAttribute("ingredient", this.service.findByIndex(index));
		model.addAttribute("selectedIndex", index);
		model.addAttribute("selectedMode", true);
		return "shopping-list";
	}
	
	@DeleteMapping("/{index}/delete")
	public String shoppingListDeleted(@PathVariable int index) {
		this.service.delete(index);
		return "redirect:/shopping-list";
	}

	@PostMapping("/submit")
	public String addIngredient(
			@ModelAttribute Ingredient ingredient,
			@ModelAttribute("selectedMode") boolean selectedMode,
			@ModelAttribute("selectedIndex") int selectedIndex) {
		
		if (selectedMode) {
			this.service.update(selectedIndex, ingredient);
		} else {
			this.service.save(ingredient);
		}
		return "redirect:/shopping-list";
	}

}
