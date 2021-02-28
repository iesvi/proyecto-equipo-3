package com.Equipo3.Backend.Usuario.Dominio.Mapper;

import com.Equipo3.Backend.Evento.Dominio.DTO.EventoDTO;
import com.Equipo3.Backend.Evento.Dominio.EventoVO;
import com.Equipo3.Backend.Evento.Dominio.Mapper.EventoMapper;
import com.Equipo3.Backend.Usuario.Dominio.DTO.UsuarioDTO;
import com.Equipo3.Backend.Usuario.Dominio.UsuarioVO;

import java.util.ArrayList;
import java.util.List;

public class UsuarioMapper {

    public static List<UsuarioDTO> ToListDto(List<UsuarioVO> lista) {
        List<UsuarioDTO> listaDTO = new ArrayList<>();
        for (int i=0; i<lista.size();i++){
            UsuarioDTO usuario = new UsuarioDTO(lista.get(i).getId(),lista.get(i).getNombre(), lista.get(i).getPassword(), lista.get(i).getEmail(),lista.get(i).getFecha_nacimiento(),lista.get(i).getTelefono(), lista.get(i).getRol(), null,null,null);
            listaDTO.add(usuario);
        }
        return listaDTO;
    }

    public static List<UsuarioVO> ToListVO(List<UsuarioDTO> lista) {
        List<UsuarioVO> listaVO = new ArrayList<>();
        for (int i=0; i<lista.size();i++){
            UsuarioVO usuario = new UsuarioVO(lista.get(i).getId(),lista.get(i).getNombre(), lista.get(i).getPassword(), lista.get(i).getEmail(),lista.get(i).getFecha_nacimiento(),lista.get(i).getTelefono(), lista.get(i).getRol(), null,null,null);
            listaVO.add(usuario);
        }
        return listaVO;
    }

    public static List<EventoVO> eventoToListVO(List<EventoDTO> lista) {
        List<EventoVO> listaVO = new ArrayList<>();
        for (int i=0; i<lista.size();i++){
            EventoVO evento = EventoMapper.fromDTO(lista.get(i));
            listaVO.add(evento);
        }
        return listaVO;
    }

    public static List<EventoDTO> eventoToListDto(List<EventoVO> lista) {
        List<EventoDTO> listaDTO = new ArrayList<>();
        for (int i=0; i<lista.size();i++){
            EventoDTO evento = EventoMapper.toDTO(lista.get(i));
            listaDTO.add(evento);
        }
        return listaDTO;
    }

    public static UsuarioDTO toDTO(UsuarioVO vo) {
        return new UsuarioDTO()
                .withId(vo.getId())
                .withNombre(vo.getNombre())
                .withPassword(vo.getPassword())
                .withEmail(vo.getEmail())
                .withFecha_nacimiento(vo.getFecha_nacimiento())
                .withRol(vo.getRol())
                .withAmigos(ToListDto(vo.getAmigos()))
                .withAmigosde(ToListDto(vo.getAmigosde()))
                .withEventos(eventoToListDto(vo.getEventos()));
    }

    //TODO: convertDTO ==>  Por ctor
    public static UsuarioVO fromDTO(UsuarioDTO dto){
        return new UsuarioVO()
                .withId(dto.getId())
                .withNombre(dto.getNombre())
                .withPassword(dto.getPassword())
                .withEmail(dto.getEmail())
                .withFecha_nacimiento(dto.getFecha_nacimiento())
                .withRol(dto.getRol())
                .withAmigos(ToListVO(dto.getAmigos()))
                .withAmigosde(ToListVO(dto.getAmigosde()))
                .withEventos(eventoToListVO(dto.getEventos()));
    }
}
