package ru.stga.addressbook.tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import ru.stga.addressbook.common.CommonFunctions;
import ru.stga.addressbook.model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GroupCreationTest extends TestBase {


    public static List<GroupData> groupProvider() throws IOException {
        var result = new ArrayList<GroupData>();
//        for (var name : List.of("", "group name")) {
//            for (var header : List.of("", "group header")) {
//                for (var footer : List.of("", "group footer")) {
//                    result.add(new GroupData()
//                            .withName(name)
//                            .withHeader(header)
//                            .withFooter(footer));
//                }
//            }
//        }

        // генератор случайных названий
//        for (int i = 0; i < 5; i++) {
//            result.add(new GroupData()
//                    .withName(CommonFunctions.randomString(i * 10))
//                    .withHeader(CommonFunctions.randomString(i * 10))
//                    .withFooter(CommonFunctions.randomString(i * 10)));
//       }


        //чтение файлов 2-ый способ. Читаем построчно
//        var json = "";
//        try (var reader = new FileReader("groups.json");
//        var breader = new BufferedReader(reader)
//        ){
//            var line = breader.readLine();
//            while (line != null) {
//                json = json + line;
//                line = breader.readLine();
//            }
//        }

//        ObjectMapper mapper = new ObjectMapper();
//        var value = mapper.readValue(json, new TypeReference<List<GroupData>>() {
//        });
//        result.addAll(value);
//        return result;
//    }

        //чтение файлов 1-ый способ. Чтение файла целиком
//        var json = Files.readString(Paths.get("groups.json"));
//        ObjectMapper mapper = new ObjectMapper();
//        var value = mapper.readValue(json, new TypeReference<List<GroupData>>() {
//        });
//        result.addAll(value);
//        return result;
//    }

    //чтение файлов XML

    ObjectMapper mapper = new XmlMapper();
    var value = mapper.readValue(new File("groups.xml"), new TypeReference<List<GroupData>>() {
    });
        result.addAll(value);
        return result;
}
        //reader отрабатывает библиотека jekson
//        ObjectMapper mapper = new ObjectMapper();
//        var value = mapper.readValue(new File("groups.json"), new TypeReference<List<GroupData>>() {});
//        result.addAll(value);
//        return result;
//    }

    public static List<GroupData> singleRandomGroup() {
        return List.of(new GroupData()
                .withName(CommonFunctions.randomString(10))
                .withHeader(CommonFunctions.randomString(20))
                .withFooter(CommonFunctions.randomString(30)));
    }

    @ParameterizedTest
    @MethodSource("singleRandomGroup")

    public void CanCreateGroups(GroupData group) {
        var oldGroups = app.jdbc().getGroupList();
        app.groups().createGroup(group);
        var newGroups = app.jdbc().getGroupList();
        Comparator<GroupData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newGroups.sort(compareById);
        var maxId = newGroups.get(newGroups.size() - 1).id();


        var expectedList = new ArrayList<>(oldGroups);
        expectedList.add(group.withId(maxId));
        expectedList.sort(compareById);
        Assertions.assertEquals(newGroups, expectedList);

    }

    public static List<GroupData> NegativeGroupProvider() {
        var result = new ArrayList<GroupData>(List.of(
                new GroupData("", "group name'", "", "")));
        return result;
    }

//    @ParameterizedTest
//    @MethodSource("NegativeGroupProvider")
//
//    public void canNotCreateGroup(GroupData group) {
//        var oldGroups = app.groups().getList();
//        app.groups().createGroup(group);
//        var newGroups = app.groups().getList();
//        Assertions.assertEquals(newGroups, oldGroups);
//    }

}
