package net.juanRosas;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //create questions
        ArrayList<Question> questions = new ArrayList<>();
        Question questionAdded;
        String question;
        ArrayList<String> answers;
        String message;

        //question 1
        question = "Write a still existing mammal that can lay eggs";
        answers = new ArrayList<>();
        answers.add("platypus");
        answers.add("echidna");
        answers.add("spiny anteater");
        message = "Only two kinds of egg-laying mammals are left on the planet today - the duck-billed platypus and the echidna, or spiny anteater.";
        questionAdded = new Question(question, answers, message);
        questions.add(questionAdded);

        //question 2
        question = "What is the largest organ in the body?";
        answers = new ArrayList<>();
        answers.add("skin");
        message = "The skin is the largest organ in the body.";
        questionAdded = new Question(question, answers, message);
        questions.add(questionAdded);

        //question 3
        question = "What is the most abundant element in the universe?";
        answers = new ArrayList<>();
        answers.add("hydrogen");
        message = "The most abundant element in the universe is hydrogen, which makes up about three-quarters of all matter!";
        questionAdded = new Question(question, answers, message);
        questions.add(questionAdded);

        //question 4
        question = "What is the capital of the United Kingdom?";
        answers = new ArrayList<>();
        answers.add("london");
        message = "The capital is London, which is among the world's leading commercial, financial, and cultural centres.";
        questionAdded = new Question(question, answers, message);
        questions.add(questionAdded);

        //question 5
        question = "What is the chemical symbol of Iron?";
        answers = new ArrayList<>();
        answers.add("fe");
        message = "Iron is a chemical element with symbol Fe (from Latin: ferrum) and atomic number 26.";
        questionAdded = new Question(question, answers, message);
        questions.add(questionAdded);

        Scanner reader = new Scanner(System.in); //Initialize input reader

        //Create Trivia and Run
        Trivia trivia = new Trivia(questions);
        trivia.runTrivia(reader);

        //Close Scanner
        reader.close();
    }
}