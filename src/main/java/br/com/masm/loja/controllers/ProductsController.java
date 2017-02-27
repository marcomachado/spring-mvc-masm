package br.com.masm.loja.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.masm.loja.daos.ProductDAO;
import br.com.masm.loja.models.Product;

@Controller
@Transactional
public class ProductsController {
	
	@Autowired
	private ProductDAO productDAO;
	
	/*@RequestMapping("/produtos")
	public String save(Product product) {
		productDAO.save(product);
		System.out.println("Cadastrando o produto "+product);
		return "products/ok";
	}*/
	
	@RequestMapping("/produtos")
	public String save(List<Product> products) {
		for (Product p : products) {
			productDAO.save(p);
			System.out.println("Cadastrando o produto "+p);
		}
		return "products/ok";
	}
	
	@RequestMapping("/produtos/form")
	public String form() {
		return "products/form";
	}
}
