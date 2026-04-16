package com.luvIsCode.springdev.mvc;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CustomerController {

    //add an init binder...... to convert trim input strings
    //remove leading and trailing whitespaces
    //remove issue for our validation
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmer = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmer);
    }

    @GetMapping("/")
    public String showFrom(Model theModel) {
        theModel.addAttribute("customer", new Customer());

        return "customer-form";
    }

        @PostMapping("/processForm")
        public String processForm(
                @Valid @ModelAttribute("customer") Customer theCustomer,
                BindingResult theBindingResult){
        if(theBindingResult.hasErrors()){
            System.out.println("Last Name : |" + theCustomer.getLastName() +"|");
            return "customer-form";
        }else{
            return "customer-confirmation";
        }
        }
}
