package com.Equipo3.Backend.Shared.Infraestructura.ProductorConsumidor;

import com.Equipo3.Backend.Peticion.Dominio.DTO.PeticionDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ColaPeticiones {
    private List<PeticionDTO> peticiones = new ArrayList<>();

    private boolean disponible = false;

    /**
     * Clase que obtiene una lista de todas las peticiones
     * @return
     */
    public synchronized List<PeticionDTO> get() {
        while (disponible == false) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        disponible = false;
        System.out.println("\t\t\t\t\t\tRecuperado todos las peticiones");

        notifyAll();
        return peticiones;
    }

    /**
     * Clase que introduce una lista de peticiones
     * @param peticion
     */
    public synchronized void put(PeticionDTO peticion) {
        while (disponible == true) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        this.peticiones.add(peticion);
        System.out.println("\t\t\t\tIntroducido peticion " + peticiones.size());
        if (peticiones.size() == 5) {
            disponible = true;
            notifyAll();
        }
    }

    public void setPeticiones() {
        peticiones = new ArrayList<>();
    }
}
