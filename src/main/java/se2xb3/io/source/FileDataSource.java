package se2xb3.io.source;

import org.slf4j.Logger;
import se2xb3.config.Constants;
import se2xb3.control.AppController;
import se2xb3.io.IOController;
import se2xb3.io.files.FileFinder;

import java.io.*;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * A class that extends the abstract class DataSource that is used to read
 * data from a file and stream it into the system as each line is read.
 *
 * @author Dawson Myers
 * @version 1.0
 * @since 3/10/2017
 */
public class FileDataSource extends DataSource implements Constants {
    private static final String _CLASS_NAME = FileDataSource.class.getSimpleName();
    private final static Logger log  = getLogger(_CLASS_NAME);
    /**
     * Constructor that takes an IOController instance.
     *
     * @param controller an instance of the IOController
     */
    public FileDataSource(IOController controller) {
        super(controller);
        setUrl(INPUT_FILE);
    }

    /**
     * This method is called when the thread is started (a hook). It begins the
     * process of reading data from a data source.
     */
    @Override
    void startSource() {
        readData();
    }


    /**
     * Begin reading tweets from a file. Each line of text is one JSON
     * encoded tweet. The strings are added to the queue as they are read.
     */
    public void readData() {
        //log.info("Beginning to read from file");
        File file = new File(INPUT_FILE);

        String filePath = "";

        // check is INPUT_FILE exists, if not, try to find it using INPUT_FILE_NAME
        if (!file.exists()) {
            log.info("INPUT_FILE " + INPUT_FILE + " not found. Beginning recursive search for it");
            filePath = FileFinder.findFileByName(INPUT_FILE_NAME, "txt");
        }

        // if length is greater than 1, a file was found
        if (filePath.length() > 0) {
            log.info("Input file " + INPUT_FILE_NAME + " found at path " +  filePath);
            url = filePath;
        }

        while (true) {
            try (BufferedReader br = new BufferedReader(new FileReader(url))) {
                String line = "";
                log.info("Beginning to read from file");
                int count = 0;

                // read all lines in file and insert them into the queue
                while ((line = br.readLine()) != null) {
                    //count++;
                    // simulate stream
                    try {
                        Thread.sleep(DATA_SOURCE_STREAM_RATE);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
//                queue.enqueue("Msg "+count++);
                    queue.enqueue(line);
                }

//                reset data and read it back in again
                AppController.getDataController().resetData();

//            println("Finished reading file");
                log.info("Finished reading file. Read " + count + " lines of data");
                //if(TestDataSource.testing) TestDataSource.endTest();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    ////////////////////////////////////////////////////////////
    public static void println(String s) {
        System.out.println(s);
    }

    public static void print(String s) {
        System.out.print(s);
    }

}

