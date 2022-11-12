package services;

import javax.jws.WebService;
import java.util.*;
import java.util.stream.Collectors;

@WebService(name = "IStorePerson")
public class PersonImplementation implements IStorePerson {

    private final Map<String, List<Person>> _bySurname;
    private final Map<String, List<Person>> _byBirthDate;

    public PersonImplementation(List<Person> persons) {
        _bySurname = persons
                .stream()
                .collect(Collectors.groupingBy(Person::getSurname));
        _byBirthDate =  persons
                .stream()
                .collect(Collectors.groupingBy(Person::getBirthDate));
    }

    @Override
    public List<Person> filter(List<Person> list) {
        return list.stream().distinct().collect(Collectors.toList());
    }

    @Override
    public List<Person> filter1(FilterRequest request) {
        List<Person> bySurname = request.surname != null
                ? _bySurname.get(request.surname)
                : _bySurname.values()
                .stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());


        List<Person> byBirthDate = request.birthDate != null
                ? _byBirthDate.get(request.birthDate)
                : _byBirthDate.values()
                .stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());


        return bySurname //
                .stream() //
                .distinct()
                .filter(byBirthDate::contains)
                .collect(Collectors.toList());
    }
}