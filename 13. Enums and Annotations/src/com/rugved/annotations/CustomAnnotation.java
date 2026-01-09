package com.rugved.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)   // * Tells the compiler till when we want this Annotation, RUNTIME is also a predefined Enum
@Target({ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.LOCAL_VARIABLE})   // * This is the way to create Custom Annotations. The value TYPE refers to Class or Interface and similarly there are other type targets too, The TYPE is a predefined ENUM
@interface COC_Troop {      // * This Specifies the Compiler that Annotation Type is being Created
  String type() default "Ground";   // * When Written default even if we don't pass any value while using this annotation, then also it works.
  int damage()  default 100;
  // * This is How we create Multi Valued Annotation, These are called Attributes
};
