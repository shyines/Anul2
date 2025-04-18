package utils;

import com.pt.a2.model.SimulationData;
import com.pt.a2.utils.LogFileFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LogFileFactoryTests {
    SimulationData data;

    @BeforeEach
    void setup() {
        data = SimulationData.create(new String[0]);
    }

    @Test
    void test_create_returnsCorrectFileName() {
        var pathname = LogFileFactory.getPathName(data);
        System.out.println(pathname);
    }
}
