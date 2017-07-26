/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kiara
 */

import java.sql.*;
public class DBConnect 
{
       Connection conn;
       public DBConnect()
       {
         // load the driver
         try
         {
            Class.forName ("sun.jdbc.odbc.JdbcOdbcDriver");
            System.out.println("Driver successfully loaded");
         }
         catch (ClassNotFoundException c)
         {
            System.out.println("Unable to load database driver");
         }
      
         //connect to the database
         try
         {             
            conn = DriverManager.getConnection("jdbc:odbc:;Driver={Microsoft Access Driver (*.)};DBQ=PhotoVoteDB.mdb"); 
            System.out.println("Connection To  database successfully established");
         }  
             catch (Exception e)
            {
               System.out.println("Unable to connect to DB");
            }
 
    } //end connection
       
       public void updateTbl ( String sqlStmt ) throws SQLException
    {
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sqlStmt);
            stmt.close();
        }    
    }//updateTbl
    
        ResultSet queryTbl ( String sqlStmt ) throws SQLException
    {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sqlStmt);
        return rs;
    }//queryTbl
        ResultSet queryTbl2 ( String sqlStmt2 ) throws SQLException
    {
        Statement stmt2 = conn.createStatement();
        ResultSet rs2 = stmt2.executeQuery(sqlStmt2);
        return rs2;
    }//queryTbl2       

}

}
