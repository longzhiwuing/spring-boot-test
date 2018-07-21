package com.lzwing.importselector.annotation;

import com.lzwing.importselector.MyImportSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;
 
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(MyImportSelector.class)
public @interface EnableLog {

	String name();
}
