/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.ignite.springdata.proxy;

import org.apache.ignite.Ignite;

/** Implementation of {@link IgniteProxy} that provides access to Ignite cluster through {@link Ignite} instance. */
public class IgniteProxyImpl implements IgniteProxy {
    /** {@link Ignite} instance to which operations are delegated. */
    private final Ignite ignite;

    /** */
    public IgniteProxyImpl(Ignite ignite) {
        this.ignite = ignite;
    }

    /** {@inheritDoc} */
    @Override public <K, V> IgniteCacheProxy<K, V> getOrCreateCache(String name) {
        return new IgniteCacheProxyImpl<>(ignite.getOrCreateCache(name));
    }

    /** {@inheritDoc} */
    @Override public <K, V> IgniteCacheProxy<K, V> cache(String name) {
        return new IgniteCacheProxyImpl<>(ignite.cache(name));
    }

    /** @return {@link Ignite} instance to which operations are delegated. */
    public Ignite delegate() {
        return ignite;
    }
}
