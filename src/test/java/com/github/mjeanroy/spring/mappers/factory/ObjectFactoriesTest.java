/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2014 <mickael.jeanroy@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.github.mjeanroy.spring.mappers.factory;

import com.github.mjeanroy.spring.mappers.utils.Foo;
import com.github.mjeanroy.spring.mappers.utils.FooDto;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ObjectFactoriesTest {

	@Test
	public void it_should_create_reflection_factory() {
		ObjectFactory<FooDto, Foo> factory = ObjectFactories.reflectionObjectFactory(FooDto.class, Foo.class);
		assertThat(factory)
				.isNotNull()
				.isInstanceOf(AbstractObjectFactory.class);

		assertThat(((AbstractObjectFactory) factory).getTargetClass()).isEqualTo(FooDto.class);
		assertThat(((AbstractObjectFactory) factory).getSourceClass()).isEqualTo(Foo.class);
	}

	@Test
	public void it_should_create_target_object_by_reflection() {
		ObjectFactory<FooDto, Foo> factory = ObjectFactories.reflectionObjectFactory(FooDto.class, Foo.class);
		FooDto target = factory.get(null);
		assertThat(target).isNotNull();
	}
}
