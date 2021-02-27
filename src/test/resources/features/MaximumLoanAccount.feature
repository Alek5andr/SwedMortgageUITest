Feature: Find out monthly payment & maximum loan amount
  with different criterias

  Scenario Outline: Monthly payment & max loan amount
    Given navigation to "Mortgage loan" page
    When application for a loan <applicantPreposition> a co-applicant
    And there <dependentsPresence> dependants in family
    Then options to select dependents appear
    When <people> dependent(s) is selected
    And total monthly income <income> is set
    And there <obligationsPresence> existing loan obligations
    And loan amount <loan> is set
    And loan term <months> is set
    Then monthly loan payment is <payment>
    And maximum loan amount is <maxLoanAmount>

    Examples:
      | applicantPreposition | dependentsPresence | people | income | obligationsPresence | loan  | months | payment  | maxLoanAmount |
      | "without"               | "are"           | 2      | 1000   | "are no"            | 45000 | 132    | 386      | 49739         |