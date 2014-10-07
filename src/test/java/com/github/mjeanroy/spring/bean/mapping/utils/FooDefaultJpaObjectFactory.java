package com.github.mjeanroy.spring.bean.mapping.utils;

import com.github.mjeanroy.spring.bean.mapping.factory.jpa.AbstractDefaultJpaFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.core.convert.converter.Converter;

import static org.mockito.Mockito.mock;

public class FooDefaultJpaObjectFactory extends AbstractDefaultJpaFactory<Foo, Long> {

	public final ApplicationContext appContext;

	public FooDefaultJpaObjectFactory() {
		appContext = mock(ApplicationContext.class);
		setApplicationContext(appContext);
	}

	public FooDefaultJpaObjectFactory(Converter<Object, Long> converter) {
		super(converter);
		appContext = mock(ApplicationContext.class);
		setApplicationContext(appContext);
	}
}
