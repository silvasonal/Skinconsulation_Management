import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLCon {
    
    private Connection connection;
    private Statement statement;
    
    //----------------------------------------------------------------------------
    // Constructor - create the DB connection
    //----------------------------------------------------------------------------
    public SQLCon(){

        try{  
            //Class.forName("com.mysql.jdbc.Driver");  
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/SkinDB","root","");  
            statement = connection.createStatement();  
        
        }catch(Exception e){ 
            System.out.println(e);
        }  
    }  

    //----------------------------------------------------------------------------
    // Retrive Data from the databae
    //----------------------------------------------------------------------------
    public ResultSet GetData(String sqlquery){

        ResultSet resultset = null;

        try{
            resultset = statement.executeQuery(sqlquery);
        }catch(Exception e){ 
            System.out.println(e);
        }
        return resultset; 
    }  

    //----------------------------------------------------------------------------
    // Update databae (INSERT/UPDATE and DELETE)
    //----------------------------------------------------------------------------
    public Boolean UpdateData(String sqlquery){

        Boolean isUpdated = false;

        try{
            statement.executeUpdate(sqlquery);  
            connection.close();
            isUpdated = true;
        
        }catch(Exception e){ 
            System.out.println(e);
        }
        
        return isUpdated;
          
    }  
    
}
