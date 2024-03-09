package Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class readConfig {

    Properties p;
    public readConfig()
    {
        try {
            FileInputStream f = new FileInputStream("C:\\Users\\S-TECH\\IdeaProjects\\Maven\\untitled\\src\\main\\resources\\url.properties");
            p = new Properties();
            p.load(f);
        }catch (Exception e ){

            System.out.println("Exception is"+e.getMessage());
        }

    }
    public String getBrowserName(){
        String URL= p.getProperty("appurl");
        return URL;
    }
    public String getUsername(){
       String user=p.getProperty("username");
       return user;
    }
    public String getPassword(){
        String pass = p.getProperty("password");
        return pass;
    }
}
