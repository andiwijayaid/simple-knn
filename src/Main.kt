import java.util.*
import javax.swing.WindowConstants

var nAge = 0
var nLoan = 0
fun main() {
    val reader = Scanner(System.`in`)

    // Enter age, loan, and number of neighbor
    print("Enter a age: ")
    nAge = reader.nextInt()

    print("Enter a loan: ")
    nLoan = reader.nextInt()

    print("Enter number of neighbor: ")
    val neighbor = reader.nextInt()
    // -----------------------------------------------------------------------------

    // Calculate distance for each person
    val distances = arrayListOf<Int>()
    for (i in 0 until ages.size) {
        distances.add(
            calculateDistance(ages[i], loans[i], nAge, nLoan).toInt()
        )
    }
    // -----------------------------------------------------------------------------

    // find candidates based on nearest neighbor
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

    // Find number of each class to find new data's class
    var numberOfYes = 0
    var numberOfNo = 0
    for (candidate in candidates) {
        if (defaults[candidate] == "Y") {
            numberOfYes++
        } else {
            numberOfNo++
        }
    }

    // if number of yes is bigger than no, then new data is a Y class
    if (numberOfYes > numberOfNo) {
        println("Class: Y")
    } else if (numberOfYes == numberOfNo) { // if number of yes equal number of no then new data is the first candidate
        println("Class: ${defaults[candidates[0]]}")
    } else { // if number of no is bigger than yes, then new data is N class
        println("Class: N")
    }

    // Plotting the data
    val plotter = Plotter("Credit - KNN")
    plotter.setSize(800, 400)
    plotter.setLocationRelativeTo(null)
    plotter.defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
    plotter.isVisible = true
}