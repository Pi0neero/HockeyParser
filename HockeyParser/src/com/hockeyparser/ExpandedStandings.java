package com.hockeyparser;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;

public class ExpandedStandings{
    private HashMap<String, Team> teams;
    private List<Team> listOfTeams;

    public ExpandedStandings() {
        teams = new HashMap<>();
        listOfTeams = new ArrayList<>();
    }

    public Team getTeam(String teamName){ return teams.get(teamName);}
    public List<Team> getListOfTeams(){ return listOfTeams;}

    public void addTeam(String teamName, Team team){
        teams.put(teamName, team);
        listOfTeams.add(team);
    }

    @Override
    public String toString() {
        Formatter formatter = new Formatter();
        String display = "";
        display += formatter.format("%s%15s%19s%10s%10s%10s%10s%10s%10s%10s%10s%10s%10s%10s%10s%10s%10s%10s%10s",
                "RK", "Team", "Overall", "Home", "Road", "EAS", "WES", "ATL", "MET", "CEN", "<=1", ">=3",
                "Oct", "Nov", "Dec", "Jan", "Feb", "Mar", "Apr").toString();

        for (int i = 0; i < listOfTeams.size(); i++) {
            formatter = new Formatter();
            Team t = listOfTeams.get(i);
            display += formatter.format("\n%2s%23s%11s%10s%10s%10s%10s%10s%10s%10s%10s%10s%10s%10s%10s%10s%10s%10s%10s",
                    t.getRank(), t.getName(), t.getOverallRecord(), t.getHomeRecord(), t.getAwayRecord(), t.getEastRecord(),
                    t.getWestRecord(), t.getAtlanticRecord(), t.getMetroRecord(), t.getCentralRecord(), t.getOneOrFewerGoalsRecord(),
                    t.getThreeOrMoreGoalsRecord(), t.getMonthRecord("Oct"), t.getMonthRecord("Nov"), t.getMonthRecord("Dec"),
                    t.getMonthRecord("Jan"), t.getMonthRecord("Feb"), t.getMonthRecord("Mar"), t.getMonthRecord("Apr")).toString();

        }
        return display;
    }
}
