package ro.uvt.info.testsp;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ro.uvt.info.testsp.Classes.Element;
import ro.uvt.info.testsp.Classes.Message;
import ro.uvt.info.testsp.Visitor.MessagePrinterVisitor;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SpringBootApplication
public class TestSpApplication {
	public static void main(String[] args) throws IOException {
		SpringApplication.run(TestSpApplication.class, args);

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
	}
}
