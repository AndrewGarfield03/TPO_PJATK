package services;

import java.util.Objects;

public class Person {
    private String FirstName;

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(String birthDate) {
        BirthDate = birthDate;
    }

    private String Surname;
    private String BirthDate;

    public Person() {
    }

    public Person(String firstName, String surname, String birthDate) {
        FirstName = firstName;
        Surname = surname;
        BirthDate = birthDate;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Surname.equals(person.Surname) &&
                BirthDate.equals(person.BirthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Surname, BirthDate);
    }

    @Override
    public String toString() {
        return "Person{" +
                "FirstName='" + FirstName + '\'' +
                ", Surname='" + Surname + '\'' +
                ", BirthDate=" + BirthDate +
                '}';
    }
}
