package com.lzwing.mapstruct.converter;

import com.lzwing.mapstruct.domain.Person;
import com.lzwing.mapstruct.dto.PersonDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel="spring")
@Component
public interface PersonConverter {
    PersonConverter INSTANCE = Mappers.getMapper(PersonConverter.class);
    @Mappings({
        @Mapping(source = "birthday", target = "birth"),
        @Mapping(source = "birthday", target = "birthDateFormat", dateFormat = "yyyy-MM-dd HH:mm:ss"),
        @Mapping(target = "birthExpressionFormat", expression = "java(org.apache.commons.lang3.time.DateFormatUtils.format(person.getBirthday(),\"yyyy-MM-dd HH:mm:ss\"))"),
        @Mapping(source = "user.age", target = "age"),
        @Mapping(target = "email", ignore = true)
    })
    PersonDTO domain2dto(Person person);

    List<PersonDTO> domain2dto(List<Person> people);

    default Boolean convert2Bool(Integer value) {
        if (value == null || value < 1) {
            return Boolean.FALSE;
        } else {
            return Boolean.TRUE;
        }
    }

    default Integer convert2Int(Boolean value) {
        if (value == null) {
            return null;
        }
        if (Boolean.TRUE.equals(value)) {
            return 1;
        }
        return 0;
    }
}