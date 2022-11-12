package test;

import clients.PersonClient;
import org.junit.jupiter.api.Assertions;
import services.FilterRequest;
import services.Person;
import services.PersonPublisher;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class Testing {
    public List<Person> list;
    public PersonPublisher publisher;

    public Testing() {
        this.list = new ArrayList<>(); ///list of persons
        list.add(new Person("Alex", "Wilson","1999-01-23"));
        list.add(new Person("Anna", "Brown", "2000-09-12"));
        list.add(new Person("Ron", "Potter", "1999-01-23"));
        list.add(new Person("Harry", "Potter", "1989-11-21"));
        list.add(new Person("Lisa", "Huffman", "1960-11-22"));
        publisher = new PersonPublisher();
        publisher.run(list);  // run a Server
    }

    @Test
    public void filterBySurname() throws MalformedURLException {  // Test that filters by Surname
        FilterRequest request = new FilterRequest("Wilson", null);
        PersonClient client = new PersonClient(request);
        List<Person> myList = client.person_list;
        Assertions.assertNotNull(myList);  // Expecting not null objects
        Assertions.assertEquals(myList.size(), 1);  // Assertions  list contains only 1 record
        Assertions.assertEquals(myList.get(0).getFirstName(), "Alex"); //Contains  Name
        Assertions.assertEquals(myList.get(0).getSurname(), "Wilson");// Contains Surname
        Assertions.assertEquals(myList.get(0).getBirthDate(), "1999-01-23");// BirthDate
    }

    @Test
    public void filterBirthDate() throws MalformedURLException {  // Test that filters by Birth date
        FilterRequest request = new FilterRequest(null, "2000-09-12");
        PersonClient client = new PersonClient(request);// creating PersonClient instance
        List<Person> myList = client.person_list;
        Assertions.assertNotNull(myList);
        Assertions.assertEquals(myList.size(), 1);
        Assertions.assertEquals(myList.get(0).getFirstName(), "Anna");
        Assertions.assertEquals(myList.get(0).getSurname(), "Brown");
    }
}
