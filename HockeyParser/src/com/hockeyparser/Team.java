package com.hockeyparser;

import java.util.HashMap;

public class Team {
    // Rank in standings for season
    private int rank;

    // Name of Hockey Team
    private String name;

    // Overall W-L-T/O record
    private String overallRecord;

    // W-L-T/O record in home games
    private String homeRecord;

    // W-L-T/O record in away games
    private String awayRecord;

    // W-L-T/O record versus Eastern Conference team
    private String eastRecord;

    // W-L-T/O record versus Western Conference team
    private String westRecord;

    // W-L-T/O record versus Atlantic Division teams
    private String atlanticRecord;

    // W-L-T/O record versus Metro Division teams
    private String metroRecord;

    // W-L-T/O record versus Central Division teams
    private String centralRecord;

    // W-L-T/O record versus Pacific Division teams
    private String pacificRecord;

    // W-L-T/O record in games decided by 1 or fewer goals
    private String oneOrFewerGoalsRecord;

    // W-L-T/O record in games decided by 3 or more goals
    private String threeOrMoreGoalsRecord;

    // W-L-T/O record for all months :
    // oct, nov, dec, jan, feb, mar, apr;
    private HashMap<String, String> monthRecords;

    public Team(int rank, String name) {
        this.rank = rank;
        this.name = name;
        monthRecords = new HashMap<>();
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOverallRecord() {
        return overallRecord;
    }

    public void setOverallRecord(String overallRecord) {
        this.overallRecord = overallRecord;
    }

    public String getHomeRecord() {
        return homeRecord;
    }

    public void setHomeRecord(String homeRecord) {
        this.homeRecord = homeRecord;
    }

    public String getAwayRecord() {
        return awayRecord;
    }

    public void setAwayRecord(String awayRecord) {
        this.awayRecord = awayRecord;
    }

    public String getEastRecord() {
        return eastRecord;
    }

    public void setEastRecord(String eastRecord) {
        this.eastRecord = eastRecord;
    }

    public String getWestRecord() {
        return westRecord;
    }

    public void setWestRecord(String westRecord) {
        this.westRecord = westRecord;
    }

    public String getAtlanticRecord() {
        return atlanticRecord;
    }

    public void setAtlanticRecord(String atlanticRecord) {
        this.atlanticRecord = atlanticRecord;
    }

    public String getMetroRecord() {
        return metroRecord;
    }

    public void setMetroRecord(String metroRecord) {
        this.metroRecord = metroRecord;
    }

    public String getCentralRecord() {
        return centralRecord;
    }

    public void setCentralRecord(String centralRecord) {
        this.centralRecord = centralRecord;
    }

    public String getPacificRecord() {
        return pacificRecord;
    }

    public void setPacificRecord(String pacificRecord) {
        this.pacificRecord = pacificRecord;
    }

    public String getOneOrFewerGoalsRecord() {
        return oneOrFewerGoalsRecord;
    }

    public void setOneOrFewerGoalsRecord(String oneOrFewerGoalsRecord) {
        this.oneOrFewerGoalsRecord = oneOrFewerGoalsRecord;
    }

    public String getThreeOrMoreGoalsRecord() {
        return threeOrMoreGoalsRecord;
    }

    public void setThreeOrMoreGoalsRecord(String threeOrMoreGoalsRecord) {
        this.threeOrMoreGoalsRecord = threeOrMoreGoalsRecord;
    }
    public void addMonthRecord(String month, String record){
        monthRecords.put(month, record);

    }
    public String getMonthRecord(String month){
       return  monthRecords.get(month);

    }

    @Override
    public String toString() {
        String str = "";
        str += (rank + " " + name + " " + overallRecord + " " + homeRecord);
        return str;

    }
}

