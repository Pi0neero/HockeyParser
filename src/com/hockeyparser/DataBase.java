package com.hockeyparser;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class DataBase {
    private LinkedHashMap<String, Player> data;

    public DataBase(){
        data = new LinkedHashMap<>();
    }

    public void addPlayer(Player p){
        data.put(p.getStat("Player").getValue(), p);
    }

    public void addPlayer(String nameOfPlayer, Player p){
        data.put(nameOfPlayer, p);
    }

    public Player getPlayer(String nameOfPlayer){
        return data.get(nameOfPlayer);
    }

    public void removePlayer(String nameOfPlayer){data.remove(nameOfPlayer);}

    public Set<String> keySet(){
        return data.keySet();
    }

    public Set<String> getStats(){
        return data.get("Spencer Abbott").getStats();
    }

    @Override
    public String toString() {
        return "\n" + data;
    }
}
