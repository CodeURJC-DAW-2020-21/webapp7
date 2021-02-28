# Group 7 DAW

## Phase 0: Definition of web functionalities.

### Web Name: Kiddy's House

### Web Logotype:
![Kiddy's House](https://github.com/CodeURJC-DAW-2020-21/webapp7/blob/main/icon.png?raw=true)

### Description:
Our page is an online children's English academy. The page is going to include the different courses offered, important information about them and the possibility to enroll in them. As a registered user, you can access the course material and visualize and comment on the teacher's posts in the forum.


### Members:
| NAME AND LASTNAME | EMAIL | GITHUB |
| ------------- | ------------- | ------------- |
| ALBA SEVILLANO PORTILLA  | a.sevilano.2018@alumnos.urjc.es  | Alba-18  |
| MIRIAM DE FRANCISCO ALFONSO | m.defrancisco.2018@alumnos.urjc.es  | miri-fa  |
| CARIDAD ARIAS PRADAS  | c.ariasp.2018@alumnos.urjc.es  | ariascary  |
| DEBORAH ISRAEL VILLANUEVA VASSILEVA | di.villanueva.2018@alumnos.urjc.es  | deborahisraelvillanueva  |
| JESÚS SEBASTIÁN TOCAS ATARAMA | js.tocas.2018@alumnos.urjc.es  | mrjesuland  |

### Support Links:
We're using [Trello](https://trello.com/invite/b/FyoaV1rD/1919995ae2250c7e31fa09591b830557/grupo7daw) to make easier the organization for the web product.
	
### Entities: 
- User
- Course
- Course material
- Blog posts
- Review posts

### User types:
Admin: The admin can post new material (like pdfs) and create new posts on the forum. This type of user can access every part of the web.
	
Anonymous user: This user is not registered. The only parts visible are the start page and the information about the different courses as well as having the option to 	register.
	
Registered user: They can comment on the admin posts and visualize the course material.

### Images: 
- Teacher profile image
- Courses images
- Images to promote the academy

### Charts: 
We are going to implement a graph, so that each of the users (students), see the progress made by each of the colleagues who take that course

### Complementary technology: 
The system has an internal email to facilitate communication with the teachers and users.

### Algorithm: 
System that compares the download content from the course and recomends new material to do. This depends on the content downloaded from different users on the same course level. 
	
## Phase 1: Page layout with HTML and CSS.

### Navigation Diagram:
![Nav-Diagram](https://github.com/CodeURJC-DAW-2020-21/webapp7/blob/main/ReadmePictures/Nav_Diagram.png)	
	
### Screenshots:

#### Login
![Login](https://github.com/CodeURJC-DAW-2020-21/webapp7/blob/main/ReadmePictures/README_Images/login.png)
It is observable the possibility given to the user to log-in by just typing in their email and password, consequently depending on wether the dominion of the email , the app will differentiate wether they are a student user or an instructor forwarding them to their corresponding user interfaces.

#### Home
![Home](https://github.com/CodeURJC-DAW-2020-21/webapp7/blob/main/ReadmePictures/Home.gif)

This is the main page which shows a review about all website’s sections and a place where a user can sign up or log in if it’s registered already.

#### About
![About](https://github.com/CodeURJC-DAW-2020-21/webapp7/blob/main/ReadmePictures/About.gif)

This tab describes main info about Kiddy’s House academy, what is offerted and signed-up users ratings.

#### Courses
![Courses](https://github.com/CodeURJC-DAW-2020-21/webapp7/blob/main/ReadmePictures/Courses.gif)

This tab describes main info about Kiddy’s House academy, what is offerted and signed-up users ratings.

#### Instructor
![Instructor](https://github.com/CodeURJC-DAW-2020-21/webapp7/blob/main/ReadmePictures/Instructor.gif)

It contains all teachers description.

#### Blog
![Blog](https://github.com/CodeURJC-DAW-2020-21/webapp7/blob/main/ReadmePictures/Blog.gif)

This page has all news and updates about everything related to academy stuff.

#### Single Blog
![Single-Blog](https://github.com/CodeURJC-DAW-2020-21/webapp7/blob/main/ReadmePictures/SingleBlog.gif)

This webpage shows the content about Kiddy’s House news.

#### Contact
![Contact](https://github.com/CodeURJC-DAW-2020-21/webapp7/blob/main/ReadmePictures/ContactUs.gif)

Whenever the user needs to contact the academy for any reason there is tab with frequent questions, possibility of writting their own questions as well as phone contact, email and social media.

#### Email
![Email](https://github.com/CodeURJC-DAW-2020-21/webapp7/blob/main/ReadmePictures/Email.gif)
Every user, student as well as instructor have this tab where they can see the new emails in the right part of the tab, time charge ilustrated with a  progress bar, and on the left the chance of writting a new email including files if desired. On the dropdown menu of the upper-rigth side of the tab the user can log-out as well as go to their class material page.

#### User-instructor
![User-instructor](https://github.com/CodeURJC-DAW-2020-21/webapp7/blob/main/ReadmePictures/User%20Instructor.gif)
Every student user has their own personalized tab with their material(checked whenever has been downloaded and  seeen), personalized recommendations  and graph portraying the progress of the course.On the dropdown menu of the upper-rigth side of the tab the user can log-out as well as go to their email.

#### User student
![User-instructor](https://github.com/CodeURJC-DAW-2020-21/webapp7/blob/main/ReadmePictures/User%20Student.gif)
Each instructor has their own class content with the possibility of adding any type of files: from pdfs, text, titles, to  videos. It is observable in to their right a series of classes they have with their timetables and a progress graph of the course. On the dropdown menu of the upper-rigth side of the tab the user can log-out as well as go to their email.

