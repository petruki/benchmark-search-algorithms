### About

Benchmark testing 10 scenarios performing search in a bidimensional array of Objects and primitive elements.

```
# JMH version: 1.28
# VM version: JDK 1.8.0_144, Java HotSpot(TM) 64-Bit Server VM, 25.144-b01
# VM options: <none>
# Blackhole mode: full + dont-inline hint
# Warmup: 1 iterations, 1 s each
# Measurement: 1 iterations, 1 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Parameters: (iterations = 10000000)
```

Benchmark     | (iterations) | Mode | Score | Units
:-------------|:-------------|:-----|:------|:-------
BenchmarkRunner.testObjectForEach                  |10000000  |avgt   |   2699,342   | ms/op
BenchmarkRunner.testObjectForEachBinary            |10000000  |avgt   |   1301,792   | ms/op
BenchmarkRunner.testObjectForEachBinary8Threads    |10000000  |avgt   |    408,388   | ms/op
BenchmarkRunner.testObjectForLoop                  |10000000  |avgt   |   4081,161   | ms/op
BenchmarkRunner.testObjectStream                   |10000000  |avgt   |  15937,118   | ms/op
BenchmarkRunner.testPrimitiveForEach               |10000000  |avgt   |   1302,360   | ms/op
BenchmarkRunner.testPrimitiveForEachBinary         |10000000  |avgt   |   1133,874   | ms/op
BenchmarkRunner.testPrimitiveForEachBinary8Threads |10000000  |avgt   |    267,391   | ms/op
BenchmarkRunner.testPrimitiveForLoop               |10000000  |avgt   |   2057,118   | ms/op
BenchmarkRunner.testPrimitiveStream                |10000000  |avgt   |  10230,278   | ms/op

### Runing

Do not use the embedded Maven from your IDE

Create the benchmark jar
> mvn clean install

Run
> java -jar target/benchmarks.jar

