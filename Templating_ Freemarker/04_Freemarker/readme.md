Instuctions (without pics)

Notes

Open IntelliJ and first import the Google Style Guide schema, which you can find in the assignment directory.
The XML is imported via the settings under the path: Editor → Code Style → Java;
there, click the gear icon and select Import Scheme → IntelliJ IDEA code style XML.
Figure 1: Settings dialog for importing a formatting scheme

Code is formatted via Code → Reformat Code, or the corresponding shortcut.
The shortcut can be customized to suit individual preferences.
It is strongly recommended to know this shortcut, as the action is used quite frequently.

Formatting Java code according to this guideline is mandatory.

Tasks

1. Create a new Spring Boot project using IntelliJ and the Spring Initializr generator with the following settings:
a. Basic Information (Step 1):
i. Name: 04_Freemarker
ii. Location: <Path on the system drive>
iii. Language: Java
iv. Type: Maven
v. Group: de.thwildau.bibinfo
vi. Artifact: freemarker
vii. Package name: de.thwildau.bibinfo.freemarker (should be auto-filled after entering Group and Artifact)
viii. Java: 21
ix. Packaging: Jar
b. Dependencies (Step 2):
i. Spring Boot: 3.4.1 (top left of the window; a newer patch version can also be used)
ii. Lombok
iii. Spring Web
iv. Apache Freemarker

2. In the newly created project, there will be a base package de.thwildau.bibinfo.freemarker.
Create the following additional packages under this base package:
api → de.thwildau.bibinfo.freemarker.api
controller → de.thwildau.bibinfo.freemarker.controller
helper → de.thwildau.bibinfo.freemarker.helper
service → de.thwildau.bibinfo.freemarker.service
service.impl → de.thwildau.bibinfo.freemarker.service.impl

3. In the api package, create the three classes shown in Figure 2 with the respective fields
(only the fields, no additional methods).
Figure 2: Class diagram for Task 3

4. Use of Lombok
Lombok is a library that helps with boilerplate code, such as getter and setter methods.
It uses annotations that begin with @ and can be applied to classes, methods, fields, or parameters.
Lombok automatically generates methods like getters and setters.
Add the following class annotations to the DTO classes (EmployeeDto, PersonDto, and TeamDto):
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
Now view the structure of the classes in the IDE (under View → Tool Windows → Structure).
The result for EmployeeDto should look like the example, with all Lombok-generated methods marked by a small red chili icon.
Figure 3: Structure view in IntelliJ with icon indicators for Lombok

5. Create the DataHelper class in the helper package, based on the UML diagram in Figure 4.
This class will provide data for the UI in later tasks. Therefore, all fields must be filled with example values (see 5b).
Eventually, this will be replaced by a database connection.
a. Implement the bodies of the get* methods. Each method should first check if the corresponding class variable is empty.
If so, the method generateDataStructure() should be called.
Regardless of the check, always return the corresponding list object.
b. Implement the generateDataStructure() method. Create at least:

4 PersonDto objects

4 EmployeeDto objects

2 TeamDto objects (each consisting of 2 EmployeeDto objects)

Figure 4: Class diagram for the DataHelper class
(Underlined = static; Red square = private; Green circle = public)

6. TeamService
a. Create a new interface TeamService in the service package.
The interface should define the following methods:
' java
List<TeamDto> getTeams();
Optional<TeamDto> getTeam(Integer id);
List<PersonDto> getTeamMembers(Integer teamId);'

b. Create a new class TeamServiceImpl in the service.impl package that implements TeamService.
Annotate the class with @Component.
Implement the methods using the previously created DataHelper class.
If direct return is not possible, filter based on team ID and/or resolve the data structure.

7.  Display the teams
a. Create a new class TeamUiController in the controller package.
Annotate it with:
'java
@Controller
@RequestMapping("/team")'

b. Create a constructor that expects an instance of TeamService.
Annotate the constructor with @Autowired.
c. Implement the method listTeams(): ModelAndView, which creates a ModelAndView object.
Add an attribute named teamList to the object and assign it the team list from the TeamService instance.
(Use the constructor-injected TeamService; the ModelAndView requires the path to the template.)
d. Create a Freemarker template to display the list of teams.
Each team should be output within a <div> container, showing:
* the team name in an <h6> heading
* the team code in a <p> tag
Create this output as a macro, so the macro can be called when iterating through the team list.

8. Creating a new team
a. Extend the TeamService interface with:
'java
TeamDto addTeam(TeamDto teamDto);'
b. Extend DataHelper with a method:
'java
TeamDto addTeam(TeamDto teamDto);'
Implement the method by adding the parameter to the list of teamDtos.
(Make sure to generate a unique ID for the team so it can be clearly identified.)
c. Extend the implementation in TeamServiceImpl to match the new interface.
Use the functionality from DataHelper.
d. Create a Freemarker template with a form that accepts input for team name and code.
Set the action attribute to the value of the @RequestMapping in TeamUiController and the @PostMapping in the next step.
e. Extend TeamUiController with two methods:
'java
@GetMapping("/create")
ModelAndView createTeam();'
Displays the form (points to the template)
'java
@PostMapping("/create")
ModelAndView createTeam(TeamDto teamDto);'
Processes the POST request. The form data must match the field names in the DTO.
Spring supports this convention when the name attributes in the form match the DTO field names.
This method should return the same template and include a success message if the team is successfully created.

10. Editing an existing team (optional)
a. Extend the implementation to allow editing of existing teams.

Notes:
i. Add a new method in TeamUiController with @GetMapping, including the team ID as a path variable.
ii. Modify the form to allow default values to be displayed and include the ID as a hidden input.
iii. Extend DataHelper so that when a team is saved, the old entry is removed and the modified one is added again, to avoid duplicates.
