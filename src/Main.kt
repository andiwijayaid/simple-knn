import sun.rmi.runtime.Log
import java.util.*

fun main() {
    val reader = Scanner(System.`in`)

    print("Enter a age: ")
    val nAge = reader.nextInt()

    print("Enter a loan: ")
    val nLoan = reader.nextInt()

    print("Enter number of neighbor: ")
    val neighbor = reader.nextInt()

    val distances = arrayListOf<Int>()
    for (i in 0 until ages.size) {
        distances.add(
            calculateDistance(ages[i], loans[i], nAge, nLoan).toInt()
        )
    }

    val candidates = arrayListOf<Int>()

    var minValue = 9999999
    var minIndex = 0

    for (i in 0 until neighbor) {
        for (j in 0 until distances.size) {
            if (distances[j] < minValue) {
                minIndex = j
                minValue = distances[j]
            }
        }
        candidates.add(minIndex)
        distances[minIndex] = 9999999
        minValue = 9999999
    }

    var numberOfYes = 0
    var numberOfNo = 0
    for (candidate in candidates) {
        if (defaults[candidate] == "Y") {
            numberOfYes++
        } else {
            numberOfNo++
        }
    }

    if (numberOfYes > numberOfNo) {
        println("Class: Y")
    } else if (numberOfYes == numberOfNo) {
        println("Class: ${defaults[candidates[0]]}")
    } else {
        if (numberOfYes > numberOfNo) {
            println("Class: Y")
        }
    }
}