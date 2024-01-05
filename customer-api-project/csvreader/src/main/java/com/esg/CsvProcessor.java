package com.esg;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.List;

import com.google.gson.Gson;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class CsvProcessor<T> {

    public String parseCsvToJson(String csvPath, Class<T> infoType) throws FileNotFoundException {
        // get items from csv
        List<T> csvItems = readCsv(csvPath, infoType);

        // convert to JSON
        String jsonItems = convertToJson(csvItems);

        return jsonItems;
    }

    public List<T> readCsv(String csvPath, Class<T> infoType) throws FileNotFoundException {
        // configuring to read csv and convert to customer object
        Reader reader = new BufferedReader(new FileReader(csvPath));
        CsvToBean<T> csvReader = new CsvToBeanBuilder<T>(reader)
                .withType(infoType)
                .withSeparator(',')
                .withIgnoreLeadingWhiteSpace(true)
                .withIgnoreEmptyLine(true)
                .withSkipLines(1) // first line is the headers
                .build();

        return csvReader.parse();
    }

    public String convertToJson(List<T> items) {
        Gson gson = new Gson();
        return gson.toJson(items);
    }

}
