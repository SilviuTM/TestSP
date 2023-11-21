package ro.uvt.info.testsp.Visitor;

import ro.uvt.info.testsp.Classes.Message;

public class MessagePrinterVisitor implements Visitor<Void> {
    public Void visitMessage(Message m) {
        System.out.println("At: " + m.getDate());
        System.out.println("Message: " + m.DecodeMessage());
        System.out.println("House: " + m.getHouse().getClass().getSimpleName());
        System.out.println("---");

        return null;
    }
}
