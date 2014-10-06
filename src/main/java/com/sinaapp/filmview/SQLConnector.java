package com.sinaapp.filmview;

import com.alibaba.common.logging.Logger;
import com.alibaba.common.logging.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Author: fanshen.fs
 * version:1.0  14-10-6
 */
public class SQLConnector {

    private static final Logger logger = LoggerFactory.getLogger(SQLConnector.class);

    public static Connection getConnection(){
        Connection conn = null;

        String driver = "com.mysql.jdbc.Driver";

        String url = "jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_filmview";
        String user = "yoykwo0k5x";
        String password = "k2x0zyx4m31lwz1hjiylxyhjjm20h5mzlxmmlxh5";

//        String url = "jdbc:mysql://127.0.0.1:3306/filmInfoSystem";
//        String user = "root";
//        String password = "root";

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            logger.error("数据库连接失败:", e);
            e.printStackTrace();
        }
        return conn;
    }
}
