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

import org.springframework.beans.BeanUtils;
import org.springframework.core.GenericTypeResolver;

import static com.github.mjeanroy.spring.mappers.commons.PreConditions.notNull;

/**
 * Abstraction of factory that define commons methods to factories.
 *
 * @param <T> Type of created objects.
 */
public abstract class AbstractObjectFactory<T, U> implements ObjectFactory<T, U> {

	/**
	 * Get class of objects created by this factory.
	 */
	private final Class<T> klassT;

	/**
	 * Class of object used as a source object.
	 */
	private final Class<U> klassU;

	/**
	 * Instantiate this factory.
	 *
	 * Important: the target class (i.e class of object created by this factory)
	 * will be determined at runtime using reflection.
	 */
	@SuppressWarnings("unchecked")
	protected AbstractObjectFactory() {
		Class<?>[] klasses = GenericTypeResolver.resolveTypeArguments(getClass(), AbstractObjectFactory.class);
		this.klassT = (Class<T>) klasses[0];
		this.klassU = (Class<U>) klasses[1];
	}

	/**
	 * Instantiate this factory with target class (i.e class of object created by
	 * this factory).
	 *
	 * @param klassT Target class.
	 * @throws NullPointerException If {@code klass} is {@code null}.
	 */
	AbstractObjectFactory(Class<T> klassT, Class<U> klassU) {
		this.klassT = notNull(klassT, "Target class must not be null");
		this.klassU = notNull(klassU, "Source class must not be null");
	}

	@Override
	public T get(U source) {
		return BeanUtils.instantiateClass(klassT);
	}

	/**
	 * Get the target class: this is the class of object created by this
	 * factory.
	 *
	 * @return Target class.
	 */
	protected Class<T> getTargetClass() {
		return klassT;
	}

	/**
	 * Get the source class.
	 *
	 * @return Source class.
	 */
	protected Class<U> getSourceClass() {
		return klassU;
	}
}
