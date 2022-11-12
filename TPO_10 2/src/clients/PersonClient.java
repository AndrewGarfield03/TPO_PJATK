package clients;

import services.FilterRequest;
import services.IStorePerson;
import services.Person;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class PersonClient {
    public  List<Person> person_list;

    public PersonClient(FilterRequest request) throws MalformedURLException {
        URL url = new URL("http://localhost:7779/ws/person?wsdl");
        QName qname = new QName("http://services/", "PersonImplementationService");
        Service service = Service.create(url, qname);  //Connecting to server
        IStorePerson person = service.getPort(IStorePerson.class);//interface specify the service endpoint that is supported by returned port
        person_list = person.filter1(request);
    }
}