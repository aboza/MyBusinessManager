/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

/**
 *
 * @author AlexisDev
 */
public final class Constants {

    public static String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";
    public static String ORACLE_SERVER_INSTANCE = "jdbc:oracle:thin:@localhost:1521/";
    public static String ORACLE_PDB_SID = "pdborcl";
    public static String ORACLE_PDB_USER = "BusinessManager_DB";
    public static String ORACLE_PDB_PASSWORD = "ORCL1234";

    //queries
    //Oracle al parecer no puede hacer Procedures de SELECT -_-
    public static String ORACLE_GETCUSTOMERS = "SELECT CUSTOMER_ID ,NAME,COMPANY_NAME,"
            + "PHONE,FAX,EMAIL,BILL_TO,SHIP_TO,TERMS FROM BM_CUSTOMERS";
    public static String ORACLE_GETVENDORS = "SELECT VENDOR_ID,NAME,COMPANY_NAME,CONTACT,"
            + "VENDOR_TYPE,ADDRESS,PHONE,ALT_PHONE,FAX,EMAIL FROM BM_VENDORS";

}
