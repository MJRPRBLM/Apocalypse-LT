package com.example;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PrimaryController {
    
    @FXML
    private TextField answerBar;

    @FXML 
    private Label questionLabel;
    
    public List<String> answers;
    public List<String> questions;

    // A random question and its corresponding answer will be selected in initialize and stored in these variables
    private String selectedQuestion;
    private String selectedAnswer;
    private int randomInt;

    @FXML 
    private void initialize() throws IOException {
        
        questions = App.getQuestions();
        answers = App.getAnswers();

        // A random question and its corresponding answer are selected
        randomInt = new Random().nextInt(questions.size());
        selectedQuestion = questions.get(randomInt);
        selectedAnswer = answers.get(randomInt);

        // display the selected question
        questionLabel.setText(selectedQuestion);
    }

    @FXML
    private void handleEnter() throws IOException {
        App.setRoot("result");
        String answer = answerBar.getText().trim();
        System.out.print(answer);
        App.showResult(
            selectedQuestion,
            answer,
            selectedAnswer,
            answer.equals(selectedAnswer),
            randomInt
        );
        
        if (selectedAnswer.equals(answer)) {
            System.out.println("  is Correct");
        }
        else {
            System.out.println(" is Incorrect");
        }
    }
}
