package searchingFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * The function of searchingFile.FindFilesName class is find suitable file names
 * when user give as the input.
 *
 * @author : Eranda Upeshitha
 * @version : 1.0
 * @since : 2021/03/09
 */
public class FindFilesName {

    public List<String> listFiles(String location, String extension){

        SearchFiles files = new SearchFiles(extension);
        File folder = new File(location);
        List<String> fileLocation = new ArrayList<>();

        if (folder.isDirectory() == false){
            System.out.println("Folder does not exists: " +location);
            return null;
        }

        String[] list = folder.list(files);

        if (list.length == 0){
            System.out.println("There are no files with "+extension +" extensions.");
            return null;
        }
        for(String file : list){
            String temp = new StringBuffer(location).append(File.separator).append(file).toString();
            fileLocation.add(temp);
        }
        return fileLocation;
    }
}