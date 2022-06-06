package testinho.servlet;

import testinho.controller.FrontCommand;
import testinho.controller.ShowProductCommand;

import java.util.HashMap;
import java.util.Map;

public final class PageCommands {
    private static final Map<String, FrontCommand> COMMANDS = new HashMap<>();
    static {
        COMMANDS.put("ShowProduct", new ShowProductCommand());
    }
    public static FrontCommand get(String key) {
        return COMMANDS.get(key);
    }
}