package cleanCodeRefactorizacion;

public class Ejercicio3 {

    public void calculateQuadraticEquation(double a, double b, double c) {

        double discriminant = calculateDiscriminant(a, b, c);

        if (discriminant > 0){

            printTwoSolutions(a, b, discriminant);
        } else if (discriminant == 0){

            printOneSolution(a, b);

        } else {

            System.out.println("Equation has no roots");

        }
    }

    private double calculateDiscriminant(double a, double b, double c) {
        return b * b - 4 * a * c;
    }

    private void printTwoSolutions(double a, double b, double discriminant) {

        double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
        double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);

        System.out.println("x1 = " + x1 + ", x2 = " + x2);
    }

    private void printOneSolution(double a, double b) {

        double x = -b / (2 * a);

        System.out.println("x = " + x);
    }
}
