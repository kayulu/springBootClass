package com.kayulu.springbootmvcvalidation;

import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    // Notes: @InitBinder allows to initialize WebDataBinder instances
    // A WebDataBinder is responsible for data binding of web request data and Java objects.
    // A WebDataBinder allows to configure data binding rules, register custom property editors and
    // validators. That way incoming web data can be converted to Java objects or validated before it
    // gets added to the model.
    // A custom property editor is a class that can be used to convert a String in a specific format to a
    // Java object. E.g. when a date string in the format 'yyyy-MM-dd' needs to be converted to a Date object.
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        // this is a predefined editor provided by Spring to trim white-spaces of a String.
        // Note that this editor will process all incoming form fields
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("customer", new Customer());

        return "customer-form";
    }


    // Note: the @ModelAttribute can be used to bind request parameters or form data
    // to a model object. The @Valid annotation ensures that the model object will be
    // validated before it gets passed to the controller.
    // The BindingResult is used to catch and handle errors. If there are any errors
    // the BindingResult object will also be added to the model and therefore will be
    // available at the view to check for validation errors.
    @PostMapping("/processForm")
    public String processForm(
            @Valid
            @ModelAttribute("customer") Customer customer,
            BindingResult bindingResult) {

        if(bindingResult.hasErrors())
            return "customer-form";
        else
            return "customer-confirmation";
    }
}
