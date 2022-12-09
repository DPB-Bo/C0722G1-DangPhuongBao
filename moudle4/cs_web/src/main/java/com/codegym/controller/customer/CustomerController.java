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

@Controller
@RequestMapping("customer")
public class CustomerController {
    private final ICustomerService customerService;
    private final ICustomerTypeService customerTypeService;

    public CustomerController(ICustomerService customerService, ICustomerTypeService customerTypeService) {
        this.customerService = customerService;
        this.customerTypeService = customerTypeService;
    }

    @GetMapping("")
    public String display(@Validated CustomerDto tempCustomerDto, BindingResult bindingResultTemp, @Validated CustomerDto editCustomerDto, BindingResult bindingResultEdit, Model model, @RequestParam(defaultValue = "") String searchName, @RequestParam(defaultValue = "") String searchEmail, @RequestParam(defaultValue = "-1") int searchCustomerType, @PageableDefault(size = 5) Pageable pageable) {
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
        model.addAttribute("tempCustomerDto", tempCustomerDto);
        model.addAttribute("editCustomerDto", editCustomerDto);
        return "customer/display";
    }

    @PostMapping("save/{save_code}")
    public String save(@Validated @ModelAttribute("tempCustomerDto") CustomerDto tempCustomerDto, BindingResult bindingResultTemp, @Validated @ModelAttribute("editCustomerDto") CustomerDto editCustomerDto, BindingResult bindingResultEdit, @PathVariable String save_code, Model model, @RequestParam(defaultValue = "") String searchName, @RequestParam(defaultValue = "") String searchEmail, @RequestParam(defaultValue = "-1") int searchCustomerType, @PageableDefault(size = 5) Pageable pageable) {
        Customer customer = Customer.builder().build();
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
        switch (save_code) {
            case "1":
                if (bindingResultTemp.hasErrors()) {
                    model.addAttribute("tempCustomerDto", tempCustomerDto);
                    model.addAttribute("hasErrorsAdd", true);
                    model.addAttribute("statusCode", 1);
                    model.addAttribute("editCustomerDto", CustomerDto.builder().build());
                    return "customer/display";
                }
                BeanUtils.copyProperties(tempCustomerDto, customer);
                customerService.save(customer);
                return "redirect:/customer";
            case "2":
                if (bindingResultEdit.hasErrors()) {
                    model.addAttribute("editCustomerDto", editCustomerDto);
                    model.addAttribute("hasErrorsEdit", true);
                    model.addAttribute("statusCode", 2);
                    model.addAttribute("tempCustomerDto", CustomerDto.builder().build());
                    return "customer/display";
                }
                BeanUtils.copyProperties(tempCustomerDto, customer);
                customerService.save(customer);
                return "redirect:/customer";
        }
        return "customer/display";
    }

    @PostMapping("delete")
    public String deleteCustomer(@RequestParam("deleteId") String deleteId) {
        customerService.deleteById(Integer.parseInt(deleteId));
        return "redirect:/customer";
    }
}
