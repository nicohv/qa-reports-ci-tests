*** Settings ***
Library     com.clarolab.MyRobotKeywords

Force Tags  all
Test Setup      Init Test
Test Teardown   Close Test


*** Test Cases ***
pass test case
    Pass Test

fail test case
    ${output} =     Fail Test
    Should Be True  ${output}

exception test case
    Exception Test

*** Keywords ***
Close Test
    Take Screen Shot
    Clean Test

