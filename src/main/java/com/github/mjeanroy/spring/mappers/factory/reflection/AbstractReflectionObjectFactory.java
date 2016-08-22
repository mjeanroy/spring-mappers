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

package com.github.mjeanroy.spring.mappers.factory.reflection;

import com.github.mjeanroy.spring.mappers.factory.AbstractObjectFactory;

/**
 * Factory that use reflection to create beans.
 * Note that beans must have a default constructor to be instantiated.
 *
 * This class is an abstract since it must be explicitly sub-classed to use
 * default constructor.
 *
 * @param <T> Type of created beans.
 */
public abstract class AbstractReflectionObjectFactory<T> extends AbstractObjectFactory<T> {

	/**
	 * Create new factory based on reflection.
	 *
	 * Important: this constructor will try to detect target class at instantiation
	 * using reflection.
	 */
	protected AbstractReflectionObjectFactory() {
		super();
	}

	/**
	 * Create new factory based on reflection.
	 *
	 * @param klass Target class (i.e class of object created by this factory).
	 */
	protected AbstractReflectionObjectFactory(Class<T> klass) {
		super(klass);
	}
}
