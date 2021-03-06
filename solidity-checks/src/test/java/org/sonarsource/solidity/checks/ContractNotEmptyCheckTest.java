package org.sonarsource.solidity.checks;

import org.junit.Test;

public class ContractNotEmptyCheckTest {

  @Test
  public void test() {
    new CheckVerifier(new ContractNotEmptyCheck(), "src/test/resources/ContractNotEmptyCheck/test.sol");
  }

  @Test
  public void test_with_compliant() {
    new CheckVerifier(new ContractNotEmptyCheck(), "src/test/resources/ContractNotEmptyCheck/test_noncompliant_and_compliant.sol");
  }
}
