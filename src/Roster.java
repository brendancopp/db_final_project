import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by brendan on 12/4/2017.
 */
public class Roster {
    String mName;

    //QBid, RB1id, RB2id, WR1id, WR2id, FLEXid, TEid, DSTid, Kid
    HashMap<String, Player> mRoster;

    //New Roster
    public Roster(){
        //Query to find last roster id
        mRoster = new HashMap<String, Player>();

        //Else
        mRoster = new HashMap<String, Player>();
        mName = "MyRoster1";
    }

    //Roster
    public Roster(HashMap<String, Player> roster){
        //Query and populate roster find last roster id
        mRoster = roster;
        mName = "MyRoster1";
    }

    public void setRosterPlayer(Player player){
        mRoster.replace(player.mPosition, player);
    }

    public ArrayList<Player> getPlayersArrayList(){
        ArrayList<Player> playersArr = new ArrayList<Player>(mRoster.values());
        return playersArr;
    }

    public String toStringPlayer(){
        String str = "";
        for( String item : mRoster.keySet() ){
            str = str + item;
        }
        return str;
    }

    public String toString(){
        return mName;
    }

}
