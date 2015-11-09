package tabulate.benchmark

import org.openjdk.jmh.annotations._

@State(Scope.Thread)
@BenchmarkMode(Array(Mode.Throughput))
class CsvOutputBenchmark extends ExampleData {
  @Benchmark
  def printTuples = print(tuples)
}
