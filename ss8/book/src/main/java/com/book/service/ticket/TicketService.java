package com.book.service.ticket;

import com.book.model.Ticket;
import com.book.repository.ICodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService implements ITicketService {
    @Autowired
    private ICodeRepository codeRepository;


    @Override
    public List<String> getRentedCodeListByBookId(int id) {
        return codeRepository.getRentedCodeListByBookId(id);
    }

    @Override
    public String getRentCodeByBookId(int id) {
        return codeRepository.getRentCodeByBookId(id);
    }

    @Override
    public void save(Ticket ticket) {
        codeRepository.save(ticket);
    }

    @Override
    public Ticket getTicketByCode(String rentCode) {
        return codeRepository.getTicketByCode(rentCode);
    }
}
