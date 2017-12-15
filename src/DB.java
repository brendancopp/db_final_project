import java.util.ArrayList;

/**
 * Created by brendan on 12/5/2017.
 */
public class DB{

    public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://localhost/cpsc_408";

    public static final String[] POSITIONS = {"QB", "RB2", "WR1", "WR2", "FLEX", "TE", "DST", "K"};


    public class PLAYER{
        public static final String TABLE = "player";


        public class ATT{
            public static final String ID = "id";
            public static final String NAME = "name";
            public static final String POSITION = "position";


        }
    }
}
