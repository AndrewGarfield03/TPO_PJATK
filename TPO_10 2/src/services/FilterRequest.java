package services;

public class FilterRequest {  //Sending a request

    public String surname;
    public String birthDate;

    public FilterRequest(){      //Sending 2 parameters Surname and Birthdate

    }
    public FilterRequest(String surname, String birthDate) {
        this.surname = surname;
        this.birthDate = birthDate;
    }
}
