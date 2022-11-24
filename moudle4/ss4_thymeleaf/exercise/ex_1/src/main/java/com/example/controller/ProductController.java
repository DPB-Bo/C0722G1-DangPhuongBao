package com.example.controller;

import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String showProduct(Model model) {
        model.addAttribute("products", productService.getAvailable());
        return "product/display";
    }

    @GetMapping("update")
    public String showUpdateProductPage(Model model, @RequestParam int id) {
        model.addAttribute("product", productService.getProductById(id));
        return "product/edit";
    }

    @PostMapping("update")
    public String updateProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        if (productService.updateProduct(product)) {
            redirectAttributes.addFlashAttribute("msg", "Chỉnh sửa thành công");
        } else {
            redirectAttributes.addFlashAttribute("msg", "Chỉnh sửa không thành công");
        }
        return "redirect:/";
    }

    @GetMapping("delete")
    public String deleteProduct(@RequestParam String deleteConfirm, RedirectAttributes redirectAttributes) {
        if (productService.removeProduct(deleteConfirm)) {
            redirectAttributes.addFlashAttribute("msg", "Xoá thành công");
        } else {
            redirectAttributes.addFlashAttribute("msg", "Xoá không thành công");
        }
        return "redirect:/";
    }
}
