package com.lzwing.importselector;

import com.lzwing.entity.Author;
import com.lzwing.importselector.annotation.EnableLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

@Slf4j
public class MyImportSelector implements ImportSelector {

	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		//可以获取到注解信息，然后根据注解信息动态的返回被spring容器托管的bean
		log.info("MyImportSelector------可以获取到注解信息，然后根据注解信息动态的返回被spring容器托管的bean:{}",importingClassMetadata.getAnnotationAttributes(EnableLog.class.getName()));
		return new String[]{Author.class.getName()};
	}
}
 
