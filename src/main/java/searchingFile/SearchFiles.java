package searchingFile;

import java.io.File;
import java.io.FilenameFilter;

/**
 * The function of searchingFiles class is used for match the extension
 * of file that user want.
 *
 * @author : Eranda Upeshitha
 * @version : 1.0
 * @since : 2021/03/09
 */
public class SearchFiles implements FilenameFilter {

    private String extension;

    public SearchFiles(String extension){
        this.extension = extension;
    }

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