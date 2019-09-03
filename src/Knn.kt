import kotlin.math.sqrt


fun calculateDistance(age: Int, loan: Int, nAge: Int, nLoan: Int): Double {
    val ageDistance = Math.pow((age - nAge).toDouble(), 2.0)
    val loanDistance = Math.pow((loan - nLoan).toDouble(), 2.0)
    return sqrt(ageDistance + loanDistance)
}