package com.example.projektzaliczenie.controller;


import com.example.projektzaliczenie.model.game.Game;
import com.example.projektzaliczenie.model.questions.Generator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class GameController {

    Generator generator = new Generator();



    @GetMapping("/")
    public String getParam(){
    return "index";
    }

    @GetMapping("/play")
    public String getQuestion(ModelMap modelMap){
        String question = generator.generateQuestion();
        String rightAnswer = generator.getRightAnswer();
        String wrongAnswer1 = generator.getWrongAnswer1();
        String wrongAnswer2 = generator.getWrongAnswer2();
        String wrongAnswer3 = generator.getWrongAnswer3();
        modelMap.put("question", question);
        modelMap.put("rightAnswer", rightAnswer);
        modelMap.put("wrongAnswer1", wrongAnswer1);
        modelMap.put("wrongAnswer2", wrongAnswer2);
        modelMap.put("wrongAnswer3", wrongAnswer3);
        return "play";
    }



    @GetMapping("/a")
    public String getPageA() {
        return "a";
    }
    @GetMapping("/b")
    public String getPageB(){
        return "b";
    }
    @GetMapping("/c")
    public String getPageC(){
        return "c";
    }

    @GetMapping("/d")
    public String GetPageD(){
        return "d";
    }







    }





