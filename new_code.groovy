@Grapes([
    @Grab(group='org.seleniumhq.selenium', module='selenium-chrome-driver', version='<your-version>'),
    @Grab(group='org.codehaus.geb', module='geb-core', version='<your-version>'),
    @Grab(group='org.apache.poi', module='poi', version='3.17')
])

import geb.Browser
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.By
import org.apache.poi.ss.usermodel.WorkbookFactory
import java.io.File

// Set up the Chrome WebDriver
System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver")
def chromeOptions = new ChromeOptions()
chromeOptions.addArguments("--headless")  // Optional, for running in headless mode
def driver = new ChromeDriver(chromeOptions)

// Set up the browser
Browser.drive(new Browser(driver), {
    // Navigate to GitHub
    go "https://github.com"

    // Log in to GitHub (replace with your credentials)
    $("input[name='login']").value("YourUsername")
    $("input[name='password']").value("YourPassword")
    $("input[type='submit']").click()

    // Navigate to the specified repo and branch
    go "https://github.com/your-username/repo-name/tree/branch-name"

    // Find the Excel sheet and search for the word
    def excelFile = new File("path/to/excel-file.xlsx")
    def wordToSearch = "your-word"

    if (excelFile.exists()) {
        def workbook = WorkbookFactory.create(excelFile)
        def sheet = workbook.getSheetAt(0) // Assuming the first sheet
        def found = sheet.rowIterator().any { row ->
            row.cellIterator().any { cell ->
                cell.toString().contains(wordToSearch)
            }
        }

        if (found) {
            println("TRUE")
        } else {
            println("FALSE")
        }
    } else {
        println("Excel file not found.")
    }
})
