package com.nextgen.medpro.controller;

import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;

public class DoctorRegistrationFormController {
    public AnchorPane doctorRegistrationContext;
    public JFXTextField txtFirstName;
    public JFXTextField txtLastName;
    public JFXTextField txtEmail;
    public JFXRadioButton rBtnMale;
    public JFXTextField txtNic;
    public JFXTextField txtContact;
    public JFXTextField txtSpecializations;
    public JFXTextArea txtAddress;

    public void signUpOnAction(ActionEvent actionEvent) {
    }
}
