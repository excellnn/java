package com.example.demo.spittr.data;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component
public class SpittleRepository {
    private ArrayList list = new ArrayList<Spittle>();

    public List<Spittle> findSpittles(long max, int count){
        Calendar calendar = Calendar.getInstance();

        calendar.set(2009, 6 - 1, 12);

        for (Long i=0L;i<200;i++){
            list.add(new Spittle(i,"hello "+i+": content",new Date()));
        }
        return list;
    }

    public Spittle findOne(Long id){
        Spittle spittle = null;

        for (int i=0;i<list.size();i++){
            Spittle _spittle = (Spittle) list.get(i);
            if(id == _spittle.getId()){
                spittle = (Spittle) list.get(i);
            }
        }

        return spittle;
    }
}
