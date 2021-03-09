package com.Equipo3.Backend.Usuario.Infraestructura.controller;

import com.Equipo3.Backend.Shared.Infraestructura.controller.constant.EndpointUrls;
import com.Equipo3.Backend.Usuario.Aplicacion.Service.UsuarioService;
import com.Equipo3.Backend.Usuario.Dominio.DTO.UsuarioDTO;
import com.Equipo3.Backend.Usuario.Dominio.Mapper.UsuarioMapper;
import com.Equipo3.Backend.Usuario.Dominio.UsuarioVO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(EndpointUrls.V1 + UsuarioRestController.USER_RESOURCE)
@AllArgsConstructor
public class UsuarioRestController {

    @Autowired
    private final UsuarioService userService;

    public static final String USER_RESOURCE = "/user";

    @PostMapping
    public ResponseEntity<UsuarioDTO> register(@RequestBody UsuarioDTO dto) {
        userService.Registro_De_Usuario(dto);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    public ResponseEntity<UsuarioDTO> createUser(@RequestBody UsuarioDTO newuser) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(UsuarioMapper.toDTO(userService.Registro_De_Usuario(newuser)));

    }

    @GetMapping(EndpointUrls.GetAll)
    public ResponseEntity<List<UsuarioDTO>> getAll() {
        return ResponseEntity.ok(userService.Consultar_Usuarios());
    }

    @GetMapping(EndpointUrls.GetById)
    public ResponseEntity getById(@PathVariable final int id) {
        try {
            return userService.ConsultarPerfilUsuario(id)
                    .map(user -> UsuarioMapper.toDTO(user))
                    .map(userdto -> new ResponseEntity(userdto, HttpStatus.OK))
                    .orElse(new ResponseEntity(null, HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(EndpointUrls.Update)
    public ResponseEntity<UsuarioDTO> update(@RequestBody UsuarioDTO usuarioDTO) {
        return new ResponseEntity(userService.Modificar_Usuario(usuarioDTO), HttpStatus.CREATED);
    }

    @DeleteMapping(EndpointUrls.DeleteById)
    public ResponseEntity<Boolean> delete(@PathVariable final int id) {
        return userService.Eliminar_Usuario(id)
                ? ResponseEntity.ok(true)
                : new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
//    @GetMapping(EndpointUrls.GetById)
//    public ResponseEntity<UsuarioDTO> getById(@PathVariable final int id) {
//        try {
//            UsuarioVO vo = userService.ConsultarPerfilUsuario(id);
//            UsuarioDTO dto = UsuarioMapper.toDTO(vo);
//            return new ResponseEntity(dto, HttpStatus.OK);
//        }catch(Exception e){
//            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
//        }
//    }
//    @GetMapping("/me")
//    public UsuarioDTO me( UsuarioVO user) {
//        return UsuarioMapper.toDTO(user);
//    }
}
