package cleanCodeRefactorizacion;
/*
Ejercicio 2 - Refactoración

Se crea una clase cleanCodeRefactorizacion.Address para separar la responasbilidad
de la dirección de la clase cleanCodeRefactorizacion.Human.
 */

public class Address {

    private String country;
    private String city;
    private String street;
    private String house;
    private String quarter;

    public Address(String country, String city, String street, String house, String quarter) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.house = house;
        this.quarter = quarter;
    }

    public String getFullAddress() {
        return country + ","  + city + "," + street + "," + house + "" + quarter;
    }
}
