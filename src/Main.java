import java.sql.Connection;

public class Main {

    public static void main(String[] args) {
        //making an object of Dbwork class
        Dbwork db = new Dbwork();

        //calling the database connection function
        Connection conn=db.connect_to_db("techprojdbc","postgres","Crowded.94");

        //calling the method to make a new table
         //db.createTable(conn, "employee");

        //calling the method to insert the data into employee table
        db.insert_data(conn, "employee","Mualla","muallayarar@gmail.com","Turkey",20,200);

    }
}
