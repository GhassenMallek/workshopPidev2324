package controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import models.User;
import services.UserService;

import java.sql.SQLException;

public class addUser {

    private final UserService us = new UserService();
    @FXML
    private TextField ageTF;

    @FXML
    private TextField nameTF;

    @FXML
    void addUser(ActionEvent event) throws SQLException {

        if(nameTF.getText().isEmpty())
        {
            System.out.println("name is empty");
        }
            else {
            us.add(new User(Integer.parseInt(ageTF.getText()), nameTF.getText()));
        }
    }
}
