package com.book.controller;

import com.book.aop.Logger;
import com.book.model.Book;
import com.book.model.Ticket;
import com.book.service.book.IBookService;
import com.book.service.ticket.ITicketService;
import com.book.util.IOFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static com.book.util.RandomStringUtil.generateRandomString;

@Controller
@RequestMapping("/home")
public class BookController {
    @Autowired
    private ITicketService ticketService;
    @Autowired
    private IBookService bookService;

    @GetMapping("")
    public String showList(Model model) {
        List<Book> bookList = bookService.findAll();
        model.addAttribute("bookList", bookList);
        List<String> list = IOFile.readFile("/main/java/com/book/data/numberOfAccess.csv");
//        int count = Integer.parseInt(IOFile.readFile("/src/main/java/com/book/data/numberOfAccess.csv").get(0));
//        model.addAttribute("numberOfAccess",count);
        return "list";
    }

    @GetMapping("/detail/{id}")
    public String showDetailBook(Model model, @PathVariable int id) {
        Book book = bookService.findBookById(id);
        String rentCode = ticketService.getRentCodeByBookId(id);
        model.addAttribute("rentCode", rentCode);
        model.addAttribute("book", book);
        return "detail";
    }

    @GetMapping("/borrow/{id}/{rentCode}")
    public String borrow(@PathVariable int id, @PathVariable String rentCode) {
        Book book = bookService.findBookById(id);
        Ticket ticket = ticketService.getTicketByCode(rentCode);
        ticket.setStatus(true);
        String str = generateRandomString();
        ticketService.save(new Ticket(str,false,book));
        book.setQuantity(book.getQuantity()-1);
        bookService.save(book);
        return "redirect:/home";
    }

}
