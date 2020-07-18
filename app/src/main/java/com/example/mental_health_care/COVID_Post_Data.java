package com.example.mental_health_care;

import com.google.gson.annotations.SerializedName;

public class COVID_Post_Data {

    private String dateChecked;
    private int positiveIncrease;
    private int negativeIncrease;
    private int deathIncrease;
    private String state;
    private int positive;
    private int death;
    private int date;

    //if the variable is matched with name in json file no need to put @SerializedName here


    public String getDateChecked() {
        return dateChecked;
    }

    public int getPositiveIncrease() {
        return positiveIncrease;
    }

    public int getNegativeIncrease() {
        return negativeIncrease;
    }

    public int getDeathIncrease() {
        return deathIncrease;
    }

    public String getState() {
        return state;
    }

    public int getPositive() {
        return positive;
    }

    public int getDeath() { return death; }

    public int getDate() {
        return date;
    }
}
