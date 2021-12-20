package com.cgi.ectp.data;

import com.cgi.ectp.data.PetDTO.PetDTO;
import com.cgi.ectp.data.dao.PetRepository;
import com.cgi.ectp.data.model.PetModel;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/hello/v1")
public class PetController {

    @Autowired
    private PetRepository petRepository;

    @PostMapping("/add")
    public PetDTO create(@RequestBody final PetDTO pPetDTO) {

        final PetModel model = pPetDTO.toPetModel();
        model.setId(Integer.MIN_VALUE);
        return PetDTO.of(petRepository.save(model));
    }

    @GetMapping("/{id}")
    public PetDTO read(@PathVariable("id") final int pId) {

        return PetDTO.of(   petRepository.findById(pId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND))   );
    }

    @PutMapping("/{id}")
    public PetDTO update(@PathVariable("id") final int pId,
                         @RequestBody final PetDTO pPetDTO  ) {

        final PetModel petModel = pPetDTO.toPetModel();
        try {
            petModel.setId(pId);
        } catch(Exception e ) {
            System.out.println(e.getMessage());
        }
        return PetDTO.of(petRepository.save(petModel));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") final int pId) {
        if (!petRepository.existsById(pId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        petRepository.deleteById(pId);
    }

    @GetMapping("/")
    public Collection<PetDTO> getAll() {

        return StreamSupport.stream(petRepository.findAll().spliterator(), false)
                .map(model -> PetDTO.of(model))
                .collect(Collectors.toList());
    }
}