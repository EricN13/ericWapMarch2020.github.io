package model;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
    private List<Question> questions;
    private int index = 0;
    private int numcorrect = 0;

    public Quiz(){
        this.questions = new ArrayList<Question>();
        addQuestions();
    }

    public void addQuestion(Question question) {
       questions.add(question);
    }

    public List<Question> getQuestions() {
        return questions;
    }
    //add the two questions
    public void addQuestions(){
        Question quest1 = new Question("pie [3, 1, 4, 1, 5, ? ]", "9");
        Question quest2 = new Question("fib:  [1, 1, 2, 3, 5, ? ]", "8");
        Question quest3 = new Question("sq: [1, 4, 9, 16, 25, ? ]", "36");
        Question quest4 = new Question("pri: [2, 3, 5, 7, 11, ? ]", "13");
        Question quest5 = new Question("pow2: [1, 2, 4, 8, 16, ? ]", "32");

        questions.add(quest1);
        questions.add(quest2);
        questions.add(quest3);
        questions.add(quest4);
        questions.add(quest5);
    }

    public boolean isCorrect(String answer){
        if(index == 0){
          if(answer.equals("9")) {
              return true;
          }
        }
        else if(index == 1){
            if(answer.equals("8")){
               return true;
            }
        }
        else if(index == 2){
            if(answer.equals("36")){
                return true;
            }
        }
        else if(index == 3){
            if(answer.equals("13")){
                return true;
            }
        }
        else if(index == 4){
            if(answer.equals("32")){
                return true;
            }
        }
        return false;
    }

    public int getNumQuestions(){
        return questions.size();
    }
    
    public int getNumCorrect(){
        return numcorrect;
    }

    public int getCurrentQuestionIndex(){
        return index;
    }
    
    public String getCurrentQuestion(){
        if(index == 0){
            return questions.get(0).getQuestion();
        }
        else if(index == 1){
            return questions.get(1).getQuestion();
        }
        else if(index == 2){
            return questions.get(2).getQuestion();
        }
        else if(index == 3){
            return questions.get(3).getQuestion();
        }
        else if(index == 4){
            return questions.get(4).getQuestion();
        }
        return "";
    }

    //should increment the score and the current question number
    public void scoreAnswer(){
    numcorrect+=1;
        index++;
    }
}

