package com.hockeyparser;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTable;
import com.gargoylesoftware.htmlunit.html.HtmlTableRow;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Parsing {

    public static DataBase buildPlayers() throws IOException {
        java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(java.util.logging.Level.OFF);

        WebClient webClient = new WebClient();
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);

        DataBase data = playerStatistics(webClient);
        advancedPlayerStatistics(webClient, data);
        data.removePlayer("Player");

        return data;
    }
    public static DataBase buildGoalies() throws IOException {
        java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(java.util.logging.Level.OFF);

        WebClient webClient = new WebClient();
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);

        DataBase data = goalieStatistics(webClient);
        data.removePlayer("Player");

        return data;
    }

    public static DataBase playerStatistics(WebClient webClient) throws IOException {

        HtmlPage page = webClient.getPage("https://www.hockey-reference.com/leagues/NHL_2017_skaters.html");

        HtmlTable htmlTable = page.querySelector("#stats");

        List namesOfStats = new ArrayList();
        HtmlTableRow statsNameRow = htmlTable.getRow(1);

        for (int i = 0; i < statsNameRow.getCells().size(); i++) {
            namesOfStats.add(statsNameRow.getCell(i).asText());
        }

        DataBase playerDataBase = new DataBase();

        for (int j = 2; j < htmlTable.getRowCount(); j++) {
            HtmlTableRow players = htmlTable.getRow(j);
            Player p = new Player();
            for (int i = 0; i < players.getCells().size(); i++) {
                Stat s = new Stat((String) namesOfStats.get(i), players.getCell(i).asText());
                p.addStat((String) namesOfStats.get(i), s);
            }
            playerDataBase.addPlayer(p);
        }
        return playerDataBase;
    }

    public static void advancedPlayerStatistics(WebClient webClient, DataBase db) throws IOException {

        HtmlPage page = webClient.getPage("https://www.hockey-reference.com/leagues/NHL_2017_skaters-advanced.html");

        HtmlTable htmlTable = page.querySelector("#stats_adv_rs");

        List<String> namesOfStats = new ArrayList();
        HtmlTableRow statsNameRow = htmlTable.getRow(1);

        for (int i = 0; i < statsNameRow.getCells().size(); i++) {
            namesOfStats.add(statsNameRow.getCell(i).asText());
        }

        DataBase playerDataBase = new DataBase();

        for (int j = 2; j < htmlTable.getRowCount(); j++) {
            HtmlTableRow players = htmlTable.getRow(j);
            Player p = new Player();
            for (int i = 0; i < players.getCells().size(); i++) {
                Stat s = new Stat((String) namesOfStats.get(i), players.getCell(i).asText());
                p.addStat((String) namesOfStats.get(i), s);

            }
            playerDataBase.addPlayer(p);

        }

        for (String playerName : db.keySet()) {
            Player p = db.getPlayer(playerName);
            for (String statName : namesOfStats) {
                p.addStat(statName, playerDataBase.getPlayer(playerName).getStat(statName));
            }

        }

    }
    public static DataBase goalieStatistics(WebClient webClient) throws IOException {

        HtmlPage page = webClient.getPage("https://www.hockey-reference.com/leagues/NHL_2017_goalies.html");

        HtmlTable htmlTable = page.querySelector("#stats");

        List namesOfStats = new ArrayList();
        HtmlTableRow statsNameRow = htmlTable.getRow(1);

        for (int i = 0; i < statsNameRow.getCells().size(); i++) {
            namesOfStats.add(statsNameRow.getCell(i).asText());
        }

        DataBase playerDataBase = new DataBase();

        for (int j = 2; j < htmlTable.getRowCount(); j++) {
            HtmlTableRow players = htmlTable.getRow(j);
            Player p = new Player();
            for (int i = 0; i < players.getCells().size(); i++) {
                Stat s = new Stat((String) namesOfStats.get(i), players.getCell(i).asText());
                p.addStat((String) namesOfStats.get(i), s);
            }
            playerDataBase.addPlayer(p);
        }
        return playerDataBase;
    }
}


