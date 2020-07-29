package com.jie.imports.selector;


import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// 將注解信息保留到运行时
@Retention(RetentionPolicy.RUNTIME)
@Import(TestImportDaoImportSelector.class)
public @interface EnableTestImportDao {
}
