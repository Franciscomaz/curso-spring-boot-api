package com.learning.cursomc.core.infrastructure;

import com.learning.cursomc.core.application.DefaultEnum;

import javax.persistence.AttributeConverter;

public class DefaultEnumConverter<T extends DefaultEnum> implements AttributeConverter<T, Integer> {

    @Override
    public Integer convertToDatabaseColumn(T defaultEnum) {
        return null;
    }

    @Override
    public T convertToEntityAttribute(Integer integer) {
        return null;
    }
}
