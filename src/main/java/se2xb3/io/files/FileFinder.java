package se2xb3.io.files;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Iterator;

/**
 * A class to recursively find files.
 * @author Dawson Myers
 * @version 1.0
 * @since 3/29/2017
 */
public class FileFinder {

    public FileFinder() {}

    public static String findFileByName(String name, String extensions) {
        return findFileByName(name, ".", new String[]{extensions}, true);
    }
    public static String findFileByName(String name, String rootDir,String extensions) {
        return findFileByName(name, rootDir, new String[]{extensions}, true);
    }
    public static String findFileByName(String name, String rootDir,String extensions, boolean recursive) {
        return findFileByName(name, rootDir, new String[]{extensions}, recursive);
    }
    public static String findFileByName(String name, String rootDir,String[] extensions, boolean recursive) {

        File root = new File(rootDir);

        //String[] extensions = { "xml", "java", "dat" };

        Collection files = FileUtils.listFiles(root, extensions, recursive);

        String filePath = "";

        for (Iterator iterator = files.iterator(); iterator.hasNext();) {
            File file = (File) iterator.next();
            if (file.getName() != null && file.getName().equals(name)){
                filePath = file.getAbsolutePath();
            }
        }

        if (filePath.length() == 0) {
            try {
                throw new FileNotFoundException("Could not find file " + name + "in root dir " +
                                                        rootDir);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        return filePath;
    }

}
