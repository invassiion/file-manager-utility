import com.example.filemanager.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.io.IOException;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;


public class FileFilteringTest {
   @Mock
   private FileManager fileManager;

   @Mock
   private DataProcessor dataProcessor;

   @Mock
   private StatisticCollector statisticCollector;

  @BeforeEach
   void setUp() {
       MockitoAnnotations.openMocks(this);
   }

   @Test
   void testNoInputFiles() {
       String[] args = {"-s"};
       ArgumentParser argumentParser = ArgumentParser.parseArgs(args);
       assertTrue(argumentParser.getInputFiles().isEmpty());
   }


   @Test
   void  testFileProcessing() throws IOException {
       String[] args = {"-s", "-a", "-p", "sample_", "input-files/in1.txt", "input-files/in2.txt"};
       ArgumentParser argumentParser = ArgumentParser.parseArgs(args);

       when(fileManager.readLines(anyList())).thenReturn(Arrays.asList("1", "2.5", "test"));

       FileFiltering.runFiltering(argumentParser, fileManager, dataProcessor,statisticCollector);

       verify(fileManager, times(1)).readLines(argumentParser.getInputFiles());
       verify(dataProcessor, times(1)).processLine("1");
       verify(dataProcessor, times(1)).processLine("2.5");
       verify(dataProcessor, times(1)).processLine("test");


   }

}
