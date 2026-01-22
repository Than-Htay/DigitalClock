package org.example.com.digitalclock;



import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class HelloController {

    @FXML
    private Label clockLabel;


    private final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    public void initialize() {

        startClock();
    }

    private void startClock() {

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(1), event -> updateClock())
        );

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();


        updateClock();
    }

    private void updateClock() {

        LocalTime now = LocalTime.now();


        String formattedTime = now.format(timeFormatter);


        clockLabel.setText(formattedTime);
    }
}
