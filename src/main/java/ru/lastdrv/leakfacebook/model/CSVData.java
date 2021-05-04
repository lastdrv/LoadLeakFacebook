package ru.lastdrv.leakfacebook.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CSVData {

    @JsonProperty("phone")
    long phone;

    @JsonProperty("id")
    long id;

    @JsonProperty("first_name")
    String firstName;

    @JsonProperty("second_name")
    String secondName;

    @JsonProperty("sex")
    String sex;

    @JsonProperty("city")
    String city;

    @JsonProperty("region")
    String region;

    @JsonProperty("status")
    String status;

    @JsonProperty("work")
    String work;

    @JsonProperty("date_part_1")
    String datePart1;
    @JsonProperty("date_part_2")
    String datePart2;
    @JsonProperty("date_part_3")
    String datePart3;

    @JsonProperty("email")
    String email;

    @JsonProperty("birthday")
    String birthday;


    public static CsvSchema getSchema() {
        return CsvSchema.builder()
                .addColumn("phone", CsvSchema.ColumnType.NUMBER)
                .addColumn("id", CsvSchema.ColumnType.NUMBER)
                .addColumn("first_name", CsvSchema.ColumnType.STRING)
                .addColumn("second_name", CsvSchema.ColumnType.STRING)
                .addColumn("sex", CsvSchema.ColumnType.STRING)
                .addColumn("city", CsvSchema.ColumnType.STRING)
                .addColumn("region", CsvSchema.ColumnType.STRING)
                .addColumn("status", CsvSchema.ColumnType.STRING)
                .addColumn("work", CsvSchema.ColumnType.STRING)
                .addColumn("date_part_1", CsvSchema.ColumnType.STRING)
                .addColumn("date_part_2", CsvSchema.ColumnType.STRING)
                .addColumn("date_part_3", CsvSchema.ColumnType.STRING)
                .addColumn("email", CsvSchema.ColumnType.STRING)
                .addColumn("birthday", CsvSchema.ColumnType.STRING)
                .setColumnSeparator(':')
                .disableQuoteChar()
                .build();
    }
}
