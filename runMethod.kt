import java.lang.Math.pow

fun runMethod(A:Array<DoubleArray>, f :Array<Double>){
    val n = f.size

    var a = DoubleArray(n - 1) { 0.0 }
    var b = DoubleArray(n - 1) { 0.0 }
    var c = DoubleArray(n) { 0.0 }

    for (i in 0 until n) {
        c[i] = A[i][i]
    }
    for (i in 1 until n) {
        b[i - 1] = A[i - 1][i]
        a[i - 1] = A[i][i - 1]
    }
    var alpha = DoubleArray(n - 1) { 0.0 }
    var beta = DoubleArray(n) { 0.0 }

    alpha[0] = -b[0] / c[0]
    beta[0] = f[0] / c[0]

    for (i in 1 until n) {
        var s = c[i] + a[i - 1] * alpha[i - 1]
        if (i != n - 1) {
            alpha[i] = -b[i] / s
        }
        beta[i] = (f[i] - a[i - 1] * beta[i - 1]) / s
    }
    var x = DoubleArray(n) { 0.0 }
    x[n - 1] = beta[n - 1]

    for (i in n-2 downTo 0) {
        x[i] = alpha[i] * x[i + 1] + beta[i]
    }
    //Конец метода

    for (i in 0 until n) {
        println(x[i])
    }
}
fun main(args: Array<String>) {


    var A: Array<DoubleArray> = Array(5) { DoubleArray(5) { 0.0 } }
    A[0] = doubleArrayOf(2.0, 1.0, 0.0, 0.0, 0.0)
    A[1] = doubleArrayOf(1.0, 2.0, 1.0, 0.0, 0.0)
    A[2] = doubleArrayOf(0.0, 1.0, 2.0, 1.0, 0.0)
    A[3] = doubleArrayOf(0.0, 0.0, 1.0, 2.0, 1.0)
    A[4] = doubleArrayOf(0.0, 0.0, 0.0, 1.0, 2.0)

    val f = arrayOf(2.0, 2.0, 2.0, 2.0, 2.0)


   runMethod(A,f)


}
