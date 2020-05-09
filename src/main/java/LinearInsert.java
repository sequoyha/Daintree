import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.*;

import java.util.List;
import java.util.UUID;

public class LinearInsert {

    protected void InsertUsers(CqlSession session, List<String> userList) {

        try {
            PreparedStatement userPrepared = session.prepare("INSERT INTO daintree.users(user_id, username, " +
                    "fname,  lname, address,city, state, postal_code, " +
                    "email, phone) VALUES (?,?,?,?,?,?,?,?,?,?)");
            int index = 0;
            while(index < userList.size())
            {
                String row = userList.get(index);
                String[] userData = row.split(",");
                BoundStatement userDatabound = userPrepared.bind(UUID.randomUUID(),userData[0],userData[1]
                        ,userData[2],userData[3],userData[4],userData[5],userData[6],userData[7],userData[8]);
                session.execute(userDatabound);
                index++;
            }
            System.out.println(index + "inserts ran");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    protected void InsertBooks(CqlSession session, List<String> bookList) {

        try {
            PreparedStatement userPrepared = session.prepare("INSERT INTO daintree.products(product_id, isbn,  author, " +
                    "product_name,  category, publisher) VALUES (?,?,?,?,?,?)");
            int index = 0;
            while(index < bookList.size())
            {
                String row = bookList.get(index);
                String[] bookData = row.split(",");
                BoundStatement bookDatabound = userPrepared.bind(UUID.randomUUID(),bookData[0],bookData[1]
                        ,bookData[2],bookData[3],bookData[4]);
                session.execute(bookDatabound);
                index++;
            }
            System.out.println(index + "inserts ran");
        } catch (Exception e) {
            System.out.println(e.getMessage());//
        }
    }
}
