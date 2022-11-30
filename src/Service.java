public interface Service {

    int getAge() throws MyException;

    String getSortCountry(Customer[]customers);
    String getAllPerson(Customer[]customers) throws MyException;


    Customer[] getNameEqualCountry( String country,Customer[] customers);
}
