package com.example.assignment2;

import javafx.event.ActionEvent;

public class TTrackController {
    TTrackModel model;

    public TTrackController(){
    }

    public void setModel(TTrackModel model) {
        this.model = model;
    }

    public void addProject(String s){
        model.newproject(s);
    }

    public void swapProject(String s){model.swapProject(s);}

    public void startTimer(ActionEvent actionEvent){
        model.start();
    }

    public void stopTimer(ActionEvent actionEvent){
        model.stop();
    }
}
