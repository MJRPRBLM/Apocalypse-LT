package com.example;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    // This will be the list storing all questions in circulation, so that the user can answer all questions without repeating or keep questions in circulation after answering them. This is in app so that both controllers can access it, and so that it won't be reset when switching between scenes.
    // These are not populated here, they are populated in the FrontPageController when they hit the begin button so that the user can select their preferred lessons
    private static ArrayList<String> availableQuestions;
    private static ArrayList<String> remainingAnswers;

    @Override
    public void init() throws IOException {
        availableQuestions = new ArrayList<>();
        remainingAnswers = new ArrayList<>();
    }

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("frontPage"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }
    
    public static ArrayList<String> getQuestions() {
        return availableQuestions;
    }

    public static ArrayList<String> getAnswers() {
        return remainingAnswers;
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

    public static void showResult(
        String question,
        String enteredAnswer,
        String correctAnswer,
        boolean correct,
        int selectedQuestionIndex
    ) throws IOException {
        FXMLLoader loader = new FXMLLoader(
            App.class.getResource("result.fxml")
        );

        Parent resultPage = loader.load();

        ResultController controller = loader.getController();

        controller.setResult(
            question,
            enteredAnswer,
            correctAnswer,
            correct,
            selectedQuestionIndex
        );

        scene.setRoot(resultPage);
    }
}