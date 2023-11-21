package ro.uvt.info.testsp.Strategy;

import ro.uvt.info.testsp.Classes.Message;

public class HouseAtreides implements House {
    public String decode(Message m) {
        String decoded = "";
        String message = m.getMessage();
        for (int i = 0; i < message.length(); i++)
            decoded += (char)(message.charAt(i) + 3);

        return decoded;
    }
}
