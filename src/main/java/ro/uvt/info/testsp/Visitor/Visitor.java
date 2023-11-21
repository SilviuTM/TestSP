package ro.uvt.info.testsp.Visitor;

import ro.uvt.info.testsp.Classes.Message;

public interface Visitor<T> {
    public T visitMessage(Message m);
}
