package com.nextgen.medpro.controller;

import com.nextgen.medpro.db.Database;
import com.nextgen.medpro.dot.DoctorDto;
import com.nextgen.medpro.util.Cookie;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;

public class DoctorDashboardFormController {
    public AnchorPane doctorDashboardContext;
    public Label lblDate;
    public Label lblTime;

    public void initialize() throws IOException{
        initializeDate();
        checkDoctorDate();
    }
    private void initializeDate() {
        lblDate.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(0),
                        e -> {
                            DateTimeFormatter dtf = DateTimeFormatter
                                    .ofPattern("hh:mm:ss");
                            lblTime.setText(LocalTime.now().format(dtf));
                        }
        ),
                new KeyFrame(Duration.seconds(1))
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }




    private void checkDoctorDate() {
        Optional<DoctorDto> selectedDoctor =
                Database.doctorTable.stream()
                        .filter(e -> e.getEmail().equals("p@.com"))
                        .findFirst();
        if (!selectedDoctor.isPresent()) {
            Stage stage = new Stage();
            try {
                stage.setScene(new Scene(FXMLLoader.
                        load(getClass().getResource("../view/DoctorRegistrationForm.fxml"))));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage.centerOnScreen();
            stage.show();
        }

    }
    public void checkUser() throws IOException{
        if (null== Cookie.selectedUser){
            setui("LoginForm");
        }
    }

    public void logoutOnAction(ActionEvent actionEvent) throws IOException {
        setui("LoginForm");
    }
    private void setui(String location) throws IOException {
        Stage stage = (Stage) doctorDashboardContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
        stage.centerOnScreen();
    }



    public void navigateToPatientAppointmentPage(ActionEvent actionEvent) throws IOException {
        setui("AppointmentsForm");
    }

    public void navigateToPatientManagementPage(ActionEvent actionEvent) throws IOException {
        setui("PatientManagementForm");
    }
}
