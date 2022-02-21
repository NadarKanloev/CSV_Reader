package com.company;

import java.util.Properties;

public class DBproperties {
    private static final String URL = "jdbc:postgresql://localhost:5432/csv.db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "lkm123";

    private static DBproperties INSTANSE;

    private String url;
    private String user;
    private String password;

    private void init(Properties properties){
        url = properties.getProperty(URL);
        user = properties.getProperty(USER);
        password = properties.getProperty(PASSWORD);
    }
    public String getUrl(){
        return url;
    }
}
