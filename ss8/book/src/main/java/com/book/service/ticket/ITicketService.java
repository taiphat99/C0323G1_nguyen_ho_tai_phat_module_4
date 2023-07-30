package com.book.service.ticket;

import com.book.model.Ticket;

import java.util.List;

public interface ITicketService {

    List<String> getRentedCodeListByBookId(int id);
    String getRentCodeByBookId(int id);
    void save(Ticket ticket);
    Ticket getTicketByCode(String rentCode);
}
