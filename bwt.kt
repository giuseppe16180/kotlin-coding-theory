fun main(args: Array<String>) {
    
    when(args.get(0)) {
        "-d", "--direct" -> println(args.get(1).bwTransform())
        "-i", "--inverse" -> println(BwtResult(args.get(1), args.get(2).toInt()).bwTransformInv())
        else -> println("-d    --direct \t [text] - do BWT on text \n-i    --inverse \t [text] [index] - get back text")
    }
}

data class BwtResult(val string: String, val index: Int) {

    fun bwTransformInv(): String{

        val sorted = string.toList()
            .mapIndexed { index, char -> Pair(char, index) }
            .sortedBy { it.first } 

        fun compose(prefix: String, i: Int): String {
            val res = sorted.get(i) 
            return if (res.second == index) prefix + res.first
                   else compose(prefix + res.first, res.second) 
        }
        
        return compose("", index)
    }

    override fun toString(): String {
        return "\'${string}\' ${index}"
    }
}


fun String.bwTransform(): BwtResult {

    val rotations = (0 .. this.length - 1)
        .map { Pair(this.rotate(it), it) }
        .sortedWith(compareBy { it.first })
    
    val string = rotations.map { it.first.takeLast(1) }.joinToString(separator = "")
    val index = rotations.indexOfFirst { it.second == 0 }

    return BwtResult(string, index)
} 

fun String.rotate(n: Int) = drop(n % length) + take(n % length)