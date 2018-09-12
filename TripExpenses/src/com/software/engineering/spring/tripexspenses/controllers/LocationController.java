package com.software.engineering.spring.tripexspenses.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.software.engineering.spring.tripexspenses.domen.Location;
import com.software.engineering.spring.tripexspenses.service.LocationService;

@Controller
public class LocationController {
	@Autowired
	LocationService locationService;
	
	@RequestMapping("/locations")
	public String showLocations(Model model) {
		List<Location> locations=locationService.findAll();
		model.addAttribute("locations",locations);
		return "locations";
	}
	@RequestMapping("/addlocation")
	public String createLocation(Model model) {
		
		return "addlocation";
	}

	@RequestMapping(value = "/docreatelocation", method = RequestMethod.POST)
	public String doCreatedepartment(Model model,  Location location,  BindingResult result) {
	
		locationService.save(location);
		System.out.println(location);
		System.out.println("location added successfully");
		model.addAttribute("message","Location added succesfully!!!");
		
		return "addlocation";

	}

}
