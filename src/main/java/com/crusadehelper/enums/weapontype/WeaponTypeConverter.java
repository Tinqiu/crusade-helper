package com.crusadehelper.enums.weapontype;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class WeaponTypeConverter implements AttributeConverter<WeaponType, String> {
    @Override
    public String convertToDatabaseColumn(WeaponType attribute) {
        return attribute.name();
    }

    @Override
    public WeaponType convertToEntityAttribute(String dbData) {
        return WeaponType.valueOf(dbData);
    }
}
