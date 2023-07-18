package com.example.dictionary.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DictionaryRepository implements IDictionaryRepository {
    private static final Map<String, String> dictionary = new HashMap<>();

    static {
        dictionary.put("car", "xe hơi");
        dictionary.put("book", "Sách");
        dictionary.put("computer", "Máy Tính");
        dictionary.put("table", "Bàn");
        dictionary.put("chair", "Ghế");
    }

    @Override
    public String search(String word) {
        return dictionary.get(word);
    }
}
