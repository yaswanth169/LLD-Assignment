package org.assignment2.problem6;

public class Reportgenerator {

//    Requirements:
//    1. Report contains:
//          title
//          generatedDate
//          multiple sections
//    2. Section types:
//          TextSection
//          TableSection
//          ChartSection
//          SummarySection
//    3. Generate report in:
//          Plain Text
//          HTML
//          Markdown
//    4. Use Builder to create reports.
//    5. Support predefined templates.


//    My initial thinking is:
//    Suppose I write everything inside Report.
//    class Report{
//        generatePlainText(){}
//        generateHtml(){}
//        generateMarkdown(){}
//    }

//    For every section I start writing if-else conditions.
//    if(TextSection)
//    if(TableSection)
//    if(ChartSection)
//    if(SummarySection) Initially this works.But tomorrow if they ask me to add
//    PdfFormatter or ImageSection I need to modify Report again. Report slowly becomes responsible for everything.

//    Problems with this approach:
//    1. Report knows every formatter.This violates Open Closed Principle.
//    2. Report knows every section. Again, Open Closed Principle.
//    3. Large if-else blocks.


//    If I observe carefully, the changing parts are:
//          Output Formats
//              Plain Text
//              HTML
//              Markdown
//              PDF
//          Section Types
//              Text
//              Table
//              Chart
//              Summary
//              Image These will keep increasing.
//    The stable part is: Report Since report creation happens step by step, i am thinking Builder Pattern fits well. Since formatting changes, Formatter abstraction fits well.


//    Instead of Report knowing every formatter, I can create
//    interface ReportFormatter{
//          String format(Report report);
//    }
//    Every formatter implements this interface.Similarly,every section follows one common contract.
//    interface Section{
//    }


//    Relationship:
//    Report HAS-A  List<Section>
//    Builder builds Report Formatter formats Report


//    Runtime Flow:
//    Client
//    Builder
//    Report
//    Formatter
//    PlainText / HTML / Markdown



// Q1. Where does rendering logic live?
// Inside each Formatter. Avoid large if-else blocks.


// Q2. Tomorrow if PdfFormatter comes?
// Create PdfFormatter only. If ImageSection comes, create ImageSection only.


// Q3. Why Builder?
// Makes report creation easier and readable.

// Q4. Template should be?
// Factory that creates predefined reports.


// Q5. Unknown section?
// Formatter should skip it or handle it gracefully.

}