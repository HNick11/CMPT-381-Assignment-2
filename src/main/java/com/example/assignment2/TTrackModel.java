package com.example.assignment2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class TTrackModel {


    ObservableList<String> Sprojects;
    private ArrayList<Project> projects;
    private Project current;
    ArrayList<TTrackModelSubscriber> subs;
    private int cur_index;

    private LocalDateTime start;
    private boolean timerrunning;

    public TTrackModel(){
        subs = new ArrayList<>();
        Sprojects = FXCollections.observableArrayList();
        projects = new ArrayList<>();
        timerrunning = false;
    }


    public void newproject(String s) {
        Project newentry = new Project(s);
        projects.add(newentry);
        Sprojects.add(newentry.toString());
    }

    public void swapProject(String name){
        boolean found = false;
        for(Project p: projects){
            if (name.equals(p.getName())){
                int index = Sprojects.indexOf(p.toString());
                current = projects.get(index);
                found = true;
                cur_index = index;
            }
        }

        if(!found){
            System.out.println("Error: project not found");
        }
        notifySubscribers();

    }

    public void start(){
        timerrunning = true;
        start = LocalDateTime.now();
    }

    public void stop(){

        LocalDateTime end;
        if(!timerrunning){
            return;
        }
        timerrunning = false;
        end = LocalDateTime.now();
        // grab the time in seconds
        int seconds = Math.toIntExact(Duration.between(start,end).toSeconds());
        int minutes = seconds/60;
        int hours = seconds/3600;

        if(minutes < 0){
            minutes = 0;
        }
        if(hours < 0){
            hours = 0;
        }

        current.setSeconds(current.getSeconds() + seconds);
        current.setMinutes(current.getMinutes() + minutes);
        current.setHours(current.getHours() + hours);

        Sprojects.set(cur_index,current.toString());


        notifySubscribers();
    }

    public String getCurrent(){
        return current.toString();
    }

    public void addSubscriber(TTrackModelSubscriber newSub){
        subs.add(newSub);
    }
    public void notifySubscribers(){
        subs.forEach(TTrackModelSubscriber::modelUpdated);
    }
}
