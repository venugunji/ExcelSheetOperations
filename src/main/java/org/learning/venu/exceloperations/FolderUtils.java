package org.learning.venu.exceloperations;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.List;
import java.util.function.Function;
import java.util.logging.Logger;

public class FolderUtils {
   static Logger logger = Logger.getLogger(FolderUtils.class.getName());

    public static void applyFunctionOnEachExcelFile(String folderPath, Function<File, Boolean> function, Boolean continueOnFail) {
        List<File> fileList = (List<File>) FileUtils.listFiles(new File(folderPath), new String[]{"xlsx"}, false);
        logger.info("List of Files : "+fileList);
        for (File file :
                fileList) {
            Boolean status = function.apply(file);
            if (!status & !continueOnFail) {
                break;
            }
        }
    }
}
