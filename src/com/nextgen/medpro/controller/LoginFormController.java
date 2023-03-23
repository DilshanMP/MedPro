package com.nextgen.medpro.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import com.nextgen.medpro.dot.User;
import com.nextgen.medpro.enums.AccountType;
import com.nextgen.medpro.util.Cookie;
import com.nextgen.medpro.util.CrudUtil;
import com.nextgen.medpro.util.PasswordConfig;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginFormController {
    public AnchorPane loginContext;
    public JFXTextField txtEmail;
    public JFXPasswordField txtPassword;
    public JFXRadioButton rBtnDoctor;


    public void signInOnAction(ActionEvent actionEvent) throws IOException {
        String email =txtEmail.getText();
        String password = txtPassword.getText();
        AccountType accountType =rBtnDoctor.isSelected()?AccountType.DOCTOR : AccountType.PATIENT;

        try {
            ResultSet resultSet = CrudUtil.execute("SELECT * FROM user WHERE email=? AND account_type=?",
                    email, accountType.name());
            if (resultSet.next()) {

                Cookie.selectedUser = new User(
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        "",
                        accountType
                );

                if (new PasswordConfig().decrypt(password, resultSet.getString("password"))) {
                    if (accountType.equals(AccountType.PATIENT)) {
                        ResultSet selectedPatientResult =
                                CrudUtil.execute("SELECT patient_id FROM patient WHERE email=?", email);
                        if (selectedPatientResult.next()) {
                           setUi("PatientDashboardForm");
                        } else {
                            setUi("PatientRegistrationForm");
                        }
                    } else {
                        ResultSet selectedDoctorResult =
                                CrudUtil.execute("SELECT doctor_id FROM doctor WHERE email=?", email);
                        if (selectedDoctorResult.next()) {
                            setUi("DoctorDashboardForm");
                        } else {
                            setUi("DoctorRegistrationForm");
                        }
                    }
                }
            } else {
                new Alert(Alert.AlertType.WARNING,
                        String.format("we can't find an email (%s)", email)).show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    public void createAnAccountOnAction(ActionEvent actionEvent) throws IOException {
       setUi("SignForm");
    }
    private void setUi(String location) throws IOException {
        Stage stage =(Stage) loginContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.
                load(getClass().getResource("../view/"+location+".fxml"))));
        stage.centerOnScreen();
    }
}
