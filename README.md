# Convert Excel, CSV to JSON files
Convert Excel and CSV files to JSON format according to the user request separately. The Excel and CSV files are all in the same folder. The output files are stored as seperate folders.
## Design Diagram
<img src="https://github.com/Upeshitha/excel-csv-file-convert-to-json/blob/main/Raw%20data/Image/design%20diagram%201.PNG" alt="upeshitha-design">
<img src="https://github.com/Upeshitha/excel-csv-file-convert-to-json/blob/main/Raw%20data/Image/design%20diagram%202.PNG" alt="upeshitha-design">

## Overview
This project is an improvement version of my previous two projects. If you want to get more knowledge about this project please follow these two project also.
* https://github.com/Upeshitha/exceltoJSON
* https://github.com/Upeshitha/Search-Files-in-Folder

These are some features of this project.
* Identify file name according to the file extension.
* Identify the number of rows and columns in the Excel and CSV files.
* Identify the excel sheet inside the excel file.
* The output files are generated as separated folders.

## Inputs
<img src="https://github.com/Upeshitha/excel-csv-file-convert-to-json/blob/main/Raw%20data/Image/Input.PNG" alt="upeshitha-input">
<img src="https://github.com/Upeshitha/excel-csv-file-convert-to-json/blob/main/Raw%20data/Image/input%20folder.PNG" alt="upeshitha-input">

## Output
<img src="https://github.com/Upeshitha/excel-csv-file-convert-to-json/blob/main/Raw%20data/Image/output1.PNG" alt="upeshitha-output">
<img src="https://github.com/Upeshitha/excel-csv-file-convert-to-json/blob/main/Raw%20data/Image/output2.PNG" alt="upeshitha-output">
<img src="https://github.com/Upeshitha/excel-csv-file-convert-to-json/blob/main/Raw%20data/Video/output.gif" alt="output-gif">

## Dependencies
These dependencies are used for excel to json convert
* [Apache POI API Based On OPC and OOXML Schemas](https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml)
* [Jackson Databind](https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind)
* [Gson](https://mvnrepository.com/artifact/com.google.code.gson/gson)

This dependency is used for files handling
* [Apache Commons IO](https://mvnrepository.com/artifact/commons-io/commons-io)

These dependencies are used for csv to json convert
* [Jackson Core](https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-core)
* [FasterXML Jackson Dataformat](https://mvnrepository.com/artifact/com.fasterxml.jackson.dataformat)
* [Jackson Dataformat CSV](https://mvnrepository.com/artifact/com.fasterxml.jackson.dataformat/jackson-dataformat-csv)
* [SFM CSV](https://mvnrepository.com/artifact/org.simpleflatmapper/sfm-csv)
* [SimpleFlatMapper](https://simpleflatmapper.org/0101-getting-started-csv.html)
* [org.simpleflatmapper](https://simpleflatmapper.org/0101-getting-started-csv.html)

## Acknowledgements
* [Jackson JsonGenerator](http://tutorials.jenkov.com/java-json/jackson-jsongenerator.html)
* [tutorialspoint.com](https://www.tutorialspoint.com/convert-csv-to-json-using-the-jackson-library-in-java)
