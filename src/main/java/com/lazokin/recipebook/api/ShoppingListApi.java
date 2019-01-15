package com.lazokin.recipebook.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lazokin.recipebook.domain.Ingredient;
import com.lazokin.recipebook.service.ShoppingListService;

@RestController
@RequestMapping("/shopping-list")
public class ShoppingListApi {
	
	private ShoppingListService service;

	public ShoppingListApi(ShoppingListService service) {
		this.service = service;
	}

	@PostMapping("/ingredients")
	public void postIngredients(@RequestBody Ingredient ingredient) {
		this.service.save(ingredient);
	}

}
