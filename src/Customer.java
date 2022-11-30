import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.InputMismatchException;

public class Customer implements Service {
    private String name;
    private String surname;
    private Country countryBirth;
    private LocalDate dateOfBirth;
    private String email;

    public Customer() {
    }

    public Customer(String name, String surname, Country countryBirth, LocalDate dateOfBirth, String email) {
        this.name = name;
        this.surname = surname;
        this.countryBirth = countryBirth;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Country getCountryBirth() {
        return countryBirth;
    }

    public void setCountryBirth(Country countryBirth) {
        this.countryBirth = countryBirth;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int getAge() {
        int age = 0;
        try {
            LocalDate now = LocalDate.now();
            Period period = Period.between(dateOfBirth, now);
            age = period.getYears();
            if (age < 0) {
                throw new MyException("!");
            }
            return age;
        } catch (MyException e) {
            System.out.print("Age can't be negative number ");
        }
        return age;
    }

    @Override
    public String getSortCountry(Customer[] customers) {
        try {
            String[] sort = new String[customers.length];
            int counter = 0;
            for (Customer cus : customers) {
                sort[counter] = String.valueOf(cus.getCountryBirth());
                counter++;
            }
            Arrays.sort(sort);
            if (Arrays.equals(sort, Country.valueOf())) {
                throw new MyException("Country not equals " + Arrays.toString(sort));
            }
            return Arrays.toString(sort);
        } catch (MyException e) {
            e.getMessage();
        }
        return null;
    }

    @Override
    public String getAllPerson(Customer[] customers) {
        return Arrays.toString(customers);

    }

    @Override

    public Customer[] getNameEqualCountry(String country, Customer[] customers) throws InputMismatchException {
        int x=0;
        for (Customer customer : customers) {
            if (customer.getCountryBirth().name().equals(country.toUpperCase()))
                x++;}
        if (x>0){
            Customer[]cus=new Customer[x];
            int i=0;
            for (Customer customer : customers) {
                if (customer.getCountryBirth().name().equals(country.toUpperCase()))
                    cus[i++]=customer;

        }return cus;
        }else {

        return null;}
    }

    @Override
    public String toString() {
        return "\nCustomer{" +
                " name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", countryBirth=" + countryBirth +
                ", dateOfBirth=" + dateOfBirth +
                ", email='" + email + '\'' +
                '}';
    }
}
