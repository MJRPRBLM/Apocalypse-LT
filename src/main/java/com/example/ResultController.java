package com.example;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ResultController {
    @FXML
    private Label questionLabel;

    @FXML
    private Label answerLabel;

    @FXML
    private Label resultLabel;

    @FXML
    private Label correctAnswerLabel;

    public void setResult(
            String question,
            String enteredAnswer,
            String correctAnswer,
            boolean correct
    ) {
        questionLabel.setText(question);
        answerLabel.setText("Your Answer: " + enteredAnswer);
        correctAnswerLabel.setText("Correct Answer: " + correctAnswer);
        if (correct) {
            resultLabel.setText("Correct!");
        } else {
            resultLabel.setText("Incorrect.");
        }
    }

    @FXML
    private void returnToPrimary() throws IOException {
        App.setRoot("primary");
    }
}
