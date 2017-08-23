package com.hockeyparser;

import java.util.LinkedHashMap;
import java.util.Set;

public class Player {
    private LinkedHashMap<String, Stat> stats;

    public Player() {
        stats = new LinkedHashMap<>();
    }

    public void addStat(String name, Stat data){
        stats.put(name, data);
    }
    public Stat getStat(String name){
        return stats.get(name);
    }

    public Set<String> getStats(){
        return stats.keySet();
    }

    public String[] getName(){
        return stats.get("Player").getValue().split(" ");
    }

    @Override
    public String toString() {
        String str = "";
        for(String s: stats.keySet()){
            str += "\n" + stats.get(s).getName() + ": " + stats.get(s) + "\n";
        }
        return str;

    }
}
