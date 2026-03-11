package cleanCodeRefactorizacion;

/*
Ejercicio 2 - Refactorización

La clase cleanCodeRefactorizacion.Human ahora solo se encarga de la información
de la persona, mientras que la dirección se gestiona
mediante la clase cleanCodeRefactorizacion.Address.
 */
public class Human {

    private String name;
    private int age;
    private Address address;

    public Human(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getFullAddress() {
        return address.getFullAddress();
    }
}
