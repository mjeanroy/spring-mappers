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

package com.github.mjeanroy.spring.mappers;

import java.util.Map;

/**
 * Mapper that can transform object of type T to objects of
 * type U.
 *
 * This mapper support transformation of iterable structure of type T
 * to iterable structure of type U.
 *
 * @param <T> Original type.
 * @param <U> New type.
 */
public interface ObjectMapper<T, U> {

	/**
	 * Transform source object to destination object.
	 * Implementation must be null-safe (do not produce {@link NullPointerException}).
	 *
	 * @param source Source object.
	 * @return Destination object.
	 */
	U map(T source);

	/**
	 * Transform iterable structure of type U to new iterable structure
	 * of type T.
	 *
	 * @param sources Source objects.
	 * @return Destination objects.
	 */
	Iterable<U> map(Iterable<T> sources);

	/**
	 * Transform map structure of type U to new map structure
	 * of type T.
	 *
	 * @param sources Source objects.
	 * @return Destination objects.
	 */
	<K> Map<K, U> map(Map<K, T> sources);
}
