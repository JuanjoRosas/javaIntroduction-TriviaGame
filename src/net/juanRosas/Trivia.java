package net.juanRosas;

import java.util.ArrayList;
import java.util.Scanner;

public class Trivia {
    
    //Constants
    public final static String PERFECT = "Congratulations you've got perfect score!";
    public final static String EXCELLENT = "Hats off!";
    public final static String ACCEPTABLE = "That was great!";
    public final static String ENOUGH = "Great effort!";
    public final static String NOT_ENOUGH = "Nice try!";
    public final static String LOW = "Oops,";
    public final static String LOWEST = "You've got no correct answers. Let's try it again!";

    //Atributes
    private ArrayList<Question> questions;
    private int score;
    private int maxScore;
    
    //Constructor
    public Trivia(ArrayList<Question> pQuestions){
        questions = pQuestions;
        score = 0;
        maxScore = questions.size();
    }

    //Methods

    /*
     * Run the trivia
     */
    public void runTrivia(Scanner pScanner)
    {
        //do questions
        doQuestions(pScanner);

        //show results
        showResults();
    }

    /*
     * Do questions
     */
    private void doQuestions(Scanner pScanner){
        Scanner reader = pScanner;
        int index = 0;
        Question curQuestion;

        while(true){
            String auxInput = "";
            if(index < 1) {
                System.out.println("Start? (yes/no)");
                auxInput = reader.next();
            } else if(index == maxScore) {
                auxInput = "no";
            } else {
                System.out.println("Continue? (yes/no)");
                auxInput = reader.next();
            }

            if(auxInput.equals("no")){
                System.out.println("Game ended");
                break;
            }
            else if(auxInput.equals("yes")) {
                curQuestion = questions.get(index);
                score = curQuestion.doQuestion(index + 1, score, reader);
                index++;
                continue;
            }
        }
    }

     /*
      * Show results
      */
    private void showResults()
    {
        float percentScore = score/maxScore;
        String msg = "";

        if(percentScore == 1){
            msg = PERFECT;
        } else if(score >= 0.8){
            msg = EXCELLENT + " You've got " + score + " correct answers our of " + maxScore;
        } else if(score >= 0.6){
            msg = ACCEPTABLE + " You've got " + score + " correct answers our of " + maxScore;
        } else if(score >= 0.4){
            msg = ENOUGH + " You've got " + score + " correct answers our of " + maxScore;
        } else if(score >= 0.2){
            msg = NOT_ENOUGH + " You've got " + score + " correct answers our of " + maxScore;
        } else if(score > 0){
            msg = LOW + " You've got " + score + " correct answers our of " + maxScore;
        } else if(score == 0){
            msg = LOWEST;
        }

        System.out.println(msg);
    
    }
}
