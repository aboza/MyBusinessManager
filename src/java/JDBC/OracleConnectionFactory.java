/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC;

import java.sql.*;
import Utils.Constants;


/**
 *
 * @author AlexisDev
 */
public class OracleConnectionFactory {
    private String DBpassword = Constants.ORACLE_PDB_PASSWORD;
    private String DBuser = Constants.ORACLE_PDB_USER;
    private String dataBaseName = Constants.ORACLE_PDB_SID;
    private final String serverInstance;
    private Connection connection=null;

    public OracleConnectionFactory() {
        this.serverInstance = Constants.ORACLE_SERVER_INSTANCE + dataBaseName;
        
        try{
         //obtenemos el driver de ORACLE
         Class.forName(Constants.ORACLE_DRIVER);
         //obtenemos la conexión
         connection = DriverManager.getConnection(serverInstance,DBuser,DBpassword);
         if (connection!=null){
            System.out.println("Conexión a base de datos "+dataBaseName+" OK");
         }
      }catch(  SQLException | ClassNotFoundException e){
         System.out.println(e);
      }
    }

    public String getDBpassword() {
        return DBpassword;
    }

    public void setDBpassword(String DBpassword) {
        this.DBpassword = DBpassword;
    }

    public String getDBuser() {
        return DBuser;
    }

    public void setDBuser(String DBuser) {
        this.DBuser = DBuser;
    }

    public String getDataBaseName() {
        return dataBaseName;
    }

    public void setDataBaseName(String dataBaseName) {
        this.dataBaseName = dataBaseName;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
     /**
     * Cierra la conexion con la base de datos en caso de estar abierta.
     * @throws SQLException 
     */
    public void closeConnection() throws SQLException
    {
        if(connection != null)
            connection.close();
    }
    
    
    
    
    
}
