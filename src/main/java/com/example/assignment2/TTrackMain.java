package com.example.assignment2;
//Nicholas Heleta, 11274059
import javafx.application.Application;
import javafx.scene.Scene;

import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class TTrackMain extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        //Set up MVC
        TTrackView tView = new TTrackView();
        TTrackModel model = new TTrackModel();
        TTrackController controller = new TTrackController();

        tView.setModel(model);
        tView.setController(controller);

        controller.setModel(model);
        model.addSubscriber(tView);

        StackPane root = new StackPane();
        root.getChildren().add(tView);

        Scene scene = new Scene(root);
        stage.setTitle("TTracker");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}