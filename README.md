# Kotlin Coding Theory

Simple collection of traditional Coding Theory algorithms made in Kotlin, with a touch of functional programming.

Every script is meant to be used with [kscript](https://github.com/holgerbrandl/kscript).

## Burrows–Wheeler Transform

You can find a simple implementation of the [Burrows–Wheeler transform](https://en.wikipedia.org/wiki/Burrows%E2%80%93Wheeler_transform) in the file `bwt.kt`.

### Usage example

```
$ kscript bwt.kt -d 'hello world'
'olhdrellwo ' 3

$ kscript bwt.kt -i 'olhdrellwo ' 3 
hello world
```

## Fibonacci Coding

You can find a simple implementation of the [Fibonacci Coding](https://en.wikipedia.org/wiki/Fibonacci_coding) in the file `fibonacci.kt`.

### Usage example

```
$ kscript fibonacci.kt 14          
 1 ->        11
 2 ->       011
 3 ->      0011
 4 ->      1011
 5 ->     00011
 6 ->     10011
 7 ->     01011
 8 ->    000011
 9 ->    100011
10 ->    010011
11 ->    001011
12 ->    101011
13 ->   0000011
14 ->   1000011
```
