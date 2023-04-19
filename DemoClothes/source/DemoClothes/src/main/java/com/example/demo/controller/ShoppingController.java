package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Clothes;
import com.example.demo.repository.ClothesRepository;

@Controller
@RequestMapping("/users")
public class ShoppingController {
	
	@Autowired
	private ClothesRepository clothesRepository;
	@Autowired
	HttpSession session;
	
	public Page<Clothes> listAll(int pageNum) {
	    int pageSize = 12;
	     
	    Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
	     
	    return clothesRepository.findAll(pageable);
	}
	
	@RequestMapping("/shopping/{pageNum}")
	public String viewPage(Model model,
	        @PathVariable(name = "pageNum") int pageNum) {
	     
	    Page<Clothes> page = listAll(pageNum);
	     
	    List<Clothes> listProducts = page.getContent();
	    
	    System.out.print(listProducts);
	     
	    model.addAttribute("currentPage", pageNum);
	    model.addAttribute("totalPages", page.getTotalPages());
	    model.addAttribute("totalItems", page.getTotalElements());
	    model.addAttribute("clothes", listProducts);
	     
	    return "users/shopping";
	}
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
	    return viewPage(model, 1);
	}
	
	@RequestMapping("/homepage")
	public String homepage() {
		return "users/home";
	}
	
	@RequestMapping("/header")
	public String header() {
		return "users/header";
	}
	
	@ModelAttribute("clothes")
	public List<Clothes> getStudents(){
		return clothesRepository.findAll();
	}
	
	@RequestMapping("/search")
	public String search(Model model, @Param("keyword") String keyword) {
		System.out.println("Keyword: "+keyword);
		List<Clothes> lstClothes = clothesRepository.search(keyword);
		model.addAttribute("clothes", lstClothes);
		return "users/shopping";
	}
	
	@GetMapping("/cart")
	public String getCart(Model model) {
		List<Clothes> cart = (List<Clothes>) session.getAttribute("cart");
		System.out.print(cart);
		model.addAttribute("clothes", cart);
		return "users/cart";
	}
	
	@GetMapping("/cart/{id}")
	public String addCart(Model model, @PathVariable(name = "id") int clothesId) {
		Clothes clothes = clothesRepository.getById(clothesId);
		
		ArrayList<Clothes> cart = (ArrayList<Clothes>) session.getAttribute("cart");
		ArrayList<Integer> quantity = (ArrayList<Integer>) session.getAttribute("quantity");
		
		System.out.print("Cart contain: "+cart.contains(clothes));
				
		if(cart.contains(clothes)) {
			int index = cart.indexOf(clothes);
			int soluong = clothes.getSoluong();
			clothes.setSoluong(soluong++);
			

			cart.set(index, clothes);
			
		}
		else {
			
			cart.add(clothes);
			quantity.add(1);
		}
		
		
		session.setAttribute("cart", cart);
		session.setAttribute("quantity", quantity);
		
		System.out.print(cart);
		
		model.addAttribute("clothes", cart);
		return "users/cart";
	}

}
