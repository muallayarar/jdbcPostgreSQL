
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Dbwork {

    //making the connection of our application with PostgreSQL
    public Connection connect_to_db(String dbname, String user, String pass){

        //making the object of Connection
        Connection conn = null;

        try{
            //load postgreSQL driver
            Class.forName("org.postgresql.Driver");
            //setting up the connection
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+dbname,user,pass);
            //passing condition to check the connection is successful or not
            if(conn != null){
                System.out.println("Connection established!");
            }else{
                System.out.println("Connection Failed");
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return conn;
    }
    //method for creating a new table
    public void createTable(Connection conn, String table_name){
        //make an object of Statement
        Statement statement;
        try{
            String query = "create table "+table_name+"(empId SERIAL, name varchar(200), email varchar(200), country varchar(200), age integer, salary integer, primary key(empId))";            //create a statement
            statement = conn.createStatement();
            //executing our query by putting it into statement
            statement.executeUpdate(query);
            System.out.println("Table created!");
        }catch(Exception e){
            System.out.println(e);
        }
    }

    //method for inserting data into our table columns
    public void insert_data(Connection conn, String table_name, String name, String email, String country,int age, int salary){

        //make an object of Statement
        Statement statement;
        try{
            String  query = String.format("insert into %s(name,email,country) values('%s','%s','%s','&i','&i')", table_name,name,email,country,age,salary);

            //create a statement
            statement = conn.createStatement();

            //executing our query by putting it into statement
            statement.executeUpdate(query);
            System.out.println("Data has been inserted successfully!");
        }catch(Exception e){
            System.out.println(e);
        }
    }

}
