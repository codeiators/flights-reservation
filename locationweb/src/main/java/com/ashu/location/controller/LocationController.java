package com.ashu.location.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ashu.location.entities.Location;
import com.ashu.location.repos.LocationRepository;
import com.ashu.location.service.LocationService;
import com.ashu.location.util.EmailUtil;
import com.ashu.location.util.ReportUtil;

@Controller
public class LocationController {

	@Autowired
	LocationService service;
	@Autowired
	EmailUtil emailUtil;
	
	@Autowired
	LocationRepository repository;
	@Autowired
	ReportUtil reportUtil;
	
	@Autowired
	ServletContext sc;

	@RequestMapping("/showCreate")
	public String showCreate() {
		return "Location";
	}

	@RequestMapping("/saveLoc")
	public String saveLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
		Location locationSaved = service.saveLocation(location);
		String message = "Location saved with id: " + locationSaved.getId();
		modelMap.addAttribute("msg", message);
	//	emailUtil.sendEmail("ashu.jain01@gmail.com","Loaction saved","Location Saved Successfully");
		return "Location";
	}

	@RequestMapping("/displayLocations")
	public String displayLocations(ModelMap modelMap) {
		List<Location> locations = service.getAllLocations();
		modelMap.addAttribute("locations", locations);
		return "displayLocations";
	}

	@RequestMapping("/deleteLocation")
	public String deleteLocation(@RequestParam("id") int id, ModelMap modelMap) {
		Location location = service.getLocationById(id);
		service.deleteLocation(location);
		List<Location> locations = service.getAllLocations();
		modelMap.addAttribute("locations", locations);
		return "displayLocations";
	}

	@RequestMapping("/showUpdate")
	public String showUpdate(@RequestParam("id") int id,ModelMap modelMap
			) {
        Location location=service.getLocationById(id);
        modelMap.addAttribute("location", location);
		return "updateLocation";
	}

	@RequestMapping("/updateLoc")
	public String updateLocation(@ModelAttribute("location") Location location, ModelMap modelMap
			) {
        Location updateLocation=service.updateLocation(location);
        List<Location> locations=service.getAllLocations();
        modelMap.put("locations",locations);
		return "displayLocations";
	}
	
	@RequestMapping("/generateReport")
	public String generateReport()
	{
		String path=sc.getRealPath("/");
		List<Object[]> data=repository.findTypeAndTypeCount();
		reportUtil.generatePieChart(path,data);
		return "report";
		
	}

	public LocationService getService() {
		return service;
	}

	public void setService(LocationService service) {
		this.service = service;
	}

}
