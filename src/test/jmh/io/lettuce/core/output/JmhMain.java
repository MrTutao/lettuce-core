/*
 * Copyright 2017-2020 the original author or authors.
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
package io.lettuce.core.output;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.ChainedOptionsBuilder;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

/**
 * Manual JMH Test Launcher.
 *
 * @author Mark Paluch
 */
public class JmhMain {

    public static void main(String... args) throws RunnerException {
        runValueListOutputBenchmark();
    }

    private static void runValueListOutputBenchmark() throws RunnerException {

        new Runner(prepareOptions().mode(Mode.AverageTime) //
                .timeUnit(TimeUnit.NANOSECONDS) //
                .include(".*ValueListOutputBenchmark.*") //
                .build()).run();
    }

    private static ChainedOptionsBuilder prepareOptions() {

        return new OptionsBuilder()//
                .forks(1) //
                .warmupIterations(5)//
                .threads(1) //
                .measurementIterations(5) //
                .timeout(TimeValue.seconds(2));
    }
}
