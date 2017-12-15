import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * Created by brendan on 11/26/2017.
 */
public class User {
    private String mName;
    private Roster mRosters[];


    public class Roster {
        //Roster(FTid, week, QBid, RB1id, RB2id, WR1id, WR2id, FLEXid, TEid, DSTid, Kid
        HashMap<String, Player> playerMap = new HashMap<String, Player>();

        public void setPlayer(String roster_position, Player player){
            playerMap.put(roster_position, player);
        }


    }
}


