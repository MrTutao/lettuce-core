/*
 * Copyright 2011-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.lettuce.core.cluster.commands;

import static io.lettuce.core.cluster.ClusterTestUtil.flushDatabaseOfAllNodes;

import io.lettuce.TestClientResources;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;

import io.lettuce.core.FastShutdown;
import io.lettuce.core.RedisURI;
import io.lettuce.core.TestSettings;
import io.lettuce.core.api.sync.RedisCommands;
import io.lettuce.core.cluster.ClusterTestUtil;
import io.lettuce.core.cluster.RedisClusterClient;
import io.lettuce.core.cluster.api.StatefulRedisClusterConnection;
import io.lettuce.core.commands.GeoCommandTest;

/**
 * @author Mark Paluch
 */
public class GeoClusterCommandTest extends GeoCommandTest {
    private static RedisClusterClient redisClusterClient;
    private StatefulRedisClusterConnection<String, String> clusterConnection;

    @BeforeClass
    public static void setupClient() {
        redisClusterClient = RedisClusterClient.create(TestClientResources.get(),
                RedisURI.Builder.redis(TestSettings.host(), TestSettings.port(900)).build());
    }

    @AfterClass
    public static void closeClient() {
        FastShutdown.shutdown(redisClusterClient);
    }

    @Before
    public void openConnection() throws Exception {
        redis = connect();
        flushDatabaseOfAllNodes(clusterConnection);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected RedisCommands<String, String> connect() {
        clusterConnection = redisClusterClient.connect();
        return ClusterTestUtil.redisCommandsOverCluster(clusterConnection);
    }

    @Ignore("MULTI not available on Redis Cluster")
    @Override
    public void geoaddWithTransaction() throws Exception {
    }

    @Ignore("MULTI not available on Redis Cluster")
    @Override
    public void geoaddMultiWithTransaction() throws Exception {
    }

    @Ignore("MULTI not available on Redis Cluster")
    @Override
    public void georadiusWithTransaction() throws Exception {
    }

    @Ignore("MULTI not available on Redis Cluster")
    @Override
    public void geodistWithTransaction() throws Exception {
    }

    @Ignore("MULTI not available on Redis Cluster")
    @Override
    public void georadiusWithArgsAndTransaction() throws Exception {
    }

    @Ignore("MULTI not available on Redis Cluster")
    @Override
    public void georadiusbymemberWithArgsAndTransaction() throws Exception {
    }

    @Ignore("MULTI not available on Redis Cluster")
    @Override
    public void geoposWithTransaction() throws Exception {
    }

    @Ignore("MULTI not available on Redis Cluster")
    @Override
    public void geohashWithTransaction() throws Exception {
    }
}