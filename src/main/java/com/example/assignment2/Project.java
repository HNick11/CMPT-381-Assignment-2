package com.example.assignment2;

public class Project {


    private String name;
    private int hours;
    private int minutes;
    private int seconds;

    public Project(String s){
        name = s;
        hours = 0;
        minutes = 0;
        seconds = 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getTime(){
        return hours+":"+minutes+":"+seconds;
    }

    public String toString(){
        return name+"   Time: "+getTime();
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public void setHours(int hours){
        this.hours = hours;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }
    public int getSeconds(){
        return seconds;
    }
}
