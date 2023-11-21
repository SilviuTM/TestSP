package ro.uvt.info.testsp.Controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.uvt.info.testsp.Classes.Element;
import ro.uvt.info.testsp.Classes.Message;
import ro.uvt.info.testsp.Visitor.MessagePrinterVisitor;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/decoder")
public class Decoder {

    @GetMapping("/test")
    public ResponseEntity<?> getJson() throws MalformedURLException {
        ArrayList<HashMap<String, String>> mesaje = new ObjectMapper().readValue(new URL("file:src/messages.json"),
                new TypeReference<ArrayList<HashMap<String, String>>>(){});

        List<Element> messages = new ArrayList<>();
        for (HashMap<String, String> m : mesaje) {
            messages.add(new Message(m.get("message"), m.get("date"), m.get("house")));
        }

        MessagePrinterVisitor print = new MessagePrinterVisitor();
        for (Element m : messages) {
            m.accept(print);
        }

        return new ResponseEntity<>("", HttpStatus.OK);
    }
}
