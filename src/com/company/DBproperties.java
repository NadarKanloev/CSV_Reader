package com.company;

import java.util.Objects;
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
    public String getUser() { return user; }
    public String getPassword() {return  password; }
    public static DBproperties getProperties(){
        if(Objects.isNull(INSTANSE)){
            INSTANSE = new DBproperties();
            INSTANSE.init(ApplicationProperties.getInstance().getProperties());

        }
        return INSTANSE;
    }
}
