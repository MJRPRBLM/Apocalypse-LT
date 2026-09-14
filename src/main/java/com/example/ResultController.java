package com.example;

import java.io.IOException;
import java.util.ArrayList;

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

    private ArrayList<String> availableQuestions = App.getQuestions();
    private ArrayList<String> remainingAnswers = App.getAnswers();

    public void setResult(
            String question,
            String enteredAnswer,
            String correctAnswer,
            boolean correct,
            int selectedQuestionIndex
    ) {
        questionLabel.setText(question);
        answerLabel.setText("Your Answer: " + enteredAnswer);
        correctAnswerLabel.setText("Correct Answer: " + correctAnswer);
        if (correct) {
            resultLabel.setText("Correct!");
            availableQuestions.remove(selectedQuestionIndex);
            remainingAnswers.remove(selectedQuestionIndex);
        } else {
            resultLabel.setText("Incorrect, Question will re-enter the pool of questions for future attempts.");
        }
    }

    @FXML
    private void returnToPrimary() throws IOException {
        if (availableQuestions.isEmpty()) {
            App.setRoot("resetScreen");
        } else {
            questionLabel.setText("");
            answerLabel.setText("");
            correctAnswerLabel.setText("");
            resultLabel.setText("");
        }
        App.setRoot("primary");
    }
}
