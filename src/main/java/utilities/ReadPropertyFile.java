package utilities;

import constants.FrameworkConstants;
import enums.BaseConfig;
import exceptions.FileException;
import exceptions.PropertyFileReadException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ReadPropertyFile {
    private ReadPropertyFile(){};
    private static Map<String,String> MAP = new HashMap<>();
    private static Properties properties = new Properties();

    static {

        try(FileInputStream file = new FileInputStream(FrameworkConstants.getBASECONFIGFILEPATH())){
            properties.load(file);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(0);
            //throw new PropertyFileReadException("unable to read property file");
        } catch (IOException e){
            e.printStackTrace();
            System.exit(0);
            //throw new FileException("Unable to read Property file");
        }

        properties.entrySet().forEach(e->MAP.put(e.getKey().toString(),e.getValue().toString()));

    }

    public static String getPropertyValue(BaseConfig key){
        return MAP.get(key.toString().toLowerCase());
    }



}
