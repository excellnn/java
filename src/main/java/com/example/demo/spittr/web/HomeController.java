package com.example.demo.spittr.web;

import com.example.demo.spittr.data.Spitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class Activity{
    private Long id;
    private String title;
    private String intro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    Activity(Long id, String title, String intro){
        this.id = id;
        this.title = title;
        this.intro = intro;
    }
}



@Controller
@RequestMapping("/")
public class HomeController {

    private final JdbcOperations jdbcOperations;

    @Autowired
    HomeController(JdbcOperations jdbcOperations){
        this.jdbcOperations = jdbcOperations;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(){
        List activitys  = jdbcOperations.queryForList("select * from ts_activity");

        Iterator iterator = activitys.iterator();

        while (iterator.hasNext()){
            Map userMap = (Map) iterator.next();

            System.out.println(userMap.get("title"));
        }

        return "home";
    }
}
