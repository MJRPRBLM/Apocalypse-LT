package com.example;

import java.io.IOException;

import javafx.fxml.FXML;

public class ResetScreenController {
    @FXML
    private void returnToPrimary() throws IOException {
        App.setRoot("frontPage");
    }
}
