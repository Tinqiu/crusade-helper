package com.crusadehelper.enums.rank;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

//TODO: add input validation
//TODO: add logging
@Converter
public class RankConverter implements AttributeConverter<Rank, String> {
    @Override
    public String convertToDatabaseColumn(Rank attribute) {
        return attribute.name();
    }

    @Override
    public Rank convertToEntityAttribute(String dbData) {
        return Rank.valueOf(dbData);
    }
}
