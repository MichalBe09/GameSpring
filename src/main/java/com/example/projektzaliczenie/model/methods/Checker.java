package com.example.projektzaliczenie.model.methods;

import com.example.projektzaliczenie.model.communicates.Communicates;

import java.util.Random;

public class Checker {
    int counter = 1;
    int lifebuoy = 0;
    String skip = "skip";
    String exit = "Wyjście";

    Communicates communicates = new Communicates();
    Random random = new Random();


    public boolean modulo() {

        int r = random.nextInt(10000);

        if (r % 7 == 0) {
            System.out.println(communicates.areYouSure);

            return true;
        }
        return false;
    }

    public void exit(String answer) {
        if (answer.equals(exit)) {
            System.out.println(communicates.exitGame + (counter - 1));
        }
    }


    public void secondR(String answer, String rightAnswer) {

        if (answer.equals(rightAnswer)) {
            counter++;
            System.out.println(communicates.right + (counter - 1));

        } else {
            counter--;
            System.out.println(communicates.secondWrong + (counter - 1));
            if (counter == 0) {
                System.out.println(communicates.lost);
            } else if (counter == 1) {
                counter--;
                System.out.println(communicates.lost);

            }
        }
    }

    public void secondW(String answer, String rightAnswer){

        if (answer.equals(rightAnswer)){
            System.out.println(communicates.secondRight+(counter-1));
        }else {
            counter--;
            System.out.println(communicates.wrong + (counter - 1));
            if (counter == 0) {
                System.out.println(communicates.lost);
            } else if (counter == 1) {
                counter--;
                System.out.println(communicates.lost);
            }
        }
    }


    public int right(String answer, String rightAnswer) {

        if (answer.equals(rightAnswer)) {
            counter++;
            System.out.println(communicates.right + (counter - 1));
        } else {
            counter--;
            System.out.println(communicates.wrong + (counter - 1));
            if (counter ==0){
                System.out.println(communicates.lost);
            }
            if (counter == 1) {
                counter--;
                if (counter <= 0) {
                    System.out.println(communicates.lost);
                } else {
                    System.out.println(communicates.wrong + (counter - 1));
                }
            }
        }
        return counter;
    }


    public boolean skip(String answer) {

        if (answer.equals(skip)) {
            lifebuoy++;
            if (lifebuoy <= 3) {
                System.out.println(communicates.skip + lifebuoy);

                return true;

            } else if (lifebuoy > 3) {
                counter--;
                System.out.println(communicates.noSkipsLeft+(counter-1));
                if (counter <= 0) {
                    System.out.println(communicates.lost);
                }


                return false;
            }
        }
        return false;
    }

    public String getExit() {
        return exit;
    }

    public void setExit(String exit) {
        this.exit = exit;
    }

    public String getSkip() {
        return skip;
    }

    public void setSkip(String skip) {
        this.skip = skip;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
