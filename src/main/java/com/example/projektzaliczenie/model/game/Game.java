package com.example.projektzaliczenie.model.game;

import com.example.projektzaliczenie.model.communicates.Communicates;
import com.example.projektzaliczenie.model.methods.Checker;
import com.example.projektzaliczenie.model.questions.Generator;

import java.util.Random;
import java.util.Scanner;

public class Game {

    Scanner scanner = new Scanner(System.in);
    Generator generator = new Generator();
    Checker checker = new Checker();
    Random random = new Random();
    Communicates communicates = new Communicates();

    int r;
    String skip = checker.getSkip();
    String answer;
    String exit = checker.getExit();
    boolean flag = true;

    public void run() {

        System.out.println(communicates.welcome);
        while (checker.getCounter() > 0 || flag) {

            generator.generateQuestion();

            answer = scanner.nextLine();

            if (!answer.equals(skip) && !answer.equals(checker.getExit())) {

                if (answer.equals(generator.getRightAnswer()) && checker.modulo()) {        // wchodzi w modulo nawet jak zla odpowiedz
                    answer = scanner.nextLine();
                    checker.secondR(answer, generator.getRightAnswer());
                } else if (!answer.equals(generator.getRightAnswer()) && checker.modulo()) {
                    answer = scanner.nextLine();
                    checker.secondW(answer, generator.getRightAnswer());
                } else {
                    checker.right(answer, generator.getRightAnswer());
                }
            } else if (checker.skip(answer)) {

            } else checker.exit(answer);


            if (checker.getCounter() == 0 || answer.equals(checker.getExit())) {
                flag = false;
            }

        }
    }
}
