package com.kayulu.springbootmvcvalidation;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {
    @GetMapping("/")
    private String showForm(Model model) {
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
    private String processForm(
            @Valid
            @ModelAttribute("customer") Customer customer,
            BindingResult bindingResult) {

        if(bindingResult.hasErrors())
            return "customer-form";
        else
            return "customer-confirmation";
    }
}
