@Facebook
Feature: To Automate Creating of Group and Sending Images

Scenario: To create a Facebook Post
Given Facebook is open
And I login using "vishalcool.vaitheeswaran" username and "ind-pplmt0000382" password
And I click login
And I Add Images from file "/Users/vishalvaitheeswaranrk/eclipse-workspace/SocialMediaManager/src/test/java/Images" and Caption from file "/Users/vishalvaitheeswaranrk/eclipse-workspace/SocialMediaManager/src/test/java/resources/Dummy.txt"
And I post content