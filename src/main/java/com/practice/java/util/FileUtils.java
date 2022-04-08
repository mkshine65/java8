package com.practice.java.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class FileUtils {

    public static Map<String,String> loadMap(String path)
    {
        Properties props=new Properties();

        try
        {
            InputStream in=new FileInputStream("src/main/resources/"+path);
            if(path.endsWith(".xml"))
                props.loadFromXML(in);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (InvalidPropertiesFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String,String> mp=new LinkedHashMap<>();
        for (String key: props.stringPropertyNames())
            mp.put(key,props.getProperty(key));

        return Collections.unmodifiableMap(mp);
    }
}
