package generator;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import common.CommonFunctions;
import model.ContactData;
import model.GroupData;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static common.CommonFunctions.randomFile;
import static common.CommonFunctions.randomInt;

public class Generator {

    @Parameter(names = {"--type", "-t"})
    String type;

    @Parameter(names = {"--output", "-o"})
    String output;

    @Parameter(names = {"--format", "-f"})
    String format;

    @Parameter(names = {"--count", "-n"})
    int count;

    public static void main(String[] args) throws IOException {
        var generator = new Generator();
        JCommander.newBuilder()
                .addObject(generator)
                .build()
                .parse(args);
        generator.run();

    }

    private void run() throws IOException {
        var data = generate();
        save(data);
    }

    private Object generate() {
        if ("groups".equals(type)) {
            return generateGroups();
        } else if ("contacts".equals(type)) {
            return generateContacts();
        } else {
            throw new IllegalArgumentException("Неизвестный тип данных " + type);
        }
    }


    private Object generateGroups() {
        var result = new ArrayList<GroupData>();
        for (int i = 0; i < count; i++) {
            result.add(new GroupData()
                    .withName(CommonFunctions.randomString(i * 10))
                    .withHeader(CommonFunctions.randomString(i * 10))
                    .withFooter(CommonFunctions.randomString(i * 10)));
        }
        return result;
    }

    private Object generateContacts() {
        var result = new ArrayList<ContactData>();
        for (int i = 0; i < count; i++) {
            result.add(new ContactData()
                    .withfirstname(CommonFunctions.randomString(5))
                    .withMiddlename(CommonFunctions.randomString(5))
                    .withLastname(CommonFunctions.randomString(5))
                    .withNickname(CommonFunctions.randomString(5))
                    .withTitle(CommonFunctions.randomString(5))
                    .withCompany(CommonFunctions.randomString(5))
                    .withAddress(CommonFunctions.randomString(5))
                    .withHome(randomInt(6))
                    .withMobile("+7" + randomInt(10))
                    .withWork(randomInt(6))
                    .withFax(randomInt(6))
                    .withEmail(CommonFunctions.randomString(5) + "@list.ru")
                    .withEmail2(CommonFunctions.randomString(5) + "@list.ru")
                    .withEmail3(CommonFunctions.randomString(5) + "@list.ru")
                    .withHomepage(CommonFunctions.randomString(5))
                    .withPhoto(randomFile("src/test/resources/images")));
        }
        return result;
    }

    private void save(Object data) throws IOException {
        if("json".equals(format)){
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            var json = mapper.writeValueAsString(data);

            try (var writer = new FileWriter(output)){
                writer.write(json);
            }

        } if("yaml".equals(format)){
            var mapper = new YAMLMapper();
            mapper.writeValue(new File(output), data);
        } if("xml".equals(format)) {
            var mapper = new XmlMapper();
            mapper.writeValue(new File(output), data);
        }else {
            throw new IllegalArgumentException("Неизвестный формат данных " + format);
        }


    }
}
