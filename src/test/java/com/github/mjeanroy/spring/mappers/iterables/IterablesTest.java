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

package com.github.mjeanroy.spring.mappers.iterables;

import org.junit.Test;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class IterablesTest {

	@Test
	public void it_should_get_size_of_collection() {
		Collection<String> collection = asList("foo", "bar");
		int size = Iterables.size(collection);
		assertThat(size).isEqualTo(collection.size());
	}

	@Test
	public void it_should_get_size_of_iterables() {
		final List<String> originalList = asList("foo", "bar");
		Iterable<String> iterables = new Iterable<String>() {
			@Override
			public Iterator<String> iterator() {
				return originalList.iterator();
			}
		};

		int size = Iterables.size(iterables);
		assertThat(size).isEqualTo(originalList.size());
	}

	@Test
	public void it_should_get_linked_list_from_collection() {
		Collection<String> collection = asList("foo", "bar");
		List<String> copy = Iterables.toList(collection);
		assertThat(copy)
				.isNotNull()
				.isExactlyInstanceOf(LinkedList.class)
				.hasSameSizeAs(collection)
				.isNotSameAs(collection)
				.isEqualTo(collection);
	}

	@Test
	public void it_should_get_linked_list_from_iterable() {
		final List<String> originalList = asList("foo", "bar");

		Iterable<String> iterable = new Iterable<String>() {
			@Override
			public Iterator<String> iterator() {
				return originalList.iterator();
			}
		};

		List<String> copy = Iterables.toList(iterable);

		assertThat(copy)
				.isNotNull()
				.isExactlyInstanceOf(LinkedList.class)
				.hasSameSizeAs(iterable)
				.isNotSameAs(iterable)
				.isEqualTo(originalList);
	}

	@Test
	public void it_should_get_linked_hash_set_from_collection() {
		Set<String> collection = new HashSet<>();
		collection.add("foo");
		collection.add("bar");

		Set<String> copy = Iterables.toSet(collection);

		assertThat(copy)
				.isNotNull()
				.isExactlyInstanceOf(LinkedHashSet.class)
				.hasSameSizeAs(collection)
				.isNotSameAs(collection)
				.isEqualTo(collection);
	}

	@Test
	public void it_should_get_linked_hash_set_from_iterable() {
		final Set<String> collection = new HashSet<>();
		collection.add("foo");
		collection.add("bar");

		Iterable<String> iterable = new Iterable<String>() {
			@Override
			public Iterator<String> iterator() {
				return collection.iterator();
			}
		};

		Set<String> copy = Iterables.toSet(iterable);

		assertThat(copy)
				.isNotNull()
				.isExactlyInstanceOf(LinkedHashSet.class)
				.hasSameSizeAs(iterable)
				.isNotSameAs(iterable)
				.isEqualTo(collection);
	}
}
