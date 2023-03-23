package com.nextgen.medpro.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import com.nextgen.medpro.dot.User;
import com.nextgen.medpro.enums.AccountType;
import com.nextgen.medpro.util.CrudUtil;
import com.nextgen.medpro.util.IdGenerator;
import com.nextgen.medpro.util.PasswordConfig;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class SignupFormController {
    public AnchorPane signupContext;
    public JFXTextField txtFirstName;
    public JFXRadioButton rBtnDoctor;
    public JFXTextField txtLastName;
    public JFXTextField txtEmail;
    public JFXPasswordField txtPassword;

    public void signUpOnAction(ActionEvent actionEvent) throws IOException {
        User user = new User(txtFirstName.getText(),
                txtLastName.getText(),
                txtEmail.getText().trim().toLowerCase(),
                new PasswordConfig().encrypt(txtPassword.getText()),
                rBtnDoctor.isSelected()? AccountType.DOCTOR:AccountType.PATIENT);

        try {
            boolean isSaved = CrudUtil.execute(
                    "INSERT INTO user VALUES (?,?,?,?,?,?)",
                    new IdGenerator().generateId(),
                    user.getFirstname(),
                    user.getLastname(),
                    user.getEmail(),
                    user.getPassword(),
                    user.getAccountType().name()
            );
            if (isSaved){
                new Alert(Alert.AlertType.CONFIRMATION,"Saved!");
                setui();
            }else {
                new Alert(Alert.AlertType.WARNING,"Try Again");
            }

        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }


    }

    public void alreadyHaveAnAccountOnAction(ActionEvent actionEvent) throws IOException {
        setui();
    }

    private void setui() throws IOException {
        Stage stage = (Stage) signupContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/Loginform.fxml"))));
        stage.centerOnScreen();
    }
}
