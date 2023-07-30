package com.book.repository;

import com.book.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICodeRepository extends JpaRepository<Ticket, Integer> {
    @Query(value = "select code from ticket where book_id = :id and status = true;", nativeQuery = true)
    List<String> getRentedCodeListByBookId(@Param(value = "id") int id);

    @Query(value = "select code from ticket where book_id = :id and status = false", nativeQuery = true)
    String getRentCodeByBookId(@Param(value = "id") int id);

    Ticket getTicketByCode(String rentCode);
}
