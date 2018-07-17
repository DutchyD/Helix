package com.temporary.helix.module;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This file is part of Helix
 * Creation date: 7/17/2018
 * Created by: Dylan 'Dutchy' de Beer
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ModuleSettings {

    String spaggotVersion();

    String id();

    String[] dependencies() default {};

}
