package com.cgi.ectp.data.PetDTO;

import com.cgi.ectp.data.model.PetModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetDTO {

    private int id;
    private String name;
    private String type;
    private String color;
    private char gender;
    private Date dob;
    public PetModel toPetModel() {
        final PetModel petModel = new PetModel();
        petModel.setId(getId());
        petModel.setName(getName());
        petModel.setType(getType());
        petModel.setColor(getColor());
        petModel.setGender(getGender());
        petModel.setDob(getDob());
        return petModel;
    }

    public static PetDTO of(final PetModel petModel) {
        final PetDTO petDTO = new PetDTO();
        petDTO.setId(petModel.getId());
        petDTO.setName(petModel.getName());
        petDTO.setType(petModel.getType());
        petDTO.setColor(petModel.getColor());
        petDTO.setGender(petModel.getGender());
        petDTO.setDob(petModel.getDob());
        return petDTO;
    }
}
