import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class BuildDataArrays {

    private List<String> userInfo;
    private List<String> productInfo;
    private List<String> bookInfo;

    public BuildDataArrays()
    {
        this.setUserInfo();
        this.setproductInfo();
        this.setBookInfo();
    }
    public void setUserInfo(){
        this.userInfo = this.readFromUsers();
    }
    public List<String> getUserInfo(){
        return userInfo;
    }

    public void setproductInfo(){
        this.productInfo = this.readFromProducts();
    }
    public List<String> getproductInfo(){
        return productInfo;
    }

    public void setBookInfo(){
        this.bookInfo = this.readFromBooks();
    }
    public List<String> getBookInfo(){
        return bookInfo;
    }

    public List readFromUsers()
    {
        URL userFile = this.getClass().getResource("user_info.csv");
        File pathToUsers = new File(userFile.getFile());
        String userRow;
        List<String> users = new ArrayList<>();

        try {

            BufferedReader csvReader = new BufferedReader(new FileReader(pathToUsers));
            while ((userRow = csvReader.readLine()) != null) {
                users.add(userRow);

            }
            csvReader.close();
        } catch (Exception e) {
            System.out.println("The specified file does not exist. Requested file: " + pathToUsers);
        }
        return users;
    }

    public List readFromBooks()
    {
        URL bookFile = this.getClass().getResource("book_info.csv");
        File pathToBooks = new File(bookFile.getFile());
        String bookRow;
        List<String> books = new ArrayList<>();

        try {

            BufferedReader csvReader = new BufferedReader(new FileReader(pathToBooks));
            while ((bookRow = csvReader.readLine()) != null) {
                books.add(bookRow);

            }
            csvReader.close();
        } catch (Exception e) {
            System.out.println("The specified file does not exist. Requested file: " + pathToBooks);
        }
        return books;
    }

    public List readFromProducts()
    {
        URL productFile = this.getClass().getResource("product_info.csv");
        File pathToProducts = new File(productFile.getFile());
        String productRow;
        List<String> products = new ArrayList<>();

        try {

            BufferedReader csvReader = new BufferedReader(new FileReader(pathToProducts));
            while ((productRow = csvReader.readLine()) != null) {
                products.add(productRow);

            }
            csvReader.close();
        } catch (Exception e) {
            System.out.println("The specified file does not exist. Requested file: " + pathToProducts);
        }
        return products;
    }
}
