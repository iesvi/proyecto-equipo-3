package com.Equipo3.Backend.Evento.Infraestructura.controller;

import com.Equipo3.Backend.Evento.Aplicacion.Service.EventoService;
import com.Equipo3.Backend.Evento.Dominio.DTO.EventoDTO;
import com.Equipo3.Backend.Evento.Dominio.Mapper.EventoMapper;
import com.Equipo3.Backend.Shared.Infraestructura.controller.constant.EndpointUrls;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(EndpointUrls.V1 + EventoRestController.EVENT_RESOURCE)
@AllArgsConstructor
public class EventoRestController {

    @Autowired
    private final EventoService eventService;

    public static final String EVENT_RESOURCE = "/event";

    @PostMapping
    public ResponseEntity<EventoDTO> register(@RequestBody EventoDTO dto) {
        eventService.darDeAltaUnEvento(dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(EndpointUrls.GetById)
    public ResponseEntity getById(@PathVariable final int id) {
        try {
            return eventService.consultarEventos(id)
                    .map(event -> EventoMapper.toDTO(event))
                    .map(eventdto -> new ResponseEntity(eventdto, HttpStatus.OK))
                    .orElse(new ResponseEntity(null, HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(EndpointUrls.Update)
    public ResponseEntity<EventoDTO> update(@RequestBody EventoDTO eventoDTO) {
        return new ResponseEntity(eventService.modificarEvento(eventoDTO), HttpStatus.CREATED);
    }

    @DeleteMapping(EndpointUrls.DeleteById)
    public ResponseEntity<Boolean> delete(@PathVariable final int id) {
        return eventService.eliminarUnEvento(id)
                ? ResponseEntity.ok(true)
                : new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}
