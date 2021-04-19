package org.learning.venu.exceloperations;

import org.junit.jupiter.api.Test;
import sun.rmi.runtime.Log;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Function;
import java.util.logging.Logger;

public class FolderUtilsTest {

    static Logger logger = Logger.getLogger(FolderUtilsTest.class.getName());

    @Test
    public void applyFunctionOnEachExcelFileTest() {

        Path path = Paths.get("src","test","resources");

        logger.info(""+path.toAbsolutePath());
        Function<File, Boolean> function = file -> {
            System.out.println("Inside test function");
            System.out.println(file.getAbsolutePath());
            return true;
        };
        Boolean continueOnFail = false;

        FolderUtils.applyFunctionOnEachExcelFile(path.toString(),function,continueOnFail);

    }
}
