package home;

import csvConvert.CSVtoJSON;
import excelConvert.ExceltoJSON;
import searchingFile.FindFilesName;

import java.io.IOException;
import java.util.Scanner;

/**
 * The Home.Home class implements the main controller of the project.
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

    public void chooseFileType(){
        Scanner input = new Scanner(System.in);

        System.out.println("What type of files do you want to convert to JSON? \n" +
                "excel or csv");
        userInput = input.nextLine();
    }

    public void convertFile(String type) throws IOException {
        if (type.equalsIgnoreCase("excel")){
            fileType = ".xlsx";
            FindFilesName.listFiles(fileLocation,fileType);
            ExceltoJSON.getFilePath();
        } else if (type.equalsIgnoreCase("csv")){
            fileType = ".csv";
            FindFilesName.listFiles(fileLocation,fileType);
            CSVtoJSON.getCSVPath();
        }else {
            System.out.println("Sorry this file type cannot be convert");
        }
    }

}