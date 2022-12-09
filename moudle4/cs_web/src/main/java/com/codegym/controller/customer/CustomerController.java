package com.codegym.controller.customer;

import com.codegym.dto.customer.CustomerDto;
import com.codegym.model.customer.Customer;
import com.codegym.model.customer.CustomerType;
import com.codegym.service.customer.ICustomerService;
import com.codegym.service.customer.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@RestController
@RequestMapping("customer")
public class CustomerController {
    private final ICustomerService customerService;
    private final ICustomerTypeService customerTypeService;

    public CustomerController(ICustomerService customerService, ICustomerTypeService customerTypeService) {
        this.customerService = customerService;
        this.customerTypeService = customerTypeService;
    }

    @GetMapping("")
    public String display(@PageableDefault(size = 5) Pageable pageable, CustomerDto customerDto, Model model, @RequestParam(defaultValue = "") String searchName, @RequestParam(defaultValue = "") String searchEmail, @RequestParam(defaultValue = "-1") int searchCustomerType) {
        if (searchCustomerType != -1) {
            CustomerType customerType = customerTypeService.findById(searchCustomerType);
            model.addAttribute("customerList", customerService.findByNameContainingAndEmailContainingAndCustomerType(searchName, searchEmail, customerType, pageable));
        } else {
            model.addAttribute("customerList", customerService.findByNameContainingAndEmailContaining(searchName, searchEmail, pageable));
        }
        model.addAttribute("searchName", searchName);
        model.addAttribute("searchEmail", searchEmail);
        model.addAttribute("searchCustomerType", searchCustomerType);
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        model.addAttribute("customerDto", customerDto);
        return "customer/display";
    }

    @GetMapping("save/errors")
    public String display(@PageableDefault(size = 5) Pageable pageable, Model model, @RequestParam(defaultValue = "") String searchName, @RequestParam(defaultValue = "") String searchEmail, @RequestParam(defaultValue = "-1") int searchCustomerType, @Valid CustomerDto customerDto, BindingResult bindingResult) {
        if (searchCustomerType != -1) {
            CustomerType customerType = customerTypeService.findById(searchCustomerType);
            model.addAttribute("customerList", customerService.findByNameContainingAndEmailContainingAndCustomerType(searchName, searchEmail, customerType, pageable));
        } else {
            model.addAttribute("customerList", customerService.findByNameContainingAndEmailContaining(searchName, searchEmail, pageable));
        }
        model.addAttribute("searchName", searchName);
        model.addAttribute("searchEmail", searchEmail);
        model.addAttribute("searchCustomerType", searchCustomerType);
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        model.addAttribute("customerDto", customerDto);
        return "customer/display";
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("customerDto") CustomerDto customerDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("customerDto", customerDto);
            redirectAttributes.addFlashAttribute("hasErrors", true);
            return "redirect:/customer/save/errors";
        }
        Customer customer = Customer.builder().build();
        BeanUtils.copyProperties(customerDto, customer);
        customerService.save(customer);
        return "redirect:/customer";
    }

    
}
