# Group 7 DAW

## Phase 0: Definition of web functionalities.

### Web Name: Kiddy's House

### Web Logotype:
![Kiddy's House](https://github.com/CodeURJC-DAW-2020-21/webapp7/blob/main/ReadmePictures/logo.png)

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
![Login](https://github.com/CodeURJC-DAW-2020-21/webapp7/blob/main/ReadmePictures/logIn3.png)
It is observable the possibility given to the user to log-in by just typing in their email and password, consequently depending on wether the dominion of the email , the app will differentiate wether they are a student user or an instructor forwarding them to their corresponding user interfaces.

#### Home
![Home](https://github.com/CodeURJC-DAW-2020-21/webapp7/blob/main/ReadmePictures/Index.gif)

This is the main page which shows a review about all website’s sections and a place where a user can sign up or log in if it’s registered already.

#### About
![About](https://github.com/CodeURJC-DAW-2020-21/webapp7/blob/main/ReadmePictures/about3.png)

This tab describes main info about Kiddy’s House academy, what is offerted and signed-up users ratings.

#### Courses
![Courses](https://github.com/CodeURJC-DAW-2020-21/webapp7/blob/main/ReadmePictures/Course.gif)

This tab describes main info about Kiddy’s House academy, what is offerted and signed-up users ratings.

#### Instructor
![Instructor](https://github.com/CodeURJC-DAW-2020-21/webapp7/blob/main/ReadmePictures/Instructor.gif)

It contains all teachers description.

#### Blog
![Blog](https://github.com/CodeURJC-DAW-2020-21/webapp7/blob/main/ReadmePictures/Blog.gif)

This page has all news and updates about everything related to academy stuff.

#### Single Blog
![Single-Blog](https://github.com/CodeURJC-DAW-2020-21/webapp7/blob/main/ReadmePictures/blogSingle3.png)

This webpage shows the content about Kiddy’s House news.

#### Contact
![Contact](https://github.com/CodeURJC-DAW-2020-21/webapp7/blob/main/ReadmePictures/contactUs3.png)

Whenever the user needs to contact the academy for any reason there is tab with frequent questions, possibility of writting their own questions as well as phone contact, email and social media.

#### Contact (email sent)
![Contact-sent](https://github.com/CodeURJC-DAW-2020-21/webapp7/blob/main/ReadmePictures/README_Images/Captura%20de%20pantalla%20(4).png)

Whenthe user sents a doubt or concern via the contact page, this page will appear, making sure that the user knows that their question is sent.


#### User-instructor
![User-instructor](https://github.com/CodeURJC-DAW-2020-21/webapp7/blob/main/ReadmePictures/UserInstructor.if)

Every student user has their own personalized tab with their material(checked whenever has been downloaded and  seeen), personalized recommendations  and graph portraying the progress of the course.On the dropdown menu of the upper-rigth side of the tab the user can log-out as well as go to their email.

#### User student
![User-instructor](https://github.com/CodeURJC-DAW-2020-21/webapp7/blob/main/ReadmePictures/UserStudent.gif)

Each instructor has their own class content with the possibility of adding any type of files: from pdfs, text, titles, to  videos. It is observable in to their right a series of classes they have with their timetables and a progress graph of the course. On the dropdown menu of the upper-rigth side of the tab the user can log-out as well as go to their email.

### User admin
![User-admin](https://github.com/CodeURJC-DAW-2020-21/webapp7/blob/main/ReadmePictures/UserAdmin.gif)
This page was created to manage all users, courses and posts within the organization.

### Error
![Error](https://github.com/CodeURJC-DAW-2020-21/webapp7/blob/main/ReadmePictures/errorNormal.png)
This page is shown when server connection is failing or there is another problem.

### Error_404
![Error 404](https://github.com/CodeURJC-DAW-2020-21/webapp7/blob/main/ReadmePictures/error404.png)
This page is displayed when user tries to enter in an unknown page.

### Login_Error
![Login_Error](https://github.com/CodeURJC-DAW-2020-21/webapp7/blob/main/ReadmePictures/login_error.png)
This page is shown when someone has failed to sign up.


## Phase 2: Web with HTML generated  in server and AJAX

In this phase, we made the dynamic part of the web. First, we connected the app to Spring Boot, and then we started building the controllers. After that, we created the database and distributed evenly all the work. We created the models: Comment, Course, Material, Post, and User. We also have different controllers depending on their function: commentController, contactController, courseController, errorWebController, KiddysController, loginWebController, materialController, postController, registerController, and userController. We also made some security changes, like changing the port to 8443.

### New and Modify Screenshots:
The new changes made in this phase, are in the screenshots section in phase 1.

### Development:

#### Source Code:
[WebApp7 Code](https://github.com/CodeURJC-DAW-2020-21/webapp7.git)

#### Development Tools:
Spring Tool Suite 4.
MySQL WorkBench 8.0.
JAVA version 11
Maven 3.8.1
MyAQL 8.0.23
Javax.validation 2.0.1.Final

#### Dependencies:
MSQL Server Workbench
Spring framework.
Mustache.
Springboot starter mail.
Springboot starter security.

#### Basic installarion of MySQL Server and MySQL Workbench (recommended) on Windows.
1.Download MySQL Windows Installer.
2.Run it as administrator.
3.In 'Choosing a Setup Type' select Developer Default.
4.In 'Check Requirements' screen install every of the items showed so the app works fine.
5.Execute the installation of the products (MySQL Server must be there).
6.Next.
7.In 'High Avaliability' screen select Standalone MySQL Server / Classic MySQL Replication option.
8.Next >> Next.
9.Write a Password.
10.Next >> Execute >> Finnish till installation ends.

### Navigation Diagram:
![Navigation Diagram](https://github.com/CodeURJC-DAW-2020-21/webapp7/blob/main/ReadmePictures/Nav_Diagram_Fase3.png)

### Entity Diagram:
![Entity Diagram](https://github.com/CodeURJC-DAW-2020-21/webapp7/blob/main/ReadmePictures/EntityDiagram.png)

### Classes and templates Diagram:
![Class Diagram](https://github.com/CodeURJC-DAW-2020-21/webapp7/blob/main/ReadmePictures/Class_Diagram.jpeg)

## Authors' Participation:
- Caridad Arias Pradas
  - TASKS:
    - Login: HTML, Controller, Service, Repository.
    - Error control system: ErrorWebController.
    - Algorithm 
    - Ajax
    
  - TOP 5 MOST IMPORTANT COMMITS IN 'SECOND PHASE':
    - [Commit 1](https://github.com/CodeURJC-DAW-2020-21/webapp7/commit/366531d7e57513a6a43bdbfeded0db3f7ffc635a)
    - [Commit 2](https://github.com/CodeURJC-DAW-2020-21/webapp7/commit/ee88d2896e75b70a90864c496d91d163f5337531)
    - [Commit 3](https://github.com/CodeURJC-DAW-2020-21/webapp7/commit/bb9c21a2b01f709454438d71197847f63f2e9a5f)
    - [Commit 4](https://github.com/CodeURJC-DAW-2020-21/webapp7/commit/40d9e52307127a96548afd5462e7b0ebf8f5940e)
    - [Commit 5](https://github.com/CodeURJC-DAW-2020-21/webapp7/commit/7b9083980ae2985c9531f08c8f4973247ecffff5)
    
  - TOP 5 MOST MODIFIED FILES:
    1. [User](https://github.com/CodeURJC-DAW-2020-21/webapp7/blame/main/src/main/java/com/webapp7/webapp7/model/User.java)
    2. [ErrorWebController](https://github.com/CodeURJC-DAW-2020-21/webapp7/blame/main/src/main/java/com/webapp7/webapp7/controller/ErrorWebController.java)
    3. [LoginWebController](https://github.com/CodeURJC-DAW-2020-21/webapp7/blame/main/src/main/java/com/webapp7/webapp7/controller/LoginWebController.java)
    4. [UserRepository](https://github.com/CodeURJC-DAW-2020-21/webapp7/blame/main/src/main/java/com/webapp7/webapp7/repository/UserRepository.java)
    5. [CSRFHandlerConfiguration.java](https://github.com/CodeURJC-DAW-2020-21/webapp7/blame/main/src/main/java/com/webapp7/webapp7/security/CSRFHandlerConfiguration.java)
	
- Miriam de Francisco Alonso
  - TASKS:
    - Moustache mapping at the beginning of the phase.
    - Creating new slots for PDFs, pictures, etc. to be posted in user_admin, user_student and user_instructor.
    - Create the ability to post new content to those pages.
    - Create the ability to download said content, also deleting it.
    - Fix bugs and errors.
    - Algorithm 
    - Graph
    - Queries
    -
  - TOP 5 MOST IMPORTANT COMMITS IN 'SECOND PHASE':
    - [Commit 1](https://github.com/CodeURJC-DAW-2020-21/webapp7/commit/b8067f59a16ce9e60c7109aec995e263dfbf2bd9)
    - [Commit 2](https://github.com/CodeURJC-DAW-2020-21/webapp7/commit/4f930939aeb59809bef257e2f59e9206b0f39f0d)
    - [Commit 3](https://github.com/CodeURJC-DAW-2020-21/webapp7/commit/3159c3c23b0b91f697aeaa40d18219b0d1b74270)     
    - [Commit 4](https://github.com/CodeURJC-DAW-2020-21/webapp7/commit/9b7bb8beecab111a00c35938a92750f100ef456d)
    - [Commit 5](https://github.com/CodeURJC-DAW-2020-21/webapp7/commit/68264317d73ab6b08a547426ba2e0ecd8c8ee1a4)
		
  - TOP 5 MOST MODIFIED FILES:
    1. [Material](https://github.com/CodeURJC-DAW-2020-21/webapp7/blame/main/src/main/java/com/webapp7/webapp7/model/Material.java) 
    2. [CourseController](https://github.com/CodeURJC-DAW-2020-21/webapp7/blame/main/src/main/java/com/webapp7/webapp7/controller/CourseController.java)
    3. [MaterialController](https://github.com/CodeURJC-DAW-2020-21/webapp7/blame/main/src/main/java/com/webapp7/webapp7/controller/MaterialController.java)
    4. [MaterialRepository](https://github.com/CodeURJC-DAW-2020-21/webapp7/blame/main/src/main/java/com/webapp7/webapp7/repository/MaterialRepository.java)
    5. [User_Student](https://github.com/CodeURJC-DAW-2020-21/webapp7/blame/main/src/main/resources/templates/user_student.html)
    
- Alba Sevillano Portilla:
  - TASKS:
    - Create the ability to post new comments in the about page.
    - Create the ability to register users.
    - Create HTML of error, loginerror, error 404.
    - Instructor: Controller, Service, Repository.
    - Do the SQL Query
    - Algorithm
    - Graph
    - Queries
    
  - TOP 5 MOST IMPORTANT COMMITS IN 'SECOND PHASE':
    - [Commit 1](https://github.com/CodeURJC-DAW-2020-21/webapp7/commit/4e96792fea4b945bafd7d42ca642c75d20ae25d3)
    - [Commit 2](https://github.com/CodeURJC-DAW-2020-21/webapp7/commit/2bfa6f9b08e7efa42d26a1f4d56b2949787f79c3)
    - [Commit 3](https://github.com/CodeURJC-DAW-2020-21/webapp7/commit/3146e719ef0043cec4d9ae45baacadc7e8a73b40)
    - [Commit 4](https://github.com/CodeURJC-DAW-2020-21/webapp7/commit/8cdde3224ae6f1ab4e7b15a1f046640f2a04a832)
    - [Commit 5](https://github.com/CodeURJC-DAW-2020-21/webapp7/commit/8cdde3224ae6f1ab4e7b15a1f046640f2a04a832)
    
  - TOP 5 MOST MODIFIED FILES:
    1. [Comment](https://github.com/CodeURJC-DAW-2020-21/webapp7/blob/main/src/main/java/com/webapp7/webapp7/model/Comment.java)
    2. [User](https://github.com/CodeURJC-DAW-2020-21/webapp7/blame/main/src/main/java/com/webapp7/webapp7/model/User.java)
    3. [CommentController](https://github.com/CodeURJC-DAW-2020-21/webapp7/blame/main/src/main/java/com/webapp7/webapp7/controller/CommentController.java)
    4. [InstructorController](https://github.com/CodeURJC-DAW-2020-21/webapp7/blame/main/src/main/java/com/webapp7/webapp7/controller/InstructorController.java)
    5. [RegisterController](https://github.com/CodeURJC-DAW-2020-21/webapp7/blame/main/src/main/java/com/webapp7/webapp7/controller/RegisterController.java)
  
- Jesús Sebastián Tocas Atarama:
  - TASKS:
    - Course: HTML, Controller, Service, Repositoty
    - Post new courses in user_admin (info and image)
    - Show courses posted in /courses
    - Delete courses
    - Support some teammates with some errors and bugs fixed
    - Ajax 
    - Graph
    
  - TOP 5 MOST IMPORTANT COMMITS IN 'SECOND PHASE':
    - [Commit 1](https://github.com/CodeURJC-DAW-2020-21/webapp7/commit/1d5685338933319f9b15049e3a8236e04ccb4787)
    - [Commit 2](https://github.com/CodeURJC-DAW-2020-21/webapp7/commit/1454c50d4bd49bb800ebaaecbf8b0a35886314cf)
    - [Commit 3](https://github.com/CodeURJC-DAW-2020-21/webapp7/commit/0a4387643c10255b9af363fb6d4f02d5f68e7827)
    - [Commit 4](https://github.com/CodeURJC-DAW-2020-21/webapp7/commit/886042ad2a9ac99b54f6b187ca74661ca2407ca0)
    - [Commit 5](https://github.com/CodeURJC-DAW-2020-21/webapp7/commit/08b874ca1d9e7dc612a4ecaec21503389714eb5b)
    
  - TOP 5 MOST MODIFIED FILES:
    1. [Course](https://github.com/CodeURJC-DAW-2020-21/webapp7/blame/main/src/main/java/com/webapp7/webapp7/model/Course.java) 
    2. [CourseController](https://github.com/CodeURJC-DAW-2020-21/webapp7/blame/main/src/main/java/com/webapp7/webapp7/controller/CourseController.java)
    3. [CourseRepository](https://github.com/CodeURJC-DAW-2020-21/webapp7/blame/main/src/main/java/com/webapp7/webapp7/repository/CourseRepository.java)
    4. [DataBaseInitializer](https://github.com/CodeURJC-DAW-2020-21/webapp7/blame/main/src/main/java/com/webapp7/webapp7/Service/DataBaseInitializer.java)
    5. [User_Admin](https://github.com/CodeURJC-DAW-2020-21/webapp7/blame/main/src/main/resources/templates/user_admin.html)
  
- Deborah Israel Villanueva:
  - TASKS:
    - Blog posts seen, posted and opened dynamically with images.
    - HTTPS security port 8443
    - Email with SMPT
    - Message feedback html
    - Sample data embedded on MYSQL database
    - Ajax
    - Graph
    
  - TOP 5 MOST IMPORTANT COMMITS IN 'SECOND PHASE'
    - [Commit 1](https://github.com/CodeURJC-DAW-2020-21/webapp7/commit/908daab33a8f323f1502a2a3e818a51cc8c9ca34)
    - [Commit 2](https://github.com/CodeURJC-DAW-2020-21/webapp7/commit/adc8388baca69fe673120b486f15800ca8e53393)
    - [Commit 3](https://github.com/CodeURJC-DAW-2020-21/webapp7/commit/b05759d85800199889c85944a483860b6c4d9e54)
    - [Commit 4](https://github.com/CodeURJC-DAW-2020-21/webapp7/commit/52afb2ab041f7375e55ab4d27cff8531b479cec6)
    - [Commit 5](https://github.com/CodeURJC-DAW-2020-21/webapp7/commit/b0ada66e54ba68713556f5e63aa80f7966371c4d)
    
  - TOP 5 MOST MODIFIED FILES:
    1. [Post](https://github.com/CodeURJC-DAW-2020-21/webapp7/blame/main/src/main/java/com/webapp7/webapp7/model/Post.java) 
    2. [ContactController](https://github.com/CodeURJC-DAW-2020-21/webapp7/blame/main/src/main/java/com/webapp7/webapp7/controller/ContactController.java)
    3. [ErrorWebControl](https://github.com/CodeURJC-DAW-2020-21/webapp7/blame/main/src/main/java/com/webapp7/webapp7/controller/ErrorWebController.java)
    4. [LoginWebController](https://github.com/CodeURJC-DAW-2020-21/webapp7/blame/main/src/main/java/com/webapp7/webapp7/controller/LoginWebController.java)
    5. [PostController](https://github.com/CodeURJC-DAW-2020-21/webapp7/blame/main/src/main/java/com/webapp7/webapp7/controller/PostController.java)
