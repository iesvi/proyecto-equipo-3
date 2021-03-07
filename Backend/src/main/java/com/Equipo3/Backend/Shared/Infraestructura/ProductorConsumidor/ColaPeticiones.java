package com.Equipo3.Backend.Shared.Infraestructura.ProductorConsumidor;

import com.Equipo3.Backend.Peticion.Dominio.DTO.PeticionDTO;

import java.util.ArrayList;
import java.util.List;

public class ColaPeticiones {
    private List<PeticionDTO> peticiones = new ArrayList<>();

    private boolean disponible = false;



    public synchronized List<PeticionDTO> get() {
        while (disponible == false) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        disponible = false;
        System.out.println("\t\t\t\t\t\tRecuperado todos las peticiones" );

        notifyAll();
        return peticiones;
    }


    public synchronized void put(PeticionDTO peticion) {
        while (disponible == true) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        this.peticiones.add(peticion);
        System.out.println("\t\t\t\tIntroducido peticion " + peticiones.size());
        if(peticiones.size()==5) {
            disponible = true;
            notifyAll();
        }
    }
}
