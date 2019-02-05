public class Main {
   private static Employee[] employees;
    public static void main(String[] args){
        initializeEmployeeArray();

        for (int i = 0; i < Employee.getnumberOfEmployees() ; i++) {
            if (employees[i].getAge() >= (byte) 30)
            employees[i].printEmployeeInfo();
        }
    }
    private static void initializeEmployeeArray() {
        Employee gBakunov = new Employee("Григорий Николаевич Бакунов", "директор по распространению технологий", "bobuk@yandex.ru",
                "89153423321", 182514, (byte)47);
        Employee dZagoskin = new Employee("Данил Загоскин", "разработчик интерфейсов облачной платформы","st-olen@yandex.ru",
                "89253864442", 98235, (byte)32);
        Employee sVavinov = new Employee("Сергей Вавинов", "руководитель группы технологий работы с большими данными",
                "svv@yandex.ru", "89167825421",121780 ,(byte)37);
        Employee aKulikov = new Employee("Артём Куликов", "старший инженер по программному обеспечению", "breqwas@yandex.ru",
                "89258746609", 113548, (byte)34);
        Employee aOrlov = new Employee("Анатолий Орлов", "Chief Technology Officer", "anatolix@ozon.ru", "89185524917",
                237192, (byte)37);
        employees = new Employee[]{gBakunov, dZagoskin, sVavinov, aKulikov, aOrlov};
    }
}
