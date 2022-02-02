package com.techgeeknext.examples.drools.domain;

import java.util.ArrayList;

public class FDRequest_V1 {

    private String preStatus ;
    private String actor;
    private String lastAction;
    private String nextStatus;
    private ArrayList<String> callsToAction = new ArrayList<String>();

    public FDRequest_V1(String preStatus, String lastAction) {
        this.preStatus = preStatus;
        this.lastAction = lastAction;
    }


    public FDRequest_V1(String preStatus,  String lastAction,String actor) {
        this.preStatus = preStatus;
        this.lastAction = lastAction;
        this.actor = actor;
    }

    public String getPreStatus() {
        return preStatus;
    }

    public void setPreStatus(String preStatus) {
        this.preStatus = preStatus;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getLastAction() {
        return lastAction;
    }

    public void setLastAction(String lastAction) {
        this.lastAction = lastAction;
    }

    public String getNextStatus() {
        return nextStatus;
    }

    public void setNextStatus(String nextStatus) {
        this.nextStatus = nextStatus;
    }

    public ArrayList<String> getCallsToAction() {
        return callsToAction;
    }

    public void setCallsToAction(ArrayList<String> callsToAction) {
        this.callsToAction = callsToAction;
    }
}
