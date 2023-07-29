package com.book.controller;

import com.book.model.Book;
import com.book.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

import static com.book.util.RandomStringUtil.generateRandomString;

@Controller
@RequestMapping("/home")
public class BookController {
    @Autowired
    IBookService bookService;

    @GetMapping("")
    public String showList(Model model) {
        List<Book> bookList = bookService.findAll();
        model.addAttribute("bookList", bookList);
        return "list";
    }

    @GetMapping("/detail/{id}")
    public String showDetailBook(Model model, @PathVariable int id) {
        Book book = bookService.findBookById(id);
        model.addAttribute("book", book);
        return "detail";
    }

    @GetMapping("/borrow/{id}")
    public String borrow(@PathVariable int id) {
        Book book = bookService.findBookById(id);
        String str = generateRandomString();
        book.setBorrowCode(str);
        book.setQuantity(book.getQuantity()-1);
        bookService.save(book);
        return "redirect:/home";
    }

}
