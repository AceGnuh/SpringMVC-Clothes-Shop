package com.example.demo.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.Clothes;
import com.example.demo.repository.ClothesRepository;

@Controller
@RequestMapping(value = "/clothes")
public class ClothesController {
	public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\images\\";

	@Autowired
	private ClothesRepository clothesRepository;
	
	
	@RequestMapping("clothes-list")
	public String list() {		
		return "clothes/clothes-list";
	}
	
	public Page<Clothes> listAll(int pageNum) {
	    int pageSize = 10;
	     
	    Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
	     
	    return clothesRepository.findAll(pageable);
	}
	
	@RequestMapping("/page/{pageNum}")
	public String viewPage(Model model,
	        @PathVariable(name = "pageNum") int pageNum) {
	     
	    Page<Clothes> page = listAll(pageNum);
	     
	    List<Clothes> listProducts = page.getContent();
	    
	    System.out.print(listProducts);
	     
	    model.addAttribute("currentPage", pageNum);
	    model.addAttribute("totalPages", page.getTotalPages());
	    model.addAttribute("totalItems", page.getTotalElements());
	    model.addAttribute("clothes", listProducts);
	     
	    return "clothes/list-page";
	}
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
	    return viewPage(model, 1);
	}
	
	
	@ModelAttribute("clothes")
	public List<Clothes> getStudents(){

		return clothesRepository.findAll();
	}
	
	@GetMapping("detail")
	public String deltail(@RequestParam("clothesId") String clothesId, Model model) {
		
		System.out.println("Clothes id: " + clothesId);
		
		Clothes clothes = clothesRepository.getById(Integer.parseInt(clothesId));
		
		model.addAttribute("clothes", clothes);
		
		return "clothes/detail";
	}
	@RequestMapping("/new")
	public String newStudent(Model model) {
		model.addAttribute("clothes", new Clothes());
		return "clothes/new";
	}

	@RequestMapping("/saveOrUpdate")
	  public String doSaveCustomer(@ModelAttribute("Clothes") Clothes clothes
			  , Model model
			  , @RequestParam("fileToUpload") MultipartFile file, RedirectAttributes attributes
			  ) {
		
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        Path path = Paths.get(UPLOAD_DIRECTORY + fileName);
        
		try {
			Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		System.out.println("Real path: "+UPLOAD_DIRECTORY + fileName);
//		
//		System.out.print(clothes);
		
		clothes.setImage(fileName);
		
		System.out.print(clothes);
	    clothesRepository.save(clothes);
	    return "redirect:/clothes/";
	  }
	@GetMapping("edit")
	public String edit(@RequestParam("clothesId") String id, Model model) {
		
		Clothes clothes = clothesRepository.getById(Integer.parseInt(id));
		
		model.addAttribute("clothes", clothes);
		
		return "clothes/edit";
	}
	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id") Integer id, Model model) {
		
		clothesRepository.deleteById(id);
		
		return "redirect:/clothes/clothes-list";
	}

	@PostMapping("/update")
	public String update(
			@ModelAttribute("Clothes") Clothes clothes
			,Model model
			) {
		
		Optional<Clothes> clothes2 = clothesRepository.findById(clothes.getId());
		
		clothes.setImage(clothes2.get().getImage());
		
		clothesRepository.save(clothes);

		model.addAttribute("clothes", clothes);
		return "redirect:/clothes/clothes-list";
	}
	
	@GetMapping("/home1")
	public String home() {
	    return "home1";
	}
}
