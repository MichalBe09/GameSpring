package com.example.projektzaliczenie.model.questions;

import com.example.projektzaliczenie.model.questions.questions_constructors.Question;
import com.example.projektzaliczenie.model.questions.questions_db.QuestionsDB;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Component
public class Generator {


    private String rightAnswer;
    private String wrongAnswer1;
    private String wrongAnswer2;
    private String wrongAnswer3;

    QuestionsDB questionsDB = new QuestionsDB();
    Random random = new Random();


    public String generateQuestion() {
        Question question = questionsDB.getQuestionsDb().get(random.nextInt(questionsDB.getQuestionsDb().size()));      // pobieranie losowego indeksu z QuestionsDB
        String quest = question.getQuestion();         // pobieranie pytania z wylosowanego indeksu
        rightAnswer = question.getAnswer();      // pobieranie prawidlowej odpowiedzi z wylosowanego indeksu
        wrongAnswer1 = question.getAnswers().getAnswer1();   // pobieranie jednej z nieprawidlowych odpowiedzi z wylosowanego indeksu
        wrongAnswer2 = question.getAnswers().getAnswer2();   // pobieranie jednej z nieprawidlowych odpowiedzi z wylosowanego indeksu
        wrongAnswer3 = question.getAnswers().getAnswer3();   // pobieranie jednej z nieprawidlowych odpowiedzi z wylosowanego indeksu
        List<String> answers = new ArrayList<>();   // lista przechwytująca i tasująca wszystkie możliwości odpowiedzi
        answers.add(rightAnswer);
        answers.add(wrongAnswer1);
        answers.add(wrongAnswer2);
        answers.add(wrongAnswer3);
        Collections.shuffle(answers);       // tasowanie możliwości odpowiedzi
        System.out.println(quest);          // drukowanie pytania
        for (String answerss : answers) {
            System.out.println(answerss);   // drukowanie odpowiedzi
        }
        return quest;
    }


    public String getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public String getWrongAnswer1() {
        return wrongAnswer1;
    }

    public void setWrongAnswer1(String wrongAnswer1) {
        this.wrongAnswer1 = wrongAnswer1;
    }

    public String getWrongAnswer2() {
        return wrongAnswer2;
    }

    public void setWrongAnswer2(String wrongAnswer2) {
        this.wrongAnswer2 = wrongAnswer2;
    }

    public String getWrongAnswer3() {
        return wrongAnswer3;
    }

    public void setWrongAnswer3(String wrongAnswer3) {
        this.wrongAnswer3 = wrongAnswer3;
    }

    public QuestionsDB getQuestionsDB() {
        return questionsDB;
    }

    public void setQuestionsDB(QuestionsDB questionsDB) {
        this.questionsDB = questionsDB;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }


}
