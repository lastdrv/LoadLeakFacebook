package ru.lastdrv.leakfacebook.EntryPoints;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import ru.lastdrv.leakfacebook.model.CSVData;

import java.io.File;
import java.util.Collections;
import java.util.List;

@Slf4j
public class FillFacebook {

    private final String fileParse;

    public FillFacebook(@Value("${file.parse}") String fileParse) {
        this.fileParse = fileParse;
        log.info("Start...");
        List<CSVData> csvDataList = loadObjectList(CSVData.class, CSVData.getSchema());
    }

    public <T> List<T> loadObjectList(Class<T> type, CsvSchema csvSchema) {
        try {
            CsvMapper mapper = new CsvMapper();
            File file = new ClassPathResource(fileParse).getFile();
            MappingIterator<T> readValues = mapper.readerFor(type).with(csvSchema).readValues(file);
            return readValues.readAll();
        } catch (Exception e) {
            log.error("Error occurred while loading object list from file " + fileParse, e);
            return Collections.emptyList();
        }
    }
}
