package Models;

import java.sql.*;
import java.sql.Connection;
import com.microsoft.sqlserver.jdbc.*;

public class ConexaoDb {
	public static Connection getConexao() {
        Connection conexao = null;
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=Calculadora;user=sa;password=123456";
        
        try 
        {
            conexao = DriverManager.getConnection(connectionUrl);
            return conexao;
        } 
        catch (Exception e) 
        {
        	System.out.println(e.getMessage());
            return null;            
        }
    }
}
