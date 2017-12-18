package com.example.demo.spittr.web;

import com.example.demo.spittr.data.Spittle;
import com.example.demo.spittr.data.SpittleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/spittles")
public class SpittleController {
   private SpittleRepository spittleRepository;
   private static final String MAX_LONG_AS_STRING = Long.MAX_VALUE + "";

   @Autowired
   public SpittleController(SpittleRepository spittleRepository){
       this.spittleRepository = spittleRepository;
   }

    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles(@RequestParam(value = "max",defaultValue = MAX_LONG_AS_STRING) long max, @RequestParam(value = "count",defaultValue = "20") int count){
        return spittleRepository.findSpittles(max,count);
    }

    @RequestMapping(value = "/show/{spittleId}", method = RequestMethod.GET)
    public String show(@PathVariable("spittleId") long spittleId,Model model){
        Spittle spittle = spittleRepository.findOne(spittleId);

        model.addAttribute("spittle",spittle);
        return "show";
    }
}
