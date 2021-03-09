package com.Equipo3.Backend.Shared.Infraestructura.ProductorConsumidor;

import com.Equipo3.Backend.Peticion.Aplicacion.PeticionService;
import com.Equipo3.Backend.Peticion.Dominio.DTO.PeticionDTO;
import com.Equipo3.Backend.Peticion.Dominio.Mapper.PeticionMapper;
import com.Equipo3.Backend.Peticion.Dominio.PeticionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConsumidorPeticiones extends Thread{

    @Autowired
    private ColaPeticiones colap;
    boolean parar = false;
    private List<PeticionDTO> lista;
    @Autowired
    private PeticionService PS;



//    public ConsumidorPeticiones(ColaPeticiones colap, PeticionService PS) {
//        this.colap = colap;
//        this.PS = PS;
//    }

    public void run() {
        while (!parar)
        {
            lista = colap.get();

            for(int i=0;i<lista.size();i++){
                PeticionVO pet = PS.darDeAltaUnaPeticion(lista.get(i));
            }
            colap.setPeticiones();

            try {
                sleep(2000);
            } catch (InterruptedException e) {		e.printStackTrace(); }



        }
        System.out.println("\t\t\t\t\t\t*****  Consumidor muerto  *****" );
        parar=false;
    }

    public void pararHilo() {
        //Para parar el hilo sólo tenemos que hacerla true
        parar = true;
        System.out.println("Consumidor parado" );
    }



}
