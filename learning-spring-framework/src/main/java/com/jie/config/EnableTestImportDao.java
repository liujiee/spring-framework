package com.jie.config;


import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Import(TestImportDaoImportSelector.class)
public @interface EnableTestImportDao {
}
