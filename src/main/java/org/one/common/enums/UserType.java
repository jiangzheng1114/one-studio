package org.one.common.enums;

import xyz.icrab.common.model.Valueable;

/**
 * @author Knight
 * @since 2018/4/11 16:55
 */
public enum UserType implements Valueable<Integer> {

    Super(1),
    System(2),
    Retailer(3);

    private final int value;

    UserType(int value) {
        this.value = value;
    }

    @Override
    public Integer value() {
        return this.value;
    }
}
