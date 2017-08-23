package com.hockeyparser;

public class Main {

    public static void main(String[] args) throws Exception {
        DataBase db = Parsing.buildPlayers();
        Sql.createSqlFile("Player-DataBase.db", db);


    }
}
