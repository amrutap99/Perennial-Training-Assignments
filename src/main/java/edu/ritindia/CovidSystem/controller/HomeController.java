package edu.ritindia.CovidSystem.controller;

import edu.ritindia.CovidSystem.model.LocationModel;
import edu.ritindia.CovidSystem.service.CovidDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * This is Controller class
 * This class maps web requests with given URL
 */
@Controller
public class HomeController {

    /**
     * Autowiring CovidDataService
     */
    @Autowired
    private CovidDataService coronaService;

    /**
     * This method provides GetMapping - "http://localhost:3006/"
     *
     * @param model
     * @return view for "home.html" file
     */
    @GetMapping("/")    //http://localhost:3006/
    public String home(Model model) {

        //model.addAttribute("testName","Amruta"); // can access this attribute by using thymeleaf syntax
        /*Note:
         * 1.First argument is attributeName and second is actual value
         * 2.Use attributeName in .html to retrieve value
         * */
        List<LocationModel> locationsList = coronaService.getAllLocationsStatus();
        System.out.println(locationsList);
        int totalCases = locationsList.stream().mapToInt(num -> num.getNewTotalCases()).sum();//java 8 feature used for getting sum
        int totalNewCases = locationsList.stream().mapToInt(num -> num.getDiffFromPrevDay()).sum();

        model.addAttribute("coronaStatus", locationsList);
        model.addAttribute("totalCasesReported", totalCases);
        model.addAttribute("totalNewCases", totalNewCases);

        return "home";
    }


}
