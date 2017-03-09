package br.com.masm.loja.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.masm.loja.daos.ProductDAO;
import br.com.masm.loja.models.BookType;
import br.com.masm.loja.models.Product;

@Controller
@Transactional
@RequestMapping("/produtos")
public class ProductsController {
	
	@Autowired
	private ProductDAO productDAO;
	
	/*@InitBinder
	private void initBind(WebDataBinder binder) {
		binder.setValidator(new ProductValidator());
	}*/
	
	@RequestMapping("/form")
	public ModelAndView form(Product produtc) {
		ModelAndView modelAndView = new ModelAndView("products/form");
		modelAndView.addObject("bookTypes", BookType.values());
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.POST,name="saveProduct")
	public ModelAndView save(@Valid Product product, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors())
			return form(product);
		productDAO.save(product);
		redirectAttributes.addFlashAttribute("sucesso", "Produto cadastrado com sucesso");
		return new ModelAndView("redirect:produtos");
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("products/list");
		modelAndView.addObject("products", productDAO.list());
		return modelAndView;
	}
}
