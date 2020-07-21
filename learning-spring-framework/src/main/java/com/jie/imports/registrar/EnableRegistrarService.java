package com.jie.imports.registrar;

import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Import(RegistrarImportBeanDefinitionRegistrar.class)
public @interface EnableRegistrarService {
}
