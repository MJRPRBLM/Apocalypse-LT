package com.example;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
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

    @FXML 
    private void initialize() throws IOException {
        // getting the contents of both the answerKey and the questions file and storing them in lists
        try {
            answers = Arrays.asList(Files.readString(java.nio.file.Paths.get("src/main/resources/answerKey.txt")).trim().split("\\R"));
        } catch (IOException e) {
            throw new IllegalStateException("Unable to read answers file", e);
        }
        
        try {
            questions = Arrays.asList(Files.readString(java.nio.file.Paths.get("src/main/resources/questions.txt")).trim().split("\\R"));
        } catch (IOException e) {
            throw new IllegalStateException("Unable to read questions file", e);
        }

        // A random question and its corresponding answer are selected
        int randomInt = new Random().nextInt(questions.size());
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
            answer.equals(selectedAnswer)
        );
        if (selectedAnswer.equals(answer)) {
            System.out.println("  is Correct");
        }
        else {
            System.out.println(" is Incorrect");
        }
    }
}
