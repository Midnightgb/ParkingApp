package parkingapp;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    String apiHost;
    String ip_v4;

    public Config() {
        try {
            Properties prop = new Properties();
            InputStream input = getClass().getResourceAsStream("/parkingapp/raw/config.properties");

            if (input == null) {
                System.out.println("No se pudo cargar el archivo config.properties");
                return;
            }

            System.out.println("Input: " + input);
            prop.load(input);
            this.apiHost = prop.getProperty("api_host");
            this.ip_v4 = prop.getProperty("ip_v4");
            System.out.println("API Host: " + this.apiHost);
            System.out.println("IP V4: " + this.ip_v4);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getEndPoint(String endpoint){
        endpoint = endpoint.replaceFirst("/", "");
        return apiHost+"/"+endpoint;
    }

    public String getIpV4(){
        return ip_v4;
    }
}
