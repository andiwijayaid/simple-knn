import org.jfree.chart.ChartFactory
import org.jfree.chart.ChartPanel
import org.jfree.chart.plot.PlotOrientation
import org.jfree.chart.plot.XYPlot
import org.jfree.data.xy.XYDataset
import org.jfree.data.xy.XYSeries
import org.jfree.data.xy.XYSeriesCollection
import java.awt.Color
import javax.swing.JFrame

class Plotter(title: String) : JFrame(title) {

    init {
        val dataSet = createDataSet()

        val chart = ChartFactory.createScatterPlot(
            "Credit Data",
            "Age", "Loan", dataSet, PlotOrientation.VERTICAL, true, true, false
        )

        val plot = chart.plot as XYPlot
        plot.backgroundPaint = Color(255, 228, 196)

        val panel = ChartPanel(chart)
        contentPane = panel
    }

    private fun createDataSet(): XYDataset {
        val dataSet = XYSeriesCollection()

        val yClass = XYSeries("Y Class")
        val nClass = XYSeries("N Class")

        for(i in 0 until defaults.size) {
            if (defaults[i] == "Y") {
                yClass.add(ages[i], loans[i])
            } else {
                nClass.add(ages[i], loans[i])
            }
        }

        val newData = XYSeries("New Data")
        newData.add(nAge, nLoan)

        dataSet.addSeries(yClass)
        dataSet.addSeries(nClass)
        dataSet.addSeries(newData)
        return dataSet
    }
}