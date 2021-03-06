package com.example.demo.controller;
import java.util.List;


import com.example.demo.service.AlienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.AlienRepo;
import com.example.demo.model.Alien;

//import antlr.collections.List;

@Controller
public class AlienController {
	@Autowired
	AlienService repo;
	
////pojo edit

	@RequestMapping("/")
	public ModelAndView home()
	{	ModelAndView mv=new ModelAndView("show.jsp");

		List<Alien> alien;
		alien = repo.findAllUsers();
		System.out.println(alien);


		mv.addObject("a",alien);
		return mv;

	}



	//adding new employees
	@RequestMapping("/addAlien")
	public ModelAndView addAlien(Alien alien)
	{
		alien.set_id(alien.getAid());
		System.out.println(alien);
		repo.addNewUser(alien);
		ModelAndView mv=new ModelAndView("show.jsp");
		List<Alien> al=repo.findAllUsers();
		mv.addObject("a",al);
		return mv;
	}


	@GetMapping("/show")
	public ModelAndView show(@RequestParam int aid)
	{	ModelAndView mv=new ModelAndView("details.jsp");
		System.out.println("the value is"+aid);

		Alien alien=repo.findUser(aid);

		mv.addObject("a",alien);
		return mv;

	}

	@RequestMapping("/updateAlien")
	public ModelAndView updaAlien(Alien alien)
	{
		alien.set_id(alien.getAid());
		repo.updateUser(alien);
		ModelAndView mv=new ModelAndView("show.jsp");
		List<Alien> al=repo.findAllUsers();
		mv.addObject("a",al);
		return mv;
	}



	@GetMapping("/delete")
	public ModelAndView delete(@RequestParam int aid)
	{
		ModelAndView mv=new ModelAndView("show.jsp");
		System.out.println(repo.findUser(aid));
		repo.deleteUser(aid);

		List<Alien> alien=repo.findAllUsers();
		mv.addObject("a",alien);
		return mv;

	}



	@GetMapping("/list")
	public ModelAndView list()
	{	ModelAndView mv=new ModelAndView("show.jsp");

		List<Alien> alien=repo.findAllUsers();
		System.out.println(alien);



		mv.addObject("a",alien);
		return mv;

	}


////	pojo edit end


//EDIT REQUEST	

	

	
//Home page
//	@RequestMapping("/")
//	public ModelAndView home()
//	{	ModelAndView mv=new ModelAndView("show.jsp");
//
//		List<Alien> alien=repo.findAll();
//		System.out.println(alien);
//
//
//		mv.addObject("a",alien);
//		return mv;
//
//	}
//
//
//
////adding new employees
//	@RequestMapping("/addAlien")
//	public ModelAndView addAlien(Alien alien)
//	{
//		alien.set_id(alien.getAid());
//
//		repo.save(alien);
//		ModelAndView mv=new ModelAndView("show.jsp");
//	//System.out.println("the value is"+aid);
//		List<Alien> al=repo.findAll();
//		mv.addObject("a",al);
//		return mv;
//	}
//
//
//
//
////get all employess details in json formate
//	@RequestMapping("/getAlien")
//	@ResponseBody
//	public List<Alien> getAlien()
//	{
//		return repo.findAll();
//	}
//
//
//
////repository for showing home page all details
//	//and getting details of any certain employee for update
//	@GetMapping("/show")
//	public ModelAndView show(@RequestParam int aid)
//	{	ModelAndView mv=new ModelAndView("details.jsp");
//		System.out.println("the value is"+aid);
//
//		Alien alien=repo.findByAid(aid);
//
//		mv.addObject("a",alien);
//		return mv;
//
//	}
//
//
//
////deleting repository
////	@GetMapping("/delete")
////
////	public ModelAndView delete(@RequestParam int aid)
////	{
////		ModelAndView mv=new ModelAndView("show.jsp");
////
////
////		Alien b=repo.findById(aid).orElse(new Alien());
////		repo.deleteById(aid);
////		System.out.println("employee : "+ b.getAid() + ": "+b.getAname()+ " is deleted");
////		List<Alien> alien=repo.findAll();
////		mv.addObject("a",alien);
////		return mv;
////
////	}
//
//	@GetMapping("/delete")
//
//	public ModelAndView delete(@RequestParam int aid)
//	{
//		ModelAndView mv=new ModelAndView("show.jsp");
//		System.out.println(repo.findByAid(aid));
//		repo.deleteByAid(aid);
//
//		List<Alien> alien=repo.findAll();
//		mv.addObject("a",alien);
//		return mv;
//
//	}
//
//
//
//	@GetMapping("/list")
//		public ModelAndView list()
//	{	ModelAndView mv=new ModelAndView("show.jsp");
//		//System.out.println("the value is"+aid);
//		List<Alien> alien=repo.findAll();
//		System.out.println(alien);
//
//		//Alien alien=repo.findById(aid).orElse(new Alien());
//
//		mv.addObject("a",alien);
//		return mv;
//
//	}
	
}
