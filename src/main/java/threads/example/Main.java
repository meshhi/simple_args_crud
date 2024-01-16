package threads.example;

import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static List<Person> allPeople = new ArrayList<Person>();
    public static SimpleDateFormat dateFormatIn = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    public static SimpleDateFormat dateFormatOut = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //напишите тут ваш код
        if (Objects.equals(args[0], Crud.CREATE.getLabel())) {
            String name = args[1];
            String sex = args[2];
            Date dateBirth = dateFormatIn.parse(args[3]);
            Person.addPerson(name, sex, dateBirth);
        } else if (Objects.equals(args[0], Crud.READ.getLabel())) {
            Person.printPerson(args[1]);
        } else if (Objects.equals(args[0], Crud.UPDATE.getLabel())) {
            String id = args[1];
            String name = args[2];
            String sex = args[3];
            Date dateBirth = dateFormatIn.parse(args[4]);
            Person.updatePerson(id, name, sex, dateBirth);
        } else if (Objects.equals(args[0], Crud.DELETE.getLabel())) {
            String id = args[1];
            Person.deletePerson(id);
        } else {
            System.out.println("unknown");
        }

        System.out.println("PRINT RESULT LIST:");
        for (Person person : allPeople) {
            System.out.println(person);
        }
    }
} 