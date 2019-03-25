package com.example.projektzaliczenie.service;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class GameService {

    private int counter = 0;
    private int lifebuoy = 0;

    public boolean right(String answer, String rightAnswer) {

        if (answer.equals(rightAnswer)) {
            return true;
        } else return false;
    }


    public boolean rightMod(String answer, String rightAnswer, int r) {
        if (answer.equals(rightAnswer) && r % 7 == 0) {
            return true;
        } else return false;
    }

    public boolean wrongMod(String answer, String rightAnswer, int r) {
        if (!answer.equals(rightAnswer) && r % 7 == 0) {
            return true;
        } else return false;

    }

    public boolean getLife() {
        if (lifebuoy < 3) {
            lifebuoy++;
            return true;
        } else return false;
    }

    public int getLifebuoy() {
        return lifebuoy;
    }

    public void setLifebuoy(int lifebuoy) {
        this.lifebuoy = lifebuoy;
    }
}






















