package io.rayani.divar.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class ConvertDtoAndEntity<T,U> {
    public <T , U> U convertEntityDto(T source  , U target ){
        BeanUtils.copyProperties(source , target );
        return target;
    }
}
