import com.datastax.oss.driver.api.core.CqlSession;

public class Inserts {

    public static void BuildCoreDataSet(CqlSession session)
    {
        BuildDataArrays buildDataArrays = new BuildDataArrays();
        LinearInsert linearInsert = new LinearInsert();

        long startTime = System.nanoTime();

        //linearInsert.InsertUsers(session, buildDataArrays.getUserInfo());
        linearInsert.InsertBooks(session, buildDataArrays.getBookInfo());
    }

}
