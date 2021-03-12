package home;

import excelConvert.ExceltoJSON;
import searchingFile.FindFilesName;

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
    private static final String fileLocation = "E:\\User\\Downloads\\Files";

    public static void main(String[] args) {
        Main main = new Main();
        main.chooseFileType();
        FindFilesName.listFiles(fileLocation,fileType);
        ExceltoJSON.getFilePath();
    }

    public void chooseFileType(){
        Scanner input = new Scanner(System.in);

        System.out.println("What type of files do you want to convert to JSON? \n" +
                "excel or csv");
        fileType = input.nextLine();
    }

}