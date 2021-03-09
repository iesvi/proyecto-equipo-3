package com.Equipo3.Backend.Peticion.Aplicacion;

import com.Equipo3.Backend.Peticion.Dominio.DTO.PeticionDTO;
import com.Equipo3.Backend.Peticion.Dominio.Mapper.PeticionMapper;
import com.Equipo3.Backend.Peticion.Dominio.PeticionVO;
import com.Equipo3.Backend.Peticion.Dominio.Repository.PeticionRepository;
import com.Equipo3.Backend.Shared.Err.EntityExist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class PeticionService {
    /**
     * peticionRepo tipo PeticionRepository
     */
    @Autowired
    PeticionRepository peticionRepo;

    /**
     * Método para dar de alta una nueva peticion. Tambien se convierte una PeticionDTO a PeticionVO
     *
     * @param peticiondto
     * @return eticionRepo.save(peticion)
     */
    @Transactional
    public PeticionVO darDeAltaUnaPeticion(PeticionDTO peticiondto) {

        Optional<PeticionVO> nbd = peticionRepo.findById(peticiondto.getId());
        if (nbd.isPresent())
            throw new EntityExist(PeticionVO.class.toString(), peticiondto.getId());

        PeticionVO peticion = PeticionMapper.fromDTO(peticiondto);
        return peticionRepo.save(peticion);
    }
}
