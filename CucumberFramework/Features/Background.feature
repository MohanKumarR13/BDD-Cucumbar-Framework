@Background
Feature: Background explanation
Background: Student completed the school
Given Student complete hsc
Given Student complete school studies
Scenario: Study Medicine
	Given Student applied for medicine course
	When Student cleared exam
	Then Student joins the college


Scenario: Study Engineering
	Given Student applied for engineering course
	When Student has cut off
	Then Student joins the engineering college