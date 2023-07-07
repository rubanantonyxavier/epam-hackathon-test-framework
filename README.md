# MADL Services Test Automation Framework
This is the test automation tool for the MADL services

## Run tests
Use `cucumber` gradle-task for running tests

### Examples:
`gradle clean cucumber` - run all tests in single thread

`gradle clean cucumber -P tags="@idp" -P threads=10` - run only _idp_ tests in parallel in 10 threads

To run UI tests in headless browser, add either `-Dheadless_browser` flag to execution command or add a `headless_browser` env var with any value except `false`

E.g.: `gradle clean cucumber -P tags="@ui"` - tests run in usual browser mode 

`gradle clean cucumber -P tags="@ui" -Dheadless_browser=false` - tests run in usual browser mode 

`gradle clean cucumber -P tags="@ui" -Dheadless_browser` - tests run in headless browser mode 

### Env:
Environment can be specified with the `ENV` environment variable:
```properties
ENV=QA
```

Services URLs are specified in environmental config files:
```shell
src/main/resources/config-dev.yaml
src/main/resources/config-qa.yaml
src/main/resources/config-uat.yaml
```

### Browser:
To run UI tests the `BROWSER` environment variable should have `CHROME` or `FIREFOX` value accordingly. In case the env var is not specified, **Chrome** browser wil be used.
```properties
BROWSER=CHROME
```
Also, as an alternative to `-Dheadless_browser` system property, it is possible to use the `headless_browser` env var to run UI tests in headless browser:
```properties
headless_browser=true
```

### Credentials:
Creds are set with environment variables:
```properties
###For C2D###
C2D_ORDER_USER
C2D_ORDER_PSWD
C2D_CONTRACT_USER
C2D_CONTRACT_PSWD
C2D_CONTRACT2_USER
C2D_CONTRACT2_PSWD

###For LSR###
LSR_CONTRACT_USER
LSR_CONTRACT_PSWD

###For RQ###
RQ_ORDER_USER
RQ_ORDER_PSWD
RQ_CONTRACT_USER
RQ_CONTRACT_PSWD
```

### Scenario filtering:
`-P tags=@IDP_006` - to run scenario with _@IDP_006_ tag only,

`-P tags="@idp and @income"` - to run only scenarios with both the _@idp_ and _@income_ tags

`-P tags="@idp or @income"` - to run only scenarios with either the _@idp_ or _@income_ tags

`-P tags="@api and not @html"` - to run `@api` tests and exclude `@html` tags

### Parallel running:
`-P threads=10`

## Tests development

### Tags:
You can mark a scenario with any tag for filtering purpose. A scenario can have any number of tags. Cucumber tags are inherited by hierarchy:
1. Feature
2. Scenario
3. Examples

A tag can be defined on each of these levels. Examples have all the tags that were defined on Scenario scope. Scenarios have tags defined on their Feature scope.

Please follow this convention:
* tag should start with `@` character
* tag name is lowercase
* if tag is more than one word, use `_` character as a space
* Alerts in cucumber-java are case-sensitive

### Env-dependent exclusion: 
if you need to make some scenario to be environment specific, add a tag `@dev_only`, `@qa_only` or `@uat_only` accordingly. See _[IDP_070 - LSFM IDP Borrower Alert Validation](src/test/resources/features/ript/non_fcra/lsfm/alerts/idp/IDP_Alerts_Borrower.feature)_ scenario as an example:
```gherkin
    @dev_only
    Examples:
      | alert_id | ExternalTag                          |
      | IDP_070  | LSF_INPUT_STANDARDIZED_DIFFER_ONFILE |

    @qa_only
    Examples:
      | alert_id | ExternalTag                              |
      | IDP_070  | IDP_REO_INPUT_STANDARDIZED_DIFFER_ONFILE |
```
or
```gherkin
@qa_only
@IDP_071
  Scenario Outline: [IDP_071] LSFM IDP Borrower Alert Validation
  Input REO address previously owned by borrower
    Given the request XML filepath is /ript/non_fcra/lsfm/alerts/idp/<alert_id>.xml
    When the request is sent
    Then response content type is XML
    And successful LSFM report is received
```

### Specifying path to a request body
In step `Given the request XML filepath is /ript/fcra/lsfm/alerts/idp/<alert_id>.xml` path should be specified relatively to `test/resources/xmls` folder. 

E.g.: to reference `src/test/resources/xmls/ript/fcra/lsfm/alerts/cust/CUST_001.xml` you should specify `/ript/fcra/lsfm/alerts/cust/CUST_001.xml`

## How tests separated with tags

All the scenarios are marked with tags for better filtering and scope defining. You can review our scenario repository in `src/test/resources/features` but principle the next:

* Alerts in cucumber-java are case-sensitive 
* All the scenarios can be either `@api` or `@ui`
* API tests can be `@html` and regular (`not @html`)
* API non-HTML tests can be `@alerts` or `@section`
* All RiPT and RQ tests are divided to `@lsfm`, `@lsrm`, `@lscm`   
* All RiPT API (HTML/non-HTML) tests are divided to `@fcra`, `@non_fcra`
* All HTML tests are divided into sections using appropriate tags. E.g.: `@fraud`, `@property_detail`, `@subject_property_report`, `@third_party` etc. 
* All the scenarios have tags according to test case Jira tag e.g.: `@MADLRVP-10686` except alert tests
* All alert tests have tags according to their alert id e.g.: `@ASC_001`, `IDP_003` or `MNLS_002`
* Alert tests are divided by alerts family like `@asc`, `@hp` or `@idp`
* Alert tests are divided by alert category (_Category_ attribute in an _Alert_ node) like `@broker`, `@borrower`, `@income`
* Scenarios dedicated to only one env tagged with `@qa_only`, `@dev_only`, `@uat_only` and `@prod_only` accordingly. E.g.: _Running all tests on UAT, `@qa_only`, `@dev_only` and `@prod_only` tests will be skipped._
* To define Smoke scope, the `@smoke` tag is used. Marking any test with the tag, makes the test a part of daily smoke run.
* UI tests divided by product: `@rq`, `@lsr`
* LSR tests divided by testing area: `@search`, `@order`
* As a separate package of tests, there are `@c2d` tests