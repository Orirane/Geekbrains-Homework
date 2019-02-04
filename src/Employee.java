public class Employee {
    private String firstName;
    private String secondName;
    private String patronymic = "";
    private String position;
    private String email;
    private String phoneNumber;
    private int wage;
    private byte age;
    private boolean aVampire = false;
    private static int numberOfEmployees = 0;


    public Employee(String name, String position, String email, String phoneNumber, int wage, byte age, boolean aVampire){
       String[] nameparts = name.split(" ");
       firstName = nameparts[0];
       try {
           secondName = nameparts[2];
           patronymic =" "+ nameparts[1]+ " ";
       } catch (java.lang.ArrayIndexOutOfBoundsException e){
            secondName = nameparts[1];
       }
       this.position = position;
       this.email = email;
       this.phoneNumber = phoneNumber;
       this.wage = wage;
       this.age = age;
       this.aVampire = aVampire;
       numberOfEmployees++;
    }
    public Employee(String name, String position, String email, String phoneNumber, int wage, byte age){
        String[] nameparts = name.split(" ");
        firstName = nameparts[0] + " ";
        try {
            secondName = nameparts[2];
            patronymic = nameparts[1]+ " ";
        } catch (java.lang.ArrayIndexOutOfBoundsException e){
            secondName = nameparts[1];
        }
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.wage = wage;
        this.age = age;
        numberOfEmployees++;
    }


    public void printEmployeeInfo() {
        System.out.println("Имя сотрудника: " + firstName + patronymic + secondName +
                "\nДолжность: " + position + "\nАдрес электронной почты: " + email +
                "\nНомер телефона: " + phoneNumber + "\nЗарплата: " + wage + " руб." + "\nВозраст: "
                + age + "\n");
        if (aVampire == true) {
            System.out.println("Выглядит значительно моложе своих лет.");
        }
    }
    public byte getAge(){
        return age;
    }
    public void setAge(byte age){
        this.age = age;
    }
    public static int getnumberOfEmployees(){
        return numberOfEmployees;
    }

}
