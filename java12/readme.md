JDK 12 features summary:

1. It will make the coding process easier by extending the switch statement and enabling it to be used as statement or expression

2. It will boost the JDK build process by creating a class data-sharing archive through a default class list on the 64-bit platform

3. It will reduce the garbage collection pause times by processing evacuation work while running the Java threads, which means that pause times are consistent regardless of the heap size

4. Added a suite of microbenchmarks into the JDK build source code–streamlining the running of existing benchmarks and the creation of new ones

5. Eliminate any duplicate work necessary with maintaining two port for x64

6. Make aborting the garbage collection process much more efficient by breaking up the mixed collection group into mandatory and optional parts

7. Upgrade the G1 garbage collector to instantly return unused Java heap memory to the operating system when idle

Switch expressions (JEP 325)
Default CDS(class data-sharing ) archives
Shenandoah
Microbenchmark suite
JVM constants API
One AArch64 port, not two
Abortable mixed collections for G1
Promptly return unused committed memory from G1