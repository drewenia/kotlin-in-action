package ch02;

public class Demo221 {
    public static void main(String[] args) {
        Person221 person = new Person221("Ocean",true);
        System.out.println(person.getName()); // Ocean
        System.out.println(person.isStudent()); // true
        person.setStudent(false);
        System.out.println(person.isStudent()); // false
    }
}
