package com.crusadehelper.enums.unittype;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

//TODO: add input validation
//TODO: add logging
@Converter(autoApply = true)
public class UnitTypeConverter implements AttributeConverter<UnitType, String> {
    @Override
    public String convertToDatabaseColumn(UnitType attribute) {
        return attribute.name();
    }

    @Override
    public UnitType convertToEntityAttribute(String dbData) {
        return UnitType.valueOf(dbData);
    }
}
