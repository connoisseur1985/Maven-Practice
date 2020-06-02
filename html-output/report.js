$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("C:/Users/Dell/eclipse-workspace/MavenPractice/src/test/java/features/HomePage.feature");
formatter.feature({
  "line": 1,
  "name": "To check homepage functionality",
  "description": "",
  "id": "to-check-homepage-functionality",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 3,
  "name": "Home Page check",
  "description": "",
  "id": "to-check-homepage-functionality;home-page-check",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "user opens the browser",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "user enters \"\u003curl\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "user clicks on enter",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "home page is opened",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "user validates home page",
  "keyword": "Then "
});
formatter.examples({
  "line": 11,
  "name": "",
  "description": "",
  "id": "to-check-homepage-functionality;home-page-check;",
  "rows": [
    {
      "cells": [
        "url"
      ],
      "line": 12,
      "id": "to-check-homepage-functionality;home-page-check;;1"
    },
    {
      "cells": [
        "https://www.amazon.in"
      ],
      "line": 13,
      "id": "to-check-homepage-functionality;home-page-check;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 13,
  "name": "Home Page check",
  "description": "",
  "id": "to-check-homepage-functionality;home-page-check;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "user opens the browser",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "user enters \"https://www.amazon.in\"",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "user clicks on enter",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "home page is opened",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "user validates home page",
  "keyword": "Then "
});
formatter.match({
  "location": "HomePage.user_opens_browser()"
});
formatter.result({
  "duration": 7209678894,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "https://www.amazon.in",
      "offset": 13
    }
  ],
  "location": "HomePage.user_enters_url(String)"
});
formatter.result({
  "duration": 8612511407,
  "status": "passed"
});
formatter.match({
  "location": "HomePage.user_clicks_on_enter()"
});
formatter.result({
  "duration": 11693834719,
  "status": "passed"
});
formatter.match({
  "location": "HomePage.home_page_is_opened()"
});
formatter.result({
  "duration": 330321214,
  "status": "passed"
});
formatter.match({
  "location": "HomePage.user_validates_home_page()"
});
formatter.result({
  "duration": 111373309,
  "status": "passed"
});
});