package org.home.data;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DataFileReader {

    public static Object[][] getSearchData(String searchDataFilePath){

        File searchData = new File(searchDataFilePath);
        String line;
        int linesCount = 0;
        Object[][] data = null;

        try (FileReader fileReader = new FileReader(searchData);
             BufferedReader bufferedReader = new BufferedReader(fileReader)){

            while ((line = bufferedReader.readLine()) != null){
                if (!line.isEmpty()){
                    linesCount++;
                }
            }

            data = new Object[linesCount][1];
            linesCount = 0;

            BufferedReader newBufferedReader = new BufferedReader(new FileReader(searchData));

            while ((line = newBufferedReader.readLine()) != null){

                if (line.isEmpty()){
                    continue;
                }

                data[linesCount][0] = line;
                linesCount++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}
