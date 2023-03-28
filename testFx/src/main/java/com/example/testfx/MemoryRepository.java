package com.example.testfx;

import java.util.HashMap;
import java.util.Map;

public class MemoryRepository {

    MemoryRepository(){
        Map<String,Boolean> heart = new HashMap<>();
        heart.put("heart", false);
    }

    public void save(Boolean heart){
        if(heart == true) heart = false;
        else heart = true;
    }
}
