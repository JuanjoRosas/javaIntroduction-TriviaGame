package net.juanRosas;

import java.util.ArrayList;
import java.util.Scanner;

public class Question {
    
    //Constants
    public final static String CORRECT = "That's correct!";
    public final static String INCORRECT = "Sorry, that's incorrect...";

    //Atributes
    private String questionCaption;
    private ArrayList<String> answers;
    private String mesagge;

    //Contructor
    public Question(String pCaption, ArrayList<String> pAnswers, String pMessage){
        questionCaption = pCaption;
        answers = pAnswers;
        mesagge = pMessage;
    }

    //Methods

    /*
     * Getter and seters
     */
    public String getQuestionCaption()
    {
        return questionCaption;
    }

    public void setQuestionCaption(String pCaption)
    {
        questionCaption = pCaption;
    }

    public ArrayList<String> getAnswers()
    {
        return answers;
    }

    public void setAnswers(ArrayList<String> pAnswers)
    {
        answers = pAnswers;
    }

    public String getMessage()
    {
        return mesagge;
    }

    public void setMessage(String pMessage)
    {
        mesagge = pMessage;
    }
    
    /*
     * Print question, wait for answer and give feedback
     */
    public int doQuestion(int pNumber, int pScore, Scanner pScanner){
        int number = pNumber;
        int score = pScore;
        Scanner reader = pScanner;
        String answer;

        //print question
        System.out.println("QUESTION " + number + ":");
        System.out.println(questionCaption);

        //wait for answer
        answer = reader.next();

        //verify answer and give feedback
        score = giveFeedback(isInAnswers(answer), score);

        return score;
    }


    /*
     * search for a certain answer in list of answers
     */
    private boolean isInAnswers(String pAnswer){
        boolean found = false;
        int answersLength = answers.size();
        
        for(int i = 0; i < answersLength && !found; i++){
            if(pAnswer.toLowerCase().contains(answers.get(i))){
                found = true;
            }
        }

        return found;
    }

     /*
      * give feedback depending on results
      */
    private int giveFeedback(boolean results, int pScore){
        String msg;
        int score = pScore;

        if(results){
            msg = CORRECT;
            score++;
        }else{
            msg = INCORRECT;
        }

        msg = msg + " " + mesagge;
        System.out.println(msg);
        return score;
    }
    

}
