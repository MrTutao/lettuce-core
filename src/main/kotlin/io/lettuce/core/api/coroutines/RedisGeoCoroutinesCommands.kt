/*
 * Copyright 2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.lettuce.core.api.coroutines

import io.lettuce.core.*
import kotlinx.coroutines.flow.Flow

/**
 * Coroutine executed commands for the Geo-API.
 *
 * @author Mikhael Sokolov
 * @since 6.0
 * @generated by io.lettuce.apigenerator.CreateKotlinCoroutinesApi
 */
@ExperimentalLettuceCoroutinesApi
interface RedisGeoCoroutinesCommands<K : Any, V : Any> {

    /**
     * Single geo add.
     *
     * @param key the key of the geo set.
     * @param longitude the longitude coordinate according to WGS84.
     * @param latitude the latitude coordinate according to WGS84.
     * @param member the member to add.
     * @return Long integer-reply the number of elements that were added to the set.
     */
    suspend fun geoadd(key: K, longitude: Double, latitude: Double, member: V): Long?

    /**
     * Multi geo add.
     *
     * @param key the key of the geo set.
     * @param lngLatMember triplets of Double longitude, Double latitude and V member.
     * @return Long integer-reply the number of elements that were added to the set.
     */
    suspend fun geoadd(key: K, vararg lngLatMember: Any): Long?

    /**
     * Retrieve Geohash strings representing the position of one or more elements in a sorted set value representing a
     * geospatial index.
     *
     * @param key the key of the geo set.
     * @param members the members.
     * @return bulk reply Geohash strings in the order of `members`. Returns `null` if a member is not found.
     */
    fun geohash(key: K, vararg members: V): Flow<Value<String>>

    /**
     * Retrieve members selected by distance with the center of `longitude` and `latitude`.
     *
     * @param key the key of the geo set.
     * @param longitude the longitude coordinate according to WGS84.
     * @param latitude the latitude coordinate according to WGS84.
     * @param distance radius distance.
     * @param unit distance unit.
     * @return bulk reply.
     */
    fun georadius(key: K, longitude: Double, latitude: Double, distance: Double, unit: GeoArgs.Unit): Flow<V>

    /**
     * Retrieve members selected by distance with the center of `longitude` and `latitude`.
     *
     * @param key the key of the geo set.
     * @param longitude the longitude coordinate according to WGS84.
     * @param latitude the latitude coordinate according to WGS84.
     * @param distance radius distance.
     * @param unit distance unit.
     * @param geoArgs args to control the result.
     * @return nested multi-bulk reply. The [GeoWithin] contains only fields which were requested by [GeoArgs].
     */
    fun georadius(key: K, longitude: Double, latitude: Double, distance: Double, unit: GeoArgs.Unit, geoArgs: GeoArgs): Flow<GeoWithin<V>>

    /**
     * Perform a [georadius(Any, Double, Double, Double, GeoArgs.Unit, GeoArgs)] query and store the results in a
     * sorted set.
     *
     * @param key the key of the geo set.
     * @param longitude the longitude coordinate according to WGS84.
     * @param latitude the latitude coordinate according to WGS84.
     * @param distance radius distance.
     * @param unit distance unit.
     * @param geoRadiusStoreArgs args to store either the resulting elements with their distance or the resulting elements with
     *        their locations a sorted set.
     * @return Long integer-reply the number of elements in the result.
     */
    suspend fun georadius(key: K, longitude: Double, latitude: Double, distance: Double, unit: GeoArgs.Unit, geoRadiusStoreArgs: GeoRadiusStoreArgs<K>): Long?

    /**
     * Retrieve members selected by distance with the center of `member`. The member itself is always contained in the
     * results.
     *
     * @param key the key of the geo set.
     * @param member reference member.
     * @param distance radius distance.
     * @param unit distance unit.
     * @return set of members.
     */
    fun georadiusbymember(key: K, member: V, distance: Double, unit: GeoArgs.Unit): Flow<V>

    /**
     * Retrieve members selected by distance with the center of `member`. The member itself is always contained in the
     * results.
     *
     * @param key the key of the geo set.
     * @param member reference member.
     * @param distance radius distance.
     * @param unit distance unit.
     * @param geoArgs args to control the result.
     * @return nested multi-bulk reply. The [GeoWithin] contains only fields which were requested by [GeoArgs].
     */
    fun georadiusbymember(key: K, member: V, distance: Double, unit: GeoArgs.Unit, geoArgs: GeoArgs): Flow<GeoWithin<V>>

    /**
     * Perform a [georadiusbymember(Any, Any, Double, GeoArgs.Unit, GeoArgs)] query and store the results in a
     * sorted set.
     *
     * @param key the key of the geo set.
     * @param member reference member.
     * @param distance radius distance.
     * @param unit distance unit.
     * @param geoRadiusStoreArgs args to store either the resulting elements with their distance or the resulting elements with
     *        their locations a sorted set.
     * @return Long integer-reply the number of elements in the result.
     */
    suspend fun georadiusbymember(key: K, member: V, distance: Double, unit: GeoArgs.Unit, geoRadiusStoreArgs: GeoRadiusStoreArgs<K>): Long?

    /**
     * Get geo coordinates for the `members`.
     *
     * @param key the key of the geo set.
     * @param members the members.
     * @return a list of [GeoCoordinates]s representing the x,y position of each element specified in the arguments. For
     *         missing elements `null` is returned.
     */
    suspend fun geopos(key: K, vararg members: V): List<GeoCoordinates>

    /**
     * Retrieve distance between points `from` and `to`. If one or more elements are missing `null` is
     * returned. Default in meters by, otherwise according to `unit`
     *
     * @param key the key of the geo set.
     * @param from from member.
     * @param to to member.
     * @param unit distance unit.
     * @return distance between points `from` and `to`. If one or more elements are missing `null` is
     *         returned.
     */
    suspend fun geodist(key: K, from: V, to: V, unit: GeoArgs.Unit): Double?

}

