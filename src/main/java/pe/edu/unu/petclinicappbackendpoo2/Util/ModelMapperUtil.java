package pe.edu.unu.petclinicappbackendpoo2.Util;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pe.edu.unu.petclinicappbackendpoo2.DTO.request.PersonRequest;
import pe.edu.unu.petclinicappbackendpoo2.DTO.response.PersonResponse;
import pe.edu.unu.petclinicappbackendpoo2.entity.Person;

@Component
public class ModelMapperUtil {

    private static ModelMapper mapper;

    //@Autowired
    public ModelMapperUtil(ModelMapper mapper) {
        ModelMapperUtil.mapper = mapper;
    }

    //person
    //dto -> entity
    public static PersonResponse convertToResponse(Person person){
        return ModelMapperUtil.mapper.map(person, PersonResponse.class);
    }
    //entity -> dto
    public static Person convertToEntity(PersonRequest personaRequest){
        return ModelMapperUtil.mapper.map(personaRequest, Person.class);
    }

    //vet



}
