package com.adv.price.util;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Field;

/**
 * Created by GANG CHEN on 2018/9/3.
 */
@Getter
@Setter
public class FieldForSortting {
    private Field field;
    private int index;

    /**
     * @param field
     */
    public FieldForSortting(Field field) {
        super();
        this.field = field;
    }

    /**
     * @param field
     * @param index
     */
    public FieldForSortting(Field field, int index) {
        super();
        this.field = field;
        this.index = index;
    }
}
