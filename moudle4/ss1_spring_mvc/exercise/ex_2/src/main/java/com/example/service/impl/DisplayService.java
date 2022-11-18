package com.example.service.impl;

import com.example.service.IDisplayService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class DisplayService implements IDisplayService {
    private static Map<String, String> dictionary = new HashMap<String, String>();

    static {
        dictionary.put("hello","xin chào");
        dictionary.put("hi","xin chào");
        dictionary.put("bing chilling","join cena");
        dictionary.put("dictionary","từ diển");
        dictionary.put("tree","cây");
        dictionary.put("sugar","đường");
        dictionary.put("chicken","gà");
        dictionary.put("gà","chicken");
    }

    public String getViWord(String enWord) {
        String result;
        if (enWord == null) {
            result = "";
        }else {
            result = dictionary.get(enWord);
        }
        return result == null ? "Không có kết quả" : result;
    }
}
