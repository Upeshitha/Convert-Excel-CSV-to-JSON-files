package searchingFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * The function of FindFilesName class is find match file names
 * when user gives the extension.
 *
 * @author : Eranda Upeshitha
 * @version : 1.0
 * @since : 2021/03/09
 */
public class FindFilesName {

    private static List<String> fileLocation = new ArrayList<>();

    /**
     * search user type file type is there in the folder.
     *
     * @param location   get full file location
     * @param extension  get file extension
     */
    public static void listFiles(String location, String extension){

        SearchFiles files = new SearchFiles(extension);
        File folder = new File(location);

        if (folder.isDirectory() == false){
            System.out.println("Folder does not exists: " +location);
            return;
        }

        String[] list = folder.list(files);

        if (list.length == 0){
            System.out.println("There are no files with "+extension +" extensions.");
            return;
        }
        for(String file : list){
            String temp = new StringBuffer(location).append(File.separator).append(file).toString();
            fileLocation.add(temp);
        }

    }

    /**
     * Send user want files with full directory name
     *
     * @return fileLocation which is a list collection that stores data
     * as a string data type
     * fileLocation is included full directory with file names which are
     * required to convert to json format
     */
    public List<String> sendLocation(){
        return fileLocation;
    }
}