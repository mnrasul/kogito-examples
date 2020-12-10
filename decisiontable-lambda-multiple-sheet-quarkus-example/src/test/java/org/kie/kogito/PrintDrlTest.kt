package org.kie.kogito

import org.drools.decisiontable.InputType
import org.drools.decisiontable.SpreadsheetCompiler
import org.junit.jupiter.api.Test
import java.io.File
import java.io.FileInputStream
import java.io.IOException
import java.io.InputStream

class PrintDrlTest {

    private fun testSpreadsheet(dtpath: String) {
        val dtf = File(dtpath)
        val `is`: InputStream
        try {
            `is` = FileInputStream(dtf)
            val ssComp = SpreadsheetCompiler()
            val s: String = ssComp.compile(`is`, InputType.XLS)
            println("=== Begin generated DRL ===")
            println(s)
            println("=== End generated DRL ===")
        } catch (e: IOException) {
            // TODO Auto-generated catch block
            e.printStackTrace()
        }
    }

    @Test
    fun testHelloEndpoint() {
        testSpreadsheet("src/main/resources/org/kie/kogito/queries/LoanUnit.xls")
    }
}
