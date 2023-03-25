package com.nextgen.medpro.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

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
    public JFXButton txtBack;

    public void signUpOnAction(ActionEvent actionEvent) throws IOException {
            setui("DoctorDashboardForm");
    }

    public void backOnAction(ActionEvent actionEvent) throws IOException {
        setui("LoginForm");
    }
    private void setui(String location) throws IOException {
        Stage stage =(Stage) doctorRegistrationContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.
                load(getClass().getResource("../view/"+location+".fxml"))));
        stage.centerOnScreen();


}
}

