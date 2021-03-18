package com.crusadehelper.enums.faction;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class FactionConverter implements AttributeConverter<Faction, String> {
    @Override
    public String convertToDatabaseColumn(Faction attribute) {
        return attribute.name();
    }

    @Override
    public Faction convertToEntityAttribute(String dbData) {
        return Faction.valueOf(dbData);
    }
}
