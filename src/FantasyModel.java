import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by brendan on 11/27/2017.
 */
public class FantasyModel {
    protected QueryInterface mQI;
    private HashMap<String, Roster> mapAllRosters;

    //Singleton
    public static FantasyModel mFantasyModel;

    public static FantasyModel getFantasyModel(){
        if (mFantasyModel == null){
            mFantasyModel = new FantasyModel();
            return mFantasyModel;
        }
        else
            return mFantasyModel;
    }

    private FantasyModel(){
        mQI = QueryInterface.getQueryInterface();
        mapAllRosters = new HashMap<String, Roster>();

        ArrayList<String> rosterIds = mQI.getRosters();

        for(String id : rosterIds){
            mapAllRosters.put(id, )
        }

        //----------Make FAKE Roster--------
        //Roster fakeRoster = new Roster(mQI.getFakeRoster());
        //mapAllRosters.put(fakeRoster.mName, fakeRoster);
        //----------------------------------
    }

    //==== Only use FantasyModel to store mutable data ====
    public ArrayList<Player> getRosterPlayers(String rosterName){
        return mapAllRosters.get(rosterName).getPlayersArrayList();
    }


    public void removeRoster(Roster roster){
        mapAllRosters.remove(roster.mName);

        //TODO: delete from database
    }

    public void addRoster(Roster roster){
        mapAllRosters.put(roster.mName, roster);

        //TODO: add to database
    }


    public ArrayList<String> getAllRosterNames(){
        ArrayList<String> outArray = new ArrayList<String>();

        for(String key:mapAllRosters.keySet()){
            outArray.add(mapAllRosters.get(key).mName);
        }

        return outArray;
    }

    public ArrayList<Roster> getAllRosters(){
        ArrayList<Roster> outArray = new ArrayList<Roster>();

        for(String key:mapAllRosters.keySet()){
            outArray.add(mapAllRosters.get(key));
        }

        return outArray;
    }

    public void setRosterPlayer(String rosterName, Player player){
        //Write to database, update current roster model
        mapAllRosters.get(rosterName).setRosterPlayer(player);

    }
}
