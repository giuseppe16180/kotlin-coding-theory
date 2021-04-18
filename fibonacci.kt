import kotlin.math.pow
import kotlin.math.log2
import kotlin.math.ln
import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.round
import kotlin.math.sqrt

val phi = (1.0 + sqrt(5.0)) / 2.0
fun fib(n: Int) = ((phi.pow(n) - (1.0 - phi).pow(n)) / sqrt(5.0)).toInt()
fun fibInv(n: Int) = if (n == 1) 2 else floor(ln((n + 0.5) * sqrt(5.0)) / ln(phi)).toInt()

fun main(args: Array<String>) {

    var n = args.get(0)

    IntRange(1, n.toInt()).forEach { 
        println("%${n.length}s ->%10s".format(it, fibCode(it))) 
    } 
}

fun fibCode(n: Int): String {

    fun fibRepres(n: Int, list: List<Int> = listOf()): List<Int> {

        val i = fibInv(n)
        val r = n - fib(i)

        return if (r != 0) fibRepres(r, list + i) else list + i
    }


    return (fibRepres(n) + 1)
        .zipWithNext()
        .reversed()
        .map { "0".repeat(it.first - it.second - 1) + "1"}
        .reduce { acc, curr -> acc + curr } + "1"
}

