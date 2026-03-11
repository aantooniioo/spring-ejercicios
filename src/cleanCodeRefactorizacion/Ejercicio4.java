package cleanCodeRefactorizacion;

public class Ejercicio4 {

    public void employeeMethod(Employee employee) {

        double monthlySalary = calculateMonthlySalary(employee);

        // Continue processing
    }

    private double calculateMonthlySalary(Employee employee) {

        return (employee.getYearlySalary() + employee.getAwards()) / 12;

    }
}
