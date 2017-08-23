package com.hockeyparser;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Sql {

    public static void createSqlFile(String fileName, DataBase db) throws IOException{
        Connection c;
        Statement stmt;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:" + fileName);
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sqlTable = "CREATE TABLE playerStats(";
            List<String> statNames = new ArrayList<>();
            statNames.addAll(db.getStats());
            //System.out.println(statNames);

            for(int i = 0; i < statNames.size(); i++){
                if (i+1 < statNames.size()){
                    sqlTable += "`" + statNames.get(i) + "`" + ",";
                }
                else{
                    sqlTable += "`" + statNames.get(i) + "`";
                }

            }
            sqlTable += ")";

            String sqlTable2 = "CREATE TABLE `playerStats` (\n" +
                    "\t`Rk`\tINTEGER,\n" +
                    "\t`Player`\tTEXT,\n" +
                    "\t`Age`\tINTEGER,\n" +
                    "\t`Pos`\tTEXT,\n" +
                    "\t`Tm`\tTEXT,\n" +
                    "\t`GP`\tINTEGER,\n" +
                    "\t`G`\tINTEGER,\n" +
                    "\t`A`\tINTEGER,\n" +
                    "\t`PTS`\tINTEGER,\n" +
                    "\t`+/-`\tINTEGER,\n" +
                    "\t`PIM`\tINTEGER,\n" +
                    "\t`PS`\tINTEGER,\n" +
                    "\t`EV`\tINTEGER,\n" +
                    "\t`PP`\tINTEGER,\n" +
                    "\t`SH`\tINTEGER,\n" +
                    "\t`GW`\tINTEGER,\n" +
                    "\t`S`\tINTEGER,\n" +
                    "\t`S%`\tREAL,\n" +
                    "\t`TOI`\tINTEGER,\n" +
                    "\t`ATOI`\tINTEGER,\n" +
                    "\t`BLK`\tINTEGER,\n" +
                    "\t`HIT`\tINTEGER,\n" +
                    "\t`FOW`\tINTEGER,\n" +
                    "\t`FOL`\tINTEGER,\n" +
                    "\t`FO%`\tREAL,\n" +
                    "\t`CF`\tINTEGER,\n" +
                    "\t`CA`\tINTEGER,\n" +
                    "\t`CF%`\tREAL,\n" +
                    "\t`CF% rel`\tREAL,\n" +
                    "\t`FF`\tINTEGER,\n" +
                    "\t`FA`\tINTEGER,\n" +
                    "\t`FF%`\tREAL,\n" +
                    "\t`FF% rel`\tREAL,\n" +
                    "\t`oiSH%`\tREAL,\n" +
                    "\t`oiSV%`\tREAL,\n" +
                    "\t`PDO`\tINTEGER,\n" +
                    "\t`oZS%`\tREAL,\n" +
                    "\t`dZS%`\tREAL,\n" +
                    "\t`TOI/60`\tREAL,\n" +
                    "\t`TOI(EV)`\tINTEGER,\n" +
                    "\t`TK`\tINTEGER,\n" +
                    "\t`GV`\tINTEGER,\n" +
                    "\t`E+/-`\tINTEGER,\n" +
                    "\t`SAtt.`\tINTEGER,\n" +
                    "\t`Thru%`\tREAL\n" +
                    ");";

            stmt.executeUpdate(sqlTable2);

            String sqlInsert = "INSERT INTO playerStats VALUES (";
            for(int i = 0; i < statNames.size(); i++){
                if (i+1 < statNames.size()){
                    sqlInsert += "?, ";
                }
                else{
                    sqlInsert += "?";
                }
            }
            sqlInsert += ")";

            //System.out.println(sqlInsert);
            PreparedStatement prestmt = c.prepareStatement(sqlInsert);

            for(String playerName: db.keySet()){

                int index = 1;
                Player p = db.getPlayer(playerName);

                for(String statName: p.getStats()){
                    if(p.getStat(statName).getValue().equals("")){
                        prestmt.setObject(index, "0");
                    }
                    else{
                        prestmt.setObject(index, p.getStat(statName).getValue());
                    }

                    //System.out.println(index + ": " + p.getStat(statName).getValue());
                    index++;

                }
                prestmt.executeUpdate();


            }


            stmt.close();
            prestmt.close();
            c.commit();
            c.close();

        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Records created successfully");
    }
}
