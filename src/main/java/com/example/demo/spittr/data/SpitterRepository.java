package com.example.demo.spittr.data;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SpitterRepository {
    private List<Spitter> list = new ArrayList<>();

    public void save(Spitter spitter) {
        list.add(spitter);
    }

    public Spitter findOne(String spitterName) {
        Spitter spitter = null;

        try {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getUsername().equals(spitterName)) {
                    spitter = list.get(i);
                }
            }
        }catch (IndexOutOfBoundsException e){
            return spitter;
        }

        return spitter;
    }
}
