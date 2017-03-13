package se2xb3.io.source;

import se2xb3.config.Constants;
import se2xb3.io.IOController;
import se2xb3.tests.TestDataSource;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * A class that extends the abstract class DataSource that is used to read
 * data from a file and stream it into the system as each line is read.
 * @author Dawson Myers
 * @version 1.0
 * @since 3/10/2017
 */
public class FileDataSource extends DataSource implements Constants {

    /**
     * Constructor that takes an IOController instance.
     *
     * @param controller
     */
    public FileDataSource(IOController controller) {
        super(controller);
        setUrl(INPUT_FILE);
    }

    /**
     * This method is called when the thread is started (a hook). It begins the
     * process of reading data from a data source.
     */
    @Override void startSource() {
        readData();
    }


    /**
     * Begin reading tweets from a file. Each line of text is one JSON
     * encoded tweet. The strings are added to the queue as they are read.
     */
    public void readData() {

        try (BufferedReader br = new BufferedReader(new FileReader(url))) {
            String line = "";

//            int count = 0;

            // read all lines in file and insert them into the queue
            while ((line = br.readLine()) != null) {

//                queue.enqueue("Msg "+count++);
                queue.enqueue(line);
            }

            println("Finished reading file");

           if(TestDataSource.testing) TestDataSource.endTest();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
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

