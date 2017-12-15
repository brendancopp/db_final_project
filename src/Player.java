import java.util.HashMap;

/**
 * Created by brendan on 11/27/2017.
 */
public class Player {

    //MAYBE change to DICTIONARY
    int mID;
    String mName;
    String mPosition;
    HashMap<String, String> mMapStats;

    //Creates bare-bones player
    public Player(int id, String name, String position){
        mID = id;
        mName = name;
        mPosition = position;
        mMapStats = new HashMap<String, String>();
    }

    public Player(HashMap<String, String> map){

        //Extracts most used attributes into member varibles
        if(map.containsKey(DB.PLAYER.ATT.ID)){
            mID = Integer.parseInt(map.remove(DB.PLAYER.ATT.ID));
        }
        else
            System.err.println("ERROR: Player initialized with id NULL.  tostr: " + this.toString());

        mName = map.remove(DB.PLAYER.ATT.NAME);
        mPosition = map.remove(DB.PLAYER.ATT.POSITION);

        //Keeps the rest of the traits in the hashmap
        mMapStats = map;
    }

    public String toString(){
        return ("" + mName + " : " + mPosition);
    }



}
