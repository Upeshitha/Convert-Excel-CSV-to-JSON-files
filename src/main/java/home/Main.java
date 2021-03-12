package home;

import csvConvert.CSVtoJSON;
import excelConvert.ExceltoJSON;
import searchingFile.FindFilesName;

import java.io.IOException;
import java.util.Scanner;

/**
 * The Home class implements the main controller of the project.
 * It controls the other class, and functions.
 *
 * @author : Eranda Upeshitha
 * @version : 1.0
 * @since : 2021/03/09
 */
public class Main {

    private static String fileType;
    private static String userInput;
    private static final String fileLocation = "E:\\User\\Downloads\\Files";

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.chooseFileType();
        main.convertFile(userInput);
    }

    /**
     * Get the user input
     */
    public void chooseFileType(){
        Scanner input = new Scanner(System.in);

        System.out.println("What type of files do you want to convert to JSON? \n" +
                "excel or csv");
        userInput = input.nextLine();
    }

    /**
     * Send convert signal according to the user input.
     * If the user types as excel then converts excel files in folder to JSON format.
     * If the user types as csv the converts csv files to the JSON format.
     * If your types other, then print an error statement.
     *
     * @param type  assign the user input data
     * @throws IOException
     */
    public void convertFile(String type) throws IOException {
        if (type.equalsIgnoreCase("excel")){
            fileType = ".xlsx";
            FindFilesName.listFiles(fileLocation,fileType); //search excel files inside the folder
            ExceltoJSON.getFilePath(); //convert excel to json format
        } else if (type.equalsIgnoreCase("csv")){
            fileType = ".csv";
            FindFilesName.listFiles(fileLocation,fileType); //search csv files inside the folder
            CSVtoJSON.getCSVPath(); //convert csv to json format
        }else {
            System.out.println("Sorry, this file type cannot be convert. Please type" +
                    "excel or csv");
        }
    }

    /**
     * Send the input files directory location.
     *
     * @return fileLocation  csv,excel file directory
     */
    public static String getFileLocation(){
        return fileLocation;
    }

}