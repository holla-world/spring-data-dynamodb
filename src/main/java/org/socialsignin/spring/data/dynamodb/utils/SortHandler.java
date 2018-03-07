/**
 * Copyright © 2018 spring-data-dynamodb (https://github.com/spring-data-dynamodb/spring-data-dynamodb)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.socialsignin.spring.data.dynamodb.utils;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * Some helper methods to deal with {@link Sort}.
 *
 * @author derjust
 */
public class SortHandler {

    private SortHandler() {
    }

     public static void ensureNoSort(Pageable pageable) {
        Sort sort = pageable.getSort();
        ensureNoSort(sort);
    }

    /**
     * @throws UnsupportedOperationException if a {@code sort} is initialized (non-null &amp;&amp; not {@link Sort#unsorted()}
     */
    public static void ensureNoSort(Sort sort) throws UnsupportedOperationException {
        if (sort != null) {
            throwUnsupportedSortOperationException();
        }
    }

    public static <T> T throwUnsupportedSortOperationException() {
        throw new UnsupportedOperationException("Sorting not supported for scan expressions");
    }
}