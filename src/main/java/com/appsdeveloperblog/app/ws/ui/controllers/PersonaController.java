package com.appsdeveloperblog.app.ws.ui.controllers;

import com.appsdeveloperblog.app.ws.ui.model.Persona;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import java.util.List;

@RestController

public class PersonaController {

    private List<Persona> personas = new ArrayList<>();

    public PersonaController() {

        for (int i = 1; i <= 10; i++) {

            Persona p = new Persona();

            p.setDni("DNI" + i);

            p.setNombre("Nombre" + i);

            p.setApellido1("Apellido1_" + i);

            p.setApellido2("Apellido2_" + i);

            String nombreCompleto = p.getNombre() + " " + p.getApellido1() + " " + p.getApellido2();

            p.setNombreCompleto(nombreCompleto);

            p.setFechaNacimiento("2000-01-0" + i);

            p.setSexo("H");

            personas.add(p);

        }

    }

    // =========================

    // EJERCICIO 1

    // =========================

    @GetMapping("/persona")

    public Persona obtenerPersona() {

        Persona persona = new Persona();

        persona.setNombre("Antonio");

        persona.setApellido1("Angeles");

        persona.setApellido2("Blázquez");

        String nombreCompleto = persona.getNombre() + " " +

                persona.getApellido1() + " " +

                persona.getApellido2();

        persona.setNombreCompleto(nombreCompleto);

        persona.setFechaNacimiento("2005-09-08");

        persona.setSexo("H");

        return persona;

    }

    // =========================

    // EJERCICIO 2

    // =========================

    @PostMapping("/envioFormulario")

    public void recibirFormulario(

            @RequestParam String nombre,

            @RequestParam String apellido1,

            @RequestParam String apellido2,

            @RequestParam String fechaNacimiento,

            @RequestParam String sexo) {

        System.out.println("Nombre: " + nombre);

        System.out.println("Primer apellido: " + apellido1);

        System.out.println("Segundo apellido: " + apellido2);

        System.out.println("Fecha de nacimiento: " + fechaNacimiento);

        System.out.println("Sexo: " + sexo);

    }

    // =========================

    // EJERCICIO 3

    // =========================

    @GetMapping("/persona/{dni}")

    public Persona obtenerPersonaPorDni(@PathVariable String dni) {

        for (Persona p : personas) {

            if (p.getDni().equals(dni)) {

                return p;

            }

        }

        return null;

    }

    @PutMapping("/persona/{dni}")

    public Persona modificarPersona(@PathVariable String dni, @RequestBody Persona personaActualizada) {

        for (Persona p : personas) {

            if (p.getDni().equals(dni)) {

                p.setNombre(personaActualizada.getNombre());

                p.setApellido1(personaActualizada.getApellido1());

                p.setApellido2(personaActualizada.getApellido2());

                String nombreCompleto = personaActualizada.getNombre() + " "

                        + personaActualizada.getApellido1() + " "

                        + personaActualizada.getApellido2();

                p.setNombreCompleto(nombreCompleto);

                p.setFechaNacimiento(personaActualizada.getFechaNacimiento());

                p.setSexo(personaActualizada.getSexo());

                return p;

            }

        }

        return null;

    }

}
