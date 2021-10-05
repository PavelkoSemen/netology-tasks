package ru.netology.parsecsv;

import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.extern.slf4j.Slf4j;
import ru.netology.entity.Employee;
import ru.netology.myexception.CsvParserException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import static ru.netology.fileutil.FileUtil.*;

@Slf4j
public class CsvParser {
    public static List<Employee> parseCSV(String[] columnMapping, String fileName) throws CsvParserException {
        try (CSVReader csvReader = new CSVReader(
                new InputStreamReader(getReaderFromResources(fileName))
        )) {
            log.info("Start csv parsing '{}' file", fileName);
            ColumnPositionMappingStrategy<Employee> mappingStrategy = new ColumnPositionMappingStrategy<>();
            mappingStrategy.setType(Employee.class);
            mappingStrategy.setColumnMapping(columnMapping);

            CsvToBean<Employee> csvToBean = new CsvToBeanBuilder<Employee>(csvReader)
                    .withMappingStrategy(mappingStrategy)
                    .build();
            log.info("Finish csv parsing '{}' file", fileName);
            return csvToBean.parse();
        } catch (IOException e) {
            log.error("Error csv parsing", e);
        } catch (NullPointerException e) {
            log.error("File '{}' not found", fileName);
        }
        throw new CsvParserException("Error parsing '" + fileName + "' file");
    }

}
