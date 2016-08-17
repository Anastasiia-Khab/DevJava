package ua.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.entity.Ingredient;
import ua.service.IngredientService;
import ua.service.implementation.validator.IngredientValidator;

@Controller
public class IngredientController {

	@Autowired
	private IngredientService ingredientService;
	
	@ModelAttribute("ingredient")
	public Ingredient getIngredient(){
		return new Ingredient();
	}
	
	@InitBinder("ingredient")
	protected void initBinder(WebDataBinder binder){
		binder.setValidator(new IngredientValidator(ingredientService));
	}
	
	@RequestMapping("/admin/ingredient")
	public String show(Model model){
		model.addAttribute("ingredients", ingredientService.findAll());
		return "adminIngredient";
	}
	
	@RequestMapping(value="/admin/ingredient", method=RequestMethod.POST)
	public String save(@ModelAttribute("ingredient") @Valid Ingredient ingredient, BindingResult br, Model model){
		if(br.hasErrors()){
			model.addAttribute("ingredients", ingredientService.findAll());
			return "adminIngredient";
		}
		ingredientService.save(ingredient);
		return "redirect:/admin/ingredient";
	}
	
	@RequestMapping("/admin/ingredient/delete/{id}")
	public String delete(@PathVariable int id){
		ingredientService.delete(id);
		return "redirect:/admin/ingredient";
	}
	
	@RequestMapping("/admin/ingredient/update/{id}")
	public String update(@PathVariable int id, Model model){
		model.addAttribute("ingredient", ingredientService.findOne(id));
		model.addAttribute("ingredients", ingredientService.findAll());
		return "adminIngredient";
	}
}