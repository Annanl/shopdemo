package com.dao.impl.constance;

import com.dao.SqlDao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class SqlDaoImpl implements SqlDao {

    //驱动程序名
    private static final String driver;
    //URL指向要访问的数据库名mydata
    private static final String url;
    //MySQL配置时的用户名
    private static final String user;
    //MySQL配置时的密码
    private static final String password;

    private static Connection con = null;

    static{
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream(SqlDaoImpl.class.getClassLoader().getResource("database.properties").getPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        url = prop.getProperty("db.url");
        user = prop.getProperty("db.user");
        password = prop.getProperty("db.password");
        driver = prop.getProperty("db.driver");
        //加载驱动程序
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("static块执行一次");
            
            con = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() {
        return con;
    }

}
