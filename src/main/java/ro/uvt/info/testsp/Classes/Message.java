package ro.uvt.info.testsp.Classes;

import lombok.Getter;
import ro.uvt.info.testsp.Strategy.House;
import ro.uvt.info.testsp.Strategy.HouseAtreides;
import ro.uvt.info.testsp.Strategy.HouseHarkonnen;
import ro.uvt.info.testsp.Visitor.Visitee;
import ro.uvt.info.testsp.Visitor.Visitor;

@Getter
public class Message extends Element implements Visitee {
    String message;
    House house;
    String date;

    public Message(String message, String date, String house) {
        this.message = message;
        this.date = date;

        if (house.equals("atreides"))
            this.house = new HouseAtreides();
        else this.house = new HouseHarkonnen();
    }

    public String DecodeMessage() {
        if (house == null)
            return "error: house not set";

        return house.decode(this);
    }

    public void accept(Visitor v) {
        v.visitMessage(this);
    }
}
