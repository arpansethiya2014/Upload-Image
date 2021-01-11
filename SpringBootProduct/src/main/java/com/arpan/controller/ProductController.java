package com.arpan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.arpan.beans.Product;
import com.arpan.services.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService ps;

	@RequestMapping("/")
	public String viewHomePage(Model model) {
		System.out.println("In Product Home....!");
		List<Product> lstproduct = ps.getAllProducts();
		model.addAttribute("productList", lstproduct);
		return "Home";
	}

	@RequestMapping("/new")
	public String newProduct(Model m) {
		System.out.println("In New Product....!");
		Product pr = new Product();
		m.addAttribute("product", pr);
		return "NewProduct";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute("product") Product product) {
		System.out.println("In Save Product....!");
		ps.saveProduct(product);
		return "redirect:/";
	}

	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") int id) {
		ps.deleteProduct(id);
		return "redirect:/";
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
		System.out.println("In Edit Product....!");
		ModelAndView mav = new ModelAndView("EditProduct");
		Product product = ps.getProduct(id);
		System.out.println("Product Details:" + product.getId() + ":" + product.getName() + ":" + product.getBrand()
				+ ":" + product.getMadein() + ":" + product.getPrice());
		mav.addObject("product", product);

		return mav;
	}

	@RequestMapping(value = "/edit/save", method = RequestMethod.POST)
	public String editSaveProduct(@ModelAttribute("product") Product product) {
		System.out.println("In Edit Save Product....!");
		ps.saveProduct(product);
		return "redirect:/";
	}
}

