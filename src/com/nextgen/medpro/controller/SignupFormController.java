package com.nextgen.medpro.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;

public class SignupFormController {
    public AnchorPane signupContext;
    public JFXTextField txtFirstName;
    public JFXRadioButton rBtnDoctor;
    public JFXTextField txtLastName;
    public JFXTextField txtEmail;
    public JFXPasswordField txtPassword;

    public void signUpOnAction(ActionEvent actionEvent) {
    }

    public void alreadyHaveAnAccountOnAction(ActionEvent actionEvent) {
    }
}
