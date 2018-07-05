package org.sonarsource.solidity.its;

import java.io.File;
import java.io.IOException;
import org.junit.Test;
import org.sonar.api.utils.log.Logger;
import org.sonar.api.utils.log.Loggers;

import static org.assertj.core.api.Assertions.assertThat;

public class SolidityRulingTest {

  private static final Logger LOG = Loggers.get(SolidityRulingTest.class);

  @Test
  public void test() {
    assertThat(SolidityRuling.getProjects()).hasSize(2);
    try {
      SolidityRuling.deletePreviouslyAnalyzedFiles();

      SolidityRuling.collectSolidityFiles();
      File file = new File(SolidityRuling.DIFFERENCES);

      System.out.println(file.exists());
      assertThat(file).doesNotExist();

      SolidityRuling.findDifferences();
      System.out.println(file.exists());
      assertThat(file).doesNotExist();
    } catch (IOException e) {
      LOG.debug(e.getMessage());
    }
  }
}
