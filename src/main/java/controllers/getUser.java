package controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import services.UserService;

import java.sql.SQLException;


public class getUser {

    private final UserService us = new UserService();

    @FXML
    private Label user;


    @FXML
    void afficher(ActionEvent event) throws SQLException {
        //code
        String users = us.getAll().toString();
        user.setText(users);

    }





}
