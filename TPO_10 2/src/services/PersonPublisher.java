package services;

import javax.xml.ws.Endpoint;
import java.util.List;

public class PersonPublisher {
    public void run(List<Person> persons){  //Service starting

        Endpoint.publish("http://localhost:7779/ws/person", new PersonImplementation(persons));//publish webservice ,start a service
    }
}