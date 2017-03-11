package se2xb3.data.source;

import java.io.*;

/**
 * @author Dawson
 * @version 1.0
 * @since 3/10/2017
 */
public class DataSource {
    private BufferedReader input;
//    private BufferedInputStream input;

    public DataSource(Reader in) {input = new BufferedReader(in);}

    public  String read(){

        try {
            return input.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
