package com.example;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;

public class FrontPageController {

    

    @FXML
    private CheckBox greetingsLessonCB;

    @FXML
    private CheckBox introductionsLessonCB;
    
    @FXML
    private void beginLessons() throws IOException {
        if (greetingsLessonCB.isSelected()) {
            try {
                App.getQuestions().addAll(Arrays.asList(Files.readString(java.nio.file.Paths.get("src/main/resources/lessons/greetingQ.txt")).trim().split("\\R")));
            } catch (IOException e) {
                throw new IllegalStateException("Unable to read questions file", e);
            }
            try {
                App.getAnswers().addAll((Arrays.asList(Files.readString(java.nio.file.Paths.get("src/main/resources/lessons/greetingA.txt")).trim().split("\\R"))));
            } catch (IOException e) {
                throw new IllegalStateException("Unable to read answers file", e);
            }
        }
        if (introductionsLessonCB.isSelected()) {
            try {
                App.getQuestions().addAll(Arrays.asList(Files.readString(java.nio.file.Paths.get("src/main/resources/lessons/introductionsQ.txt")).trim().split("\\R")));
            } catch (IOException e) {
                throw new IllegalStateException("Unable to read questions file", e);
            }
            try {
                App.getAnswers().addAll((Arrays.asList(Files.readString(java.nio.file.Paths.get("src/main/resources/lessons/introductionsA.txt")).trim().split("\\R"))));
            } catch (IOException e) {
                throw new IllegalStateException("Unable to read answers file", e);
            }
        }
        
        App.setRoot("primary");
    }
}

