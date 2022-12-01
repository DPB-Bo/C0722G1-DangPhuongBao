package com.codegym.controller;

import com.codegym.model.OrderB;
import com.codegym.service.IBookService;
import com.codegym.service.IOrderService;
import com.codegym.utils.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("")
public class OrderController {
    @Autowired
    private IOrderService orderService;
    @Autowired
    private IBookService bookService;

    @GetMapping("")
    public String display(Model model, @PageableDefault(page = 0, size = 3) Pageable pageable) {
        model.addAttribute("bookList", bookService.findAll(pageable));
        model.addAttribute("orderb", OrderB.builder().build());
        return "order_page";
    }


    @PostMapping("orderBook")
    public String orderBook(@ModelAttribute OrderB orderb, RedirectAttributes redirectAttributes) {
        String id;
        do {
            id = RandomString.generateRandomString();
            orderb.setId(id);
        } while (orderService.existsById(id));

        bookService.reduceQuantity(orderb.getBook().getId());
        orderService.save(orderb);

        redirectAttributes.addFlashAttribute("orderId", orderb.getId());
        return "redirect:/";
    }

    @PostMapping("returnBook")
    public String returnBook(@RequestParam("codeBook") String id, @RequestParam("returnBookId") Integer bookId, RedirectAttributes redirectAttributes) {
        if (!orderService.existsById(id)) {
            redirectAttributes.addFlashAttribute("codeBook", id);
            redirectAttributes.addFlashAttribute("error", "Không tồn tại mã trả sách");
            return "redirect:/";
        }
        orderService.deleteById(id);
        bookService.increaseQuantity(bookId);
        redirectAttributes.addFlashAttribute("successReturn", "Sách đã được trả");
        return "redirect:/";
    }
}
