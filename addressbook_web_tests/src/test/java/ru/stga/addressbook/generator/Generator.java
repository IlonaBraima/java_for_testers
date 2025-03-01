package ru.stga.addressbook.generator;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import ru.stga.addressbook.common.CommonFunctions;
import ru.stga.addressbook.model.GroupData;
import ru.stga.addressbook.model.UserData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Generator {

    @Parameter(names={"--type", "-t"})
    String type;

    @Parameter(names={"--output", "-o"})
    String output;

    @Parameter(names={"--format", "-f"})
    String format;

    @Parameter(names={"--count", "-n"})
    int count;


    public static void main(String[] args) throws IOException{
        var generator = new Generator();
        JCommander.newBuilder()
            .addObject(generator)
            .build()
            .parse(args);
        generator.run();
    }

    private void run() throws IOException{
        var data = generate();
        save(data);
    }

    private Object generate() {
        if("groups".equals(type)) {
            return generateGroups();
        } else if ("users".equals(type)) {
            return generateUsers();
        } else {
            throw new IllegalArgumentException("Неизвестный тип данных" + type);
        }
    }

    private Object generateData(Supplier<Object> dataSupplier) {
        return Stream.generate(dataSupplier).limit(count).collect(Collectors.toList());
    }

    private Object generateGroups() {
        return generateData(() -> new GroupData()
                .withName(CommonFunctions.randomString(10))
                .withHeader(CommonFunctions.randomString(10))
                .withFooter(CommonFunctions.randomString(10)));
    }

    private Object generateUsers() {
        return generateData(() -> new UserData()
                    .withFirstName(CommonFunctions.randomString( 10))
                    .withLastName(CommonFunctions.randomString( 10))
                    .withMiddleName(CommonFunctions.randomString( 10)));
    }

    private void save(Object data) throws IOException {
        if ("json".equals(format)) {
            ObjectMapper mapper = new ObjectMapper(); // create once, reuse
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            var json = mapper.writeValueAsString(data);


            //автоматический вызов закрытия файла

            try(var writer = new FileWriter(output)) {
                writer.write(json);
            }
            //принудительное закрытие файла, т.к. сам в Java он не закроется
//            var writer = new FileWriter(output);
//            writer.write(json);
//            writer.close();
            return;

        } if ("yaml".equals(format)) {
            var mapper = new YAMLMapper();
            mapper.writeValue(new File(output), data);
            return;

        } if ("xml".equals(format)) {
            var mapper = new XmlMapper();
            mapper.writeValue(new File(output), data);
        } else {
            throw new IllegalArgumentException("Неизвестный формат данных" + format);
        }
    }

}
