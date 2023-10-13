package flyweight_design_pattern;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

// Интерфейс Employee определяет общие методы для Developer и Tester.
interface Employee {
    void assignSkill(String skill);
    void task();
}

// Реализация интерфейса Employee для разработчиков.
class Developer implements Employee {
    private final String JOB = "Fix the issue";
    private String skill;

    @Override
    public void assignSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public void task() {
        System.out.println("Developer with skill: " + this.skill + " with Job: " + JOB);
    }
}

// Реализация интерфейса Employee для тестировщиков.
class Tester implements Employee {
    private final String JOB = "Test the issue";
    private String skill;

    @Override
    public void assignSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public void task() {
        System.out.println("Tester with Skill: " + this.skill + " with Job: " + JOB);
    }
}

// Класс EmployeeFactory для управления и эффективного повторного использования экземпляров сотрудников.
class EmployeeFactory {
    private static Map<String, Employee> employeeMap = new HashMap<>();

    public static Employee getEmployee(String type) {
        Employee employee = employeeMap.get(type);
        if (employee == null) {
            switch (type) {
                case "Developer":
                    System.out.println("Developer Created");
                    employee = new Developer();
                    break;
                case "Tester":
                    System.out.println("Tester Created");
                    employee = new Tester();
                    break;
                default:
                    System.out.println("No Such Employee");
            }
            employeeMap.put(type, employee);
        }
        return employee;
    }
}

public class FlyweightPattern {
    private static String employeeTypes[] = {"Developer", "Tester"};
    private static String skills[] = {"Java", "C++", ".Net", "Python"};

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Employee employee = EmployeeFactory.getEmployee(getRandomEmployeeType());
            employee.assignSkill(getRandomSkill());
            employee.task();
        }
    }

    public static String getRandomEmployeeType() {
        Random random = new Random();
        int randomIndex = random.nextInt(employeeTypes.length);
        return employeeTypes[randomIndex];
    }

    public static String getRandomSkill() {
        Random random = new Random();
        int randomIndex = random.nextInt(skills.length);
        return skills[randomIndex];
    }
}
