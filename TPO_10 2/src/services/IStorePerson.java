package services;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL) //Describig a SOAP service
public interface IStorePerson {
    @WebMethod
    List<Person> filter(List<Person> list);

    @WebMethod
    List<Person> filter1(FilterRequest request);
}
