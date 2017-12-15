package com.example.demo.spittr.data;

import com.example.demo.spittr.Spittle;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component
public class SpittleRepository {
    public List<Spittle> findSpittles(long max, int count){
        ArrayList list = new ArrayList<Spittle>();
        Calendar calendar = Calendar.getInstance();

        calendar.set(2009, 6 - 1, 12);

        System.out.println(calendar.get(Calendar.YEAR));

        list.add(new Spittle(1L,"first",new Date()));
        list.add(new Spittle(2L,"second",new Date()));
        list.add(new Spittle(3L,"third",new Date()));
        return list;
    }
}
