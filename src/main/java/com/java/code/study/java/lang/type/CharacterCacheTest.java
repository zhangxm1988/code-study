package com.java.code.study.java.lang.type;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-04-21 16:52
 */
public class CharacterCacheTest {

  public static void main(String[] args) {

    Character char1 = 127;
    Character char2 = 127;
    System.out.println("char12 == " + (char1 == char2));

    Character char3 = 250;
    Character char4 = 250;
    System.out.println("char34 == " + (char3 == char4));

    Character char5 = 'X';
    Character char6 = 'x';
    System.out.println("char56 == " + (char5 == char6));
    System.out.println("getNumericValue : " + Character.getNumericValue(char5));

    Boolean boolean1 = true;
    Boolean boolean2 = true;
    System.out.println("boolean12 == " + (boolean1 == boolean2));
  }

}
