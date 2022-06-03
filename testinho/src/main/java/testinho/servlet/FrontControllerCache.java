package testinho.servlet;

import java.util.HashMap;
import java.util.Map;

public class FrontControllerCache {

    public String commandCacheController(String type){
        Map<String, String> myMap = new HashMap<>();
        myMap.put("ShowProduct", "testinho.controller.ShowProductCommand");
        return myMap.get(type);
    }
}
