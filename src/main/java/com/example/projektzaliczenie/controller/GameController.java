package com.example.projektzaliczenie.controller;


import com.example.projektzaliczenie.model.questions.Generator;
import com.example.projektzaliczenie.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

@Controller
public class GameController {

    @Autowired
    Generator generator = new Generator();

    @Autowired
    GameService gameService = new GameService();
    Random random = new Random();
    private int counter = 0;

    @GetMapping("/")
    public String getParam(ModelMap modelMap) {
        counter = 0;
        gameService.setLifebuoy(0);
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
        modelMap.put("rightAnswer", rightAnswer);
        String wrongAnswer1 = generator.getWrongAnswer1();
        String wrongAnswer2 = generator.getWrongAnswer2();
        String wrongAnswer3 = generator.getWrongAnswer3();
        modelMap.put("wrongAnswer1", wrongAnswer1);
        modelMap.put("wrongAnswer2", wrongAnswer2);
        modelMap.put("wrongAnswer3", wrongAnswer3);

        int r = random.nextInt(1000);
        if (gameService.rightMod(answer, rightAnswer, r)) {
            return "ausure";
        } else if (gameService.right(answer, rightAnswer)) {
            counter++;
            return "good";
        } else if (gameService.wrongMod(answer, rightAnswer, r)) {
            return "ausurew";
        } else {
            counter--;
            if (counter == 0) {
                return "lost";
            }
        }
        return "wrong";
    }


    @GetMapping("/sure")
    public String getSure(@RequestParam String answer,
                          ModelMap modelMap) {
        String rightAnswer = generator.getRightAnswer();
        if (gameService.right(answer, rightAnswer)) {
            counter++;
            return "good";
        } else {
            counter--;
            if (counter == 0) {
                return "lost";
            }
        }
        return "secondw";
    }


    @GetMapping("/surew")
    public String getSurew(@RequestParam String answer,
                           ModelMap modelMap) {
        String rightAnswer = generator.getRightAnswer();
        if (gameService.right(answer, rightAnswer)) {
            return "secondr";
        } else {
            counter--;
            if (counter == 0) {
                return "lost";
            }
        }
        return "wrong";
    }

    @GetMapping("/lifebuoy")
    public String getLife(ModelMap modelMap) {
        String rightAnswer = generator.getRightAnswer();
        String wrongAnswer2 = generator.getWrongAnswer2();
        modelMap.put("lifebuoy", gameService.getLifebuoy());
        modelMap.put("rightAnswer", rightAnswer);
        modelMap.put("wrongAnswer2", wrongAnswer2);
        if (gameService.getLife()) {
            return "lifebuoy";
        } else {
            counter--;
            if (counter == 0) {
                return "lost";
            }
        }
        return "nobuoys";
    }
}




