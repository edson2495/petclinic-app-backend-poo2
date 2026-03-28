package pe.edu.unu.petclinicappbackendpoo2.Util;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pe.edu.unu.petclinicappbackendpoo2.DTO.request.PersonRequest;
import pe.edu.unu.petclinicappbackendpoo2.DTO.request.VetRequest;
import pe.edu.unu.petclinicappbackendpoo2.DTO.response.PersonResponse;
import pe.edu.unu.petclinicappbackendpoo2.DTO.response.VetResponse;
import pe.edu.unu.petclinicappbackendpoo2.entity.Person;
import pe.edu.unu.petclinicappbackendpoo2.entity.Vet;

@Component
public class ModelMapperUtil {

    private static ModelMapper mapper;

    //@Autowired
    public ModelMapperUtil(ModelMapper mapper) {
        ModelMapperUtil.mapper = mapper;
    }

    //origin : instancia origen
    //targetClass : el tipo de clase destino (PersonResponse.class)
    //T : tipo al cual se va a convertir
    public static <T> T convertTo(Object origin, Class<T> targetClass){
        return ModelMapperUtil.mapper.map(origin, targetClass);
    }

//    //person
//    //dto -> entity
//    public static PersonResponse convertToResponse(Person person){
//        return ModelMapperUtil.mapper.map(person, PersonResponse.class);
//    }
//    //entity -> dto
//    public static Person convertToEntity(PersonRequest personaRequest){
//        return ModelMapperUtil.mapper.map(personaRequest, Person.class);
//    }
//
//    //vet
//
//    public static VetResponse convertToResponse(Vet vet){
//        return ModelMapperUtil.mapper.map(vet, VetResponse.class);
//    }
//
//    public static Vet convertToEntity(VetRequest vetRequest){
//        return ModelMapperUtil.mapper.map(vetRequest, Vet.class);
//    }


}
