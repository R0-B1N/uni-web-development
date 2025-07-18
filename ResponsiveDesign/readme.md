Instructions

The tasks related to layout, content, size specifications, margins, and pseudo-classes are interconnected and build upon each other. It is strongly recommended to complete these tasks in order before proceeding with others.

Layout
1. Create a layout according to the structure shown in Figure 1.
Define the stylesheet properties in a separate CSS file.

Notes:
The containers shown in Figure 1 are DIV containers.
(Figure 1: Website layout)

Content

2. Add the following content to the corresponding HTML and CSS files:
a. Provide any sample text for the textblock sections and insert it directly into the HTML code.
b. Insert an image of your choice in the logo area and reference it via the CSS file.
c. Ensure the image does not repeat.
d. Position the image aligned to the right.

Helpful hints:
Use http://www.loremipsum.de/ for placeholder text
Use the background-image and background-position CSS properties

Size Specifications

3. Use the maincontainer to define the fixed width of the website.
Assign a fixed width of 980px to the maincontainer.
Assign fixed heights of your choice to the logo, topnavigation, and footer sections.
Assign a minimum height of 50px to each textblock section.

Margins

4. Complete the following subtasks to improve the layout:
a. Center the entire layout within the browser window.
b. Assign each textblock a margin of 10px at the top and 15px on the left and right.
c. Assign padding of 5px to the inside of each textblock.

Pseudo-Classes

5. Use the :hover pseudo-class for the textblock sections to define styling when hovered over with the mouse.
On hover, apply the box-shadow property with the value 5px 5px 7px grey.
The appearance of a textblock should visually change when the mouse moves over it.

Responsive Design

6. * In the exercise directory, locate the file responsive.html.
Create a CSS file named responsive.css containing all styles needed to implement a three-stage responsive design, as shown in Figures 2, 3, and 4.

Requirements:
Smartphone layout: optimized for 320px, shown up to a window width of 600px
Tablet (portrait mode): optimized for 600px, shown up to 980px
Desktop layout: all widths above 980px should use a fixed 980px layout width
Use Flexbox wherever possible to implement the solution.

Additional notes:
Do not modify the HTML source code. Apply CSS using techniques you’ve previously learned for targeting successive HTML elements.
Images are located in the images folder and can be used as background images with proper positioning.
The only elements that require absolute positioning are #headerImage and the container with the content: "Campus TH Wildau Fachtag Informatik".
(Note: "positioning" here refers to the position property, not background image positioning.)
To add text outlines or effects, use the text-shadow property.
The goal of this exercise is not precise pixel values, but to gain understanding in applying margins, paddings, text flow, media queries, and hierarchy structures in CSS.

Helpful resource for Flexbox:
CSS-Tricks Flexbox Guide
