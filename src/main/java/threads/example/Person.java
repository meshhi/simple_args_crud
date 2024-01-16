package threads.example;

import java.util.Date;

class Person {
    private String name;
    private String sex;
    private Date dateBirth;

    private Person(String name, String sex, Date dateBirth) {
        this.name = name;
        this.sex = sex;
        this.dateBirth = dateBirth;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public String getDateBirth() {
        if (dateBirth == null) return null;
        return Main.dateFormatOut.format(dateBirth);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public static Person createMale(String name, Date dateBirth) {
        return new Person(name, "м", dateBirth);
    }

    public static void addPerson(String name, String sex, Date dateBirth) {
        Person newPerson = new Person(name, sex, dateBirth);
        Main.allPeople.add(newPerson);
        System.out.println(Main.allPeople.indexOf(newPerson));
    }

    public static void printPerson(String id) {
        Person current = Main.allPeople.get(Integer.parseInt(id));
        System.out.println(current);
    }

    public static void updatePerson(String id, String name, String sex, Date dateBirth) {
        Person current = Main.allPeople.get(Integer.parseInt(id));
        current.setName(name);
        current.setSex(sex);
        current.setDateBirth(dateBirth);
        System.out.println(current);
    }

    public static void deletePerson(String id) {
        Person current = Main.allPeople.get(Integer.parseInt(id));
        current.setName(null);
        current.setSex(null);
        current.setDateBirth(null);
        System.out.println(current);
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", getName(), getSex(), getDateBirth());
    }
}
