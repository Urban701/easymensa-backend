package com.urban.easymensabackend.model.menu;

import java.util.Arrays;

public enum DietType {
  VEGETARIAN("Vegetarian"),
  VEGAN("Vegan"),
  MEAT("Meat");

  final String name;

  DietType(String name) {
    this.name = name;
  }

  public static DietType findEnumByName(String name) {
    return Arrays.stream(DietType.values())
        .filter(dt -> dt.name.equalsIgnoreCase(name))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("wrong Diet Type Value"));
  }
}
