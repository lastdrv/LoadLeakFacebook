package ru.lastdrv.leakfacebook;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import ru.lastdrv.leakfacebook.model.CSVData;
import ru.lastdrv.leakfacebook.model.FacebookEntity;
import ru.lastdrv.leakfacebook.service.FacebookService;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class FillFacebookRunner implements ApplicationRunner {

    private final int PACK_SIZE = 3;
    private final FacebookService facebookService;
    private final String fileParse;


    public FillFacebookRunner(FacebookService facebookService, @Value("${file.parse}") String fileParse) {
        this.facebookService = facebookService;
        this.fileParse = fileParse;
    }

    @Override
    public void run(ApplicationArguments args) {

        log.info("Start...");
        try {
            CsvMapper mapper = new CsvMapper();
            File file = new ClassPathResource(fileParse).getFile();
            MappingIterator<CSVData> readValues = mapper
                    .readerFor(CSVData.class)
                    .with(CSVData.getSchema())
                    .readValues(file);
            List<FacebookEntity> listForSave = new ArrayList<>();
            int countFillPack = 0;
            while (readValues.hasNext()) {
                CSVData csvData = readValues.next();
                FacebookEntity facebookEntity = CSVToFacebook(csvData);
                listForSave.add(facebookEntity);
                countFillPack ++;
                if (countFillPack == PACK_SIZE - 1) {
                    log.info("test");
                }
            }
        } catch (Exception e) {
            log.error("Error occurred while loading object list from file " + fileParse, e);
        }
        log.info("End.");
    }
    private FacebookEntity CSVToFacebook(CSVData csvData) {
        return null;
    }
}
