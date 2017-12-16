/**
 * Created by brendan on 11/27/2017.
 */
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Scanner;




public class QueryInterface {
    //Singleton Object
    private static QueryInterface mQI;

    private Connection mConn;
    private Statement mStmt;



    //Singleton Query
    public static QueryInterface getQueryInterface(){
        if (mQI == null){
            //mQI = new QueryInterface("user", "pwd");
            mQI = new QueryInterface();     //Fake DB
            return mQI;
        }
        else
            return mQI;
    }


    private QueryInterface(){

    }
    private QueryInterface(String user, String pwd) //throws Exception
    {

        //Java Database connection stuff
        final String JDBC_DRIVER = DB.JDBC_DRIVER;
        final String DB_URL = DB.DB_URL;

        final String USER = "root";   //final String USER = "root";
        final String PWD = "1234";     //final String PASS = "password";


        Connection conn = null;

        try {
            Class.forName(JDBC_DRIVER);

            System.out.println("Connecting to database...");
            mConn = DriverManager.getConnection(DB_URL, USER, PWD);
            mStmt = mConn.createStatement();

        }catch(Exception ex){
            //Do something
        }



    }

    public ArrayList<Player> getPlayerSet(String query)
    {
        ArrayList<Player> outPlayerList = new ArrayList<Player>();  //Returns this ArrayList
        try{
            //Executes statement and gets cursor
            mStmt.execute(query);
            ResultSet rs = mStmt.getResultSet();

            //Gathers metaData
            ResultSetMetaData rsmd = rs.getMetaData();
            int totalColumns = rsmd.getColumnCount();

            //Defines datastructures
            HashMap<String, String> playerMap;

            //Iterate Cursor
            while (rs.next()) {

                playerMap = new HashMap<String, String>();
                for(int i = 0; i < totalColumns; i++){
                    playerMap.put(rsmd.getColumnLabel(i), rs.getString(i));
                }

                //Leaves parsing the headers up to the player constructor
                outPlayerList.add(new Player(playerMap));
            }

            return outPlayerList;
        }
        catch(SQLException e) {
            System.out.println(e.toString());
        }

        return outPlayerList;
    }


    public ArrayList<Player> getPlayersByPositionWeek(String position, int week) {
        String query = String.format("CALL getPlayersByPositionWeek('%s',%s,%s)", position, week, 100);
        return getPlayerSet(query);
    }

    public ArrayList<Player> getPlayersByName(String name, int week) {
        String query = String.format("CALL getPlayersByName('%s',%s)", name, week);
        return getPlayerSet(query);
    }

    public ArrayList<Player> getRosterPlayers(String roster, int week) {
        String query = String.format("CALL getRosterPlayers('%s',%s)", roster, week);
        return getPlayerSet(query);
    }

    public ArrayList<Player> getBestTeamByWeek(int week) {
        String query = String.format("CALL getRosterPlayers(%s)",week);
        return getPlayerSet(query);
    }

    //===============DUMMY DATA===============
    public HashMap<String, Player> getFakeRoster(){
        HashMap<String, Player> outRoster = new HashMap<String, Player>();

        //QBid, RB1id, RB2id, WR1id, WR2id, FLEXid, TEid, DSTid, Kid
        outRoster.put("QB", new Player(1, "Dak Prescott", "QB"));
        outRoster.put("RB1", new Player(2, "Todd Gurley", "RB1"));
        outRoster.put("RB2", new Player(2, "Lesean McCoy", "RB2"));
        outRoster.put("WR1", new Player(3, "Stefon Diggs", "WR1"));
        outRoster.put("WR2", new Player(4, "Dez Bryant", "WR2"));
        outRoster.put("FLEX", new Player(5, "Jarvis Landry", "FLEX"));
        outRoster.put("TE", new Player(6, "Jason Witten", "TE"));
        outRoster.put("DST", new Player(7, "Steelers D/ST", "DST"));
        outRoster.put("K", new Player(8, "Will  Lutz", "K"));

        return outRoster;
    }

    public ArrayList<Player> getFakePlayers(){
        ArrayList<Player> outPlayers = new ArrayList<Player>();

        //QBid, RB1id, RB2id, WR1id, WR2id, FLEXid, TEid, DSTid, Kid
        outPlayers.add(new Player(9, "Alex Smith", "QB"));
        outPlayers.add(new Player(10, "Leonard Fournette", "RB"));
        outPlayers.add(new Player(11, "Le'Veon Bell", "RB"));
        outPlayers.add(new Player(12, "Antonio Brown", "WR1"));
        outPlayers.add(new Player(13, "Deandre Hopkins", "WR1"));
        outPlayers.add(new Player(14, "Ezekiel Elliott", "RB1"));

        return outPlayers;
    }
    //========================================



    public ArrayList<Player> getPlayersByPosition(String attribute) {

        ArrayList<Player> outPlayerList = new ArrayList<Player>();  //Returns this ArrayList

        //Formats String
        StringBuilder sbuf = new StringBuilder();
        Formatter fmt = new Formatter(sbuf);
        fmt.format("SELECT * FROM %s WHERE s% = s%", DB.PLAYER.TABLE, DB.PLAYER.ATT.POSITION, attribute);
        String query = sbuf.toString();

        try{
            //Executes statement and gets cursor
            mStmt.execute(query);
            ResultSet rs = mStmt.getResultSet();

            //Gathers metaData
            ResultSetMetaData rsmd = rs.getMetaData();
            int totalColumns = rsmd.getColumnCount();

            //Defines datastructures
            HashMap<String, String> playerMap;

            //Iterate Cursor
            while (rs.next()) {

                playerMap = new HashMap<String, String>();
                for(int i = 0; i < totalColumns; i++){
                    playerMap.put(rsmd.getColumnLabel(i), rs.getString(i));
                }

                //Leaves parsing the headers up to the player constructor
                outPlayerList.add(new Player(playerMap));
            }

            return outPlayerList;
        }
        catch(SQLException e) {
            System.out.println(e.toString());
        }

        return outPlayerList;
    }

    /*public Player[] getRoster(String user) {
        String query = "SELECT * FROM User";

    }

   public HashMap<String, String> getPlayerByAttribute(String selectAttributes, String value ) {
        String query = "SELECT";


        //SELECT Formatting
        //Populates the QUERY SELECT with column names from "columns"
        for(int index = 0; index < columns.length; index++){
            if((index + 1) >= columns.length){
                query.concat(" " + columns[index]);
            }
            else{
                query.concat(" " + columns[index] + ",");
            }
        }


    }*/



/*
    public ArrayList<Player> getAllPlayers() {
        String query = "SELECT * FROM Player";
        ArrayList<Player> players = new ArrayList<Player>();

        try{
            ResultSet rs = mStmt.executeQuery(query);
            while (rs.next()) {
                String player_id = rs.getString("player_id");
                String player_name = rs.getString("player_name");
                String player_position = rs.getString("player_position");
                //All Traits

                players.add(new Player(player_id, player_name, player_position));
            }
        }
        catch(SQLException ex){
            System.out.println(ex.getErrorCode());
        }

        return players;

    }
*/



/*
    public ArrayList<User> getAllPlayers()  {
        String query = "SELECT * FROM Player";
        ArrayList<User> users = new ArrayList<User>();

        //Queries for all users, and creates objects from them
        try{
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String user_id = rs.getString("user_id");
                String user_name = rs.getString("user_name");

                users.add(new User(user_id, user_name));
            }
        }
        catch(SQLException ex){
            System.out.println(ex.getErrorCode());
        }


        return users;
    }
*/

}
