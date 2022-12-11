package arcadia.utils;

import arcadia.mapperObjects.TestMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class ConversionUtil {
    private Properties properties;
    public TestMapper getTestMapperConfig(String testIdentifier) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<TestMapper> mapperList = objectMapper.readValue(new File("src/test/resources/testMapper.json"), new TypeReference<List<TestMapper>>(){});
        return mapperList.stream().filter(x->x.getTestName().trim().equals(testIdentifier.trim())).findFirst().get();
    }
}
