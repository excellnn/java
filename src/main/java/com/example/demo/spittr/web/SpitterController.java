package com.example.demo.spittr.web;

import com.example.demo.spittr.data.Spitter;
import com.example.demo.spittr.data.SpitterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/spitter")
public class SpitterController {
    private SpitterRepository spitterRepository;
    @Autowired
    public SpitterController(SpitterRepository spitterRepository){
        this.spitterRepository = spitterRepository;
    }

    @RequestMapping(value = "{username}" ,method = RequestMethod.GET)
    public String index(@PathVariable String username, Model model){
        if(!model.containsAttribute("spitter")){
            model.addAttribute("username",spitterRepository.findOne(username));
        }
        return "spitter-index";
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute("spitter",new Spitter());
        return "registerForm";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String processRegistration(
            @RequestPart("profilePicture") MultipartFile profilePicture,
            @Valid Spitter spitter,
            Errors errors,
            RedirectAttributes model){

       /* try{
            profilePicture.transferTo(new File("/Users/lnn/Desktop/"+profilePicture.getOriginalFilename()));
        }catch (IOException e){
            System.out.println(e.getMessage());
        }*/

        if(errors.hasErrors()){
            return "registerForm";
        }

        model.addFlashAttribute("spitter",spitter);
        spitterRepository.save(spitter);
        return "redirect:/spitter/"+spitter.getUsername();
    }
}
