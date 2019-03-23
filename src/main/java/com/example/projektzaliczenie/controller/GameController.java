package com.example.projektzaliczenie.controller;


import com.example.projektzaliczenie.model.methods.Checker;
import com.example.projektzaliczenie.model.questions.Generator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GameController {

    @Autowired
    Generator generator = new Generator();
    @Autowired
    Checker checker = new Checker();

    int counter = 0;

    @GetMapping("/")
    public String getParam(ModelMap modelMap) {
        counter = 0;
        modelMap.put("counter", counter);
        return "index";
    }

    @GetMapping("/play")
    public String getQuestion(ModelMap modelMap) {
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
        modelMap.put("counter", counter);
        return "play";
    }


    @GetMapping("/result")
    public String getResultR(@RequestParam String answer,
                            ModelMap modelMap) {
        String rightAnswer = generator.getRightAnswer();

        String effect = "";
        if (answer.equals(rightAnswer)) {
            effect = "sd";
            modelMap.put("good", effect);
            modelMap.put("counter", counter);
            counter++;
            return "good";
        }else if (!answer.equals(rightAnswer)){
            modelMap.put("wrong", effect);
            modelMap.put("counter", counter);
            counter--;
        }return "wrong";

    }

}





