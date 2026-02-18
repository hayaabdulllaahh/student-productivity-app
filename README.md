# 📚 Student Notes – University Assistant App  

## 📌 Overview  

**Student Notes** is an Android application designed to help university students manage their academic life in a simple and focused way.

The application combines three essential academic tools in one platform:

- 📝 Notes Management  
- ✅ To-Do List  
- 📊 GPA Calculator (4-point & 5-point systems)  

The app was developed using **Java** in **Android Studio**, with local data storage using SQLite to ensure offline access and data persistence.

---

## 🎯 Problem Statement  

University students often struggle with:

- Organizing academic notes  
- Managing daily tasks and assignments  
- Calculating GPA accurately  
- Using overly complex productivity applications  

Many existing applications are either too complex or do not provide GPA calculation features in a simple student-focused design.

This project aims to provide a **minimal, easy-to-use Android solution** that improves productivity and reduces academic stress.

---

## ✨ Features  

### 📝 Notes Management  

The Notes module allows users to fully manage their personal notes.

- Create new notes (Title + Content)  
- Edit existing notes  
- Delete notes with confirmation dialog  
- Display notes using RecyclerView in list format  
- Search notes using keywords (from title or content)  
- Store user-specific notes linked to User ID  
- Persistent storage (notes remain saved after closing the app)  
- Help and About section available in the menu  

### ✅ To-Do List  

- Add new tasks  
- Edit tasks (swipe right)  
- Delete tasks with confirmation (swipe left)  
- Mark tasks as completed (checkbox with strike-through effect)  
- Persistent local storage using SQLite  

### 📊 GPA Calculator  

- Supports both 4-point and 5-point grading systems  
- Add courses with credit hours and grade (0–100)  
- Automatic grade-to-point conversion  
- GPA calculation and display  
- Switch between grading systems dynamically  
- Delete individual courses or clear entire GPA  
- Stored in database per user  

### 👤 User Account & Session Management  

- User Sign Up and Login system  
- Email validation and uniqueness check  
- Session tracking using SharedPreferences  
- User-specific data linking via User ID  
- Profile page for viewing and editing user information  

---

## 🛠️ Technologies Used  

- **Java**  
- **Android Studio**  
- **XML (UI Design)**  
- **SQLite Database**  
- **SharedPreferences**  
- **RecyclerView**  
- **Android SDK**

---

## 🧱 Architecture & Design  

The application follows a structured layered design:

### Presentation Layer  
- Activity-based navigation  
- XML-based UI layouts  
- Simple and intuitive interface design  

### Application Layer  
- Notes Management logic  
- To-Do Task handling  
- GPA calculation logic  
- Input validation before saving data  

### Data Layer  
- SQLite local database  
- Four main tables:
  - Users  
  - Notes  
  - Tasks  
  - GPA  
- Full CRUD operations via DatabaseHelper class  
- Foreign key linking using User ID  

---

## 👩‍💻 My Contribution  

This project was developed as a group project for a Mobile Application Development course.

My primary responsibility was implementing the **Notes Management module**, including:

- Designing and implementing the `Note` model class  
- Developing `NotesActivity`  
- Implementing `AddNoteActivity`  
- Implementing `NoteDetailsActivity`  
- Building full CRUD operations (Create, Read, Update, Delete)  
- Developing search functionality for notes  
- Implementing delete confirmation dialog  
- Configuring RecyclerView with a custom Adapter  
- Connecting notes with the SQLite database  
- Ensuring user-specific note storage and persistence  

---

## 🔥 Challenges  

- Managing user-specific data across multiple activities  
- Implementing dynamic search functionality  
- Maintaining data persistence using SQLite  
- Linking notes to specific users via foreign keys  

### ✔ Solutions  

- Used SharedPreferences to manage user sessions  
- Linked database tables using User ID  
- Structured database helper class for CRUD operations  
- Followed modular design for easier debugging and maintenance  

---

## 🚀 Future Improvements  

- Cloud backup and synchronization  
- Enhanced security (encryption, authentication improvements)  
- Password reset functionality  
- Push notifications and reminders  
- Cross-platform version (iOS support)  

---

## 👥 Team  

Developed as a group project for a university Mobile Application Development course.  
Each team member was responsible for a specific module of the application.

---


## Screens
![](https://github.com/hayaabdulllaahh/student-productivity-app/raw/main/NotesHomePage.png)
![](https://github.com/hayaabdulllaahh/student-productivity-app/raw/main/CreateNewNoteInterface.png)
![](https://github.com/hayaabdulllaahh/student-productivity-app/raw/main/NotesSearchBar.png)
![](https://github.com/hayaabdulllaahh/student-productivity-app/raw/main/EditNoteinterface.png)
![](https://github.com/hayaabdulllaahh/student-productivity-app/raw/main/DeleteNoteConfirmationDialog.png)

