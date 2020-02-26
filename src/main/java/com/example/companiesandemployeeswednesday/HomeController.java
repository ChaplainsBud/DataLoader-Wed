package com.example.companiesandemployeeswednesday;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    CompanyRepository companyRepository;

//    @Autowired
//    EmployeeRepository employeeRepository;
//
    @RequestMapping("/")
    public String listCourses(Model model){
        model.addAttribute("companies", companyRepository.findAll());
        return "list";
    }

    @GetMapping("/add")
    public String companyForm(Model model){
        model.addAttribute("company", new Company());
        return "companyform";
    }

    @PostMapping("/process")
    public String processForm(@Valid Company company,
                              BindingResult result){
        if (result.hasErrors()){
            return "companyform";
        }
        companyRepository.save(company);
        return "redirect:/";
    }
    @RequestMapping("/detail/{id}")
    public String showCourse(@PathVariable("id") long id, Model model)
    {
        model.addAttribute("company", companyRepository.findById(id).get());
        return "show";
    }

    @RequestMapping("/update/{id}")
    public String updateCourse(@PathVariable("id") long id,
                               Model model){
        model.addAttribute("company", companyRepository.findById(id).get());
        return "companyform";
    }

    @RequestMapping("/delete/{id}")
    public String delCompany(@PathVariable("id") long id){
        companyRepository.deleteById(id);
        return "redirect:/";
    }
}
