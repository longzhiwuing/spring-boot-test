package com.lzwing.mapstruct.converter;

import com.lzwing.base.BaseWebTest;
import com.lzwing.mapstruct.domain.Item;
import com.lzwing.mapstruct.domain.Person;
import com.lzwing.mapstruct.domain.Sku;
import com.lzwing.mapstruct.domain.User;
import com.lzwing.mapstruct.dto.PersonDTO;
import com.lzwing.mapstruct.dto.SkuDTO;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/8/5
 * Time: 12:19
 */
public class PersonConverterTest extends BaseWebTest{

    @Autowired
    private PersonConverter personConverter;

    @Autowired
    private ItemConverter itemConverter;


    @Test
    public void test() {
        Person person = new Person(1L,"zhige","zhige.me@gmail.com",new Date(),new User(1));
//        PersonDTO personDTO = PersonConverter.INSTANCE.domain2dto(person);
        PersonDTO personDTO = personConverter.domain2dto(person);
        assertNotNull(personDTO);
        assertEquals(personDTO.getId(), person.getId());
        assertEquals(personDTO.getName(), person.getName());
        assertEquals(personDTO.getBirth(), person.getBirthday());
        String format = DateFormatUtils.format(personDTO.getBirth(), "yyyy-MM-dd HH:mm:ss");
        assertEquals(personDTO.getBirthDateFormat(),format);
        assertEquals(personDTO.getBirthExpressionFormat(),format);

        List<Person> people = new ArrayList<>();
        people.add(person);
        List<PersonDTO> personDTOs = PersonConverter.INSTANCE.domain2dto(people);
        assertNotNull(personDTOs);

        assertTrue(personConverter.convert2Bool(1));
        assertEquals(personConverter.convert2Int(true),Integer.valueOf(1));
    }

    @Test
    public void test2() {
        Item item = new Item(1L, "iPhone X");
        Sku sku = new Sku(2L, "phone12345", 1000000);
//        SkuDTO skuDTO = ItemConverter.INSTANCE.domain2dto(item, sku);
        SkuDTO skuDTO = itemConverter.domain2dto(item, sku);
        assertNotNull(skuDTO);
        assertEquals(skuDTO.getSkuId(),sku.getId());
        assertEquals(skuDTO.getSkuCode(),sku.getCode());
        assertEquals(skuDTO.getSkuPrice(),sku.getPrice());
        assertEquals(skuDTO.getItemId(),item.getId());
        assertEquals(skuDTO.getItemName(),item.getTitle());
    }
}