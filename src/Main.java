import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);

        try {
            Customer customer1 = new Customer("Ivan", "Ivanov", Country.KYRGYZSTAN, LocalDate.of(2002, 4, 7), "ivan@gmail@gmail.com");
            Customer customer2 = new Customer("Ivan", "Ivanov", Country.RUSSIA, LocalDate.of(2045, 5, 7), "ivan@gmail@gmail.com");
            Customer customer3 = new Customer("Ivan", "Ivanov", Country.KAZAKHSTAN, LocalDate.of(2000, 6, 7), "ivangmail.com");
            Customer customer4 = new Customer("Ivan", "Ivanov", Country.USA, LocalDate.of(1998, 9, 7), "ivan@gmail@gmail.com");
            Customer customer5 = new Customer("Ivan", "Ivanov", Country.JAPAN, LocalDate.of(2006, 9, 7), "ivan@gmail@gmail.com");
            Customer[] customers = {customer1, customer2, customer3, customer4, customer5};
            Country[]values=Country.values();
            System.out.println("Choose method, please input number from 1 to 4 ");
            int num= scanner.nextInt();

            switch (num) {
                case 1:

                    for (Customer customer : customers) {
                        System.out.println(customer.getAge() + " years old");
                    }
                    break;
                case 2:
                    System.out.println(customer1.getSortCountry(customers));
                    break;
                case 3:
                    System.out.println(customer1.getAllPerson(customers));
                    break;
                case 4:
                    System.out.println("Write country");
                    String country=scanner1.nextLine();
                    System.out.println(Arrays.toString(customer1.getNameEqualCountry(country, customers)));
            }

            } catch (DateTimeException e) {
            System.out.println("Date is not correct");
        }


    }


}

