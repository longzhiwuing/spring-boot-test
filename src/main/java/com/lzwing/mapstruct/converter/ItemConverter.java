package com.lzwing.mapstruct.converter;

import com.lzwing.mapstruct.domain.Item;
import com.lzwing.mapstruct.domain.Sku;
import com.lzwing.mapstruct.dto.SkuDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper(componentModel="spring")
@Component
public interface ItemConverter {
    ItemConverter INSTANCE = Mappers.getMapper(ItemConverter.class);

    @Mappings({
            @Mapping(source = "sku.id",target = "skuId"),
            @Mapping(source = "sku.code",target = "skuCode"),
            @Mapping(source = "sku.price",target = "skuPrice"),
            @Mapping(source = "item.id",target = "itemId"),
            @Mapping(source = "item.title",target = "itemName")
    })
    SkuDTO domain2dto(Item item, Sku sku);
}