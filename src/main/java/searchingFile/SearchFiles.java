package searchingFile;

import java.io.File;
import java.io.FilenameFilter;

/**
 * The function of searchingFiles class is used for match the extension
 * of file that user want.
 * This class is also implemented the FilenameFilter interface which is used
 * to filter files from the list of files.
 *
 * @author : Eranda Upeshitha
 * @version : 1.0
 * @since : 2021/03/09
 */
public class SearchFiles implements FilenameFilter {

    private String extension;

    /**
     * SearchFiles constructor, which is assign the user want
     * file extension.
     *
     * @param extension
     */
    public SearchFiles(String extension){
        this.extension = extension;
    }

    /**
     * implemented the FilenameFilter interface
     * used for every file is tested
     *
     * @param dir   directory name
     * @param name  file name
     * @return true/false  the filename starts with the specified initials
     *                     then return true else return false.
     */
    @Override
    public boolean accept(File dir, String name) {
        if(name.lastIndexOf('.') > 0){
            int lastIndex = name.lastIndexOf('.');
            String fileExt = name.substring(lastIndex); // get the extension

            //matching the extension
            if (fileExt.equalsIgnoreCase(extension)){
                return true;
            }
        }
        return false;
    }
}