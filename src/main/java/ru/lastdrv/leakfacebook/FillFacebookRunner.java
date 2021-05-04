package ru.lastdrv.leakfacebook;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
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

    private final int packSize;
    private final FacebookService facebookService;
    private final String fileParse;
    private List<FacebookEntity> listForSave = new ArrayList<>();


    public FillFacebookRunner(FacebookService facebookService,
                              @Value("${file.parse}") String fileParse,
                              @Value("${file.pack_size}") int packSize) {
        this.facebookService = facebookService;
        this.fileParse = fileParse;
        this.packSize = packSize;
    }

    @Override
    public void run(ApplicationArguments args) {

        log.info("Start...");
        try {
            CsvMapper mapper = new CsvMapper();
            File file = new File(fileParse);
            MappingIterator<CSVData> readValues = mapper
                    .readerFor(CSVData.class)
                    .with(CSVData.getSchema())
                    .readValues(file);
            while (readValues.hasNext()) {
                CSVData csvData = readValues.next();
                fillFacebookListAndSavePack(csvData);
            }
            if (!listForSave.isEmpty()) {
                facebookService.saveAll(listForSave);
            }
        } catch (Exception e) {
            log.error("Error.", e);
        }
        log.info("End.");
    }

    private void fillFacebookListAndSavePack(CSVData csvData) {
        FacebookEntity facebookEntity = CSVToFacebook(csvData);
        listForSave.add(facebookEntity);
        if (listForSave.size() == packSize) {
            facebookService.saveAll(listForSave);
            listForSave = new ArrayList<>();
        }
    }

    private FacebookEntity CSVToFacebook(CSVData csvData) {
        FacebookEntity facebookEntity = new FacebookEntity();
        facebookEntity.setPhone(csvData.getPhone());
        facebookEntity.setId(csvData.getId());
        facebookEntity.setFirstName(csvData.getFirstName());
        facebookEntity.setSecondName(csvData.getSecondName());
        facebookEntity.setSex(csvData.getSex());
        facebookEntity.setCity(csvData.getCity());
        facebookEntity.setRegion(csvData.getRegion());
        facebookEntity.setStatus(csvData.getStatus());
        facebookEntity.setWork(csvData.getWork());
        facebookEntity.setDate(csvData.getDatePart1() + ":" + csvData.getDatePart2() + ":" + csvData.getDatePart3());
        facebookEntity.setUnknown(csvData.getUnknown());
        facebookEntity.setBirthday(csvData.getBirthday());
        return facebookEntity;
    }
}
