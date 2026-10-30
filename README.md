# Student Attendance & Grade Management System

A full stack web application to manage students, attendance and marks, with automatic grade calculation and a 75% attendance rule for exam eligibility.

## Features
- Student management (add, view, delete)
- Daily attendance marking (Present / Absent)
- Subject-wise marks entry
- Automatic grade calculation (A / B / C / D) from average marks
- Exam eligibility check: attendance below 75% is flagged as **Not Eligible**
- Dashboard with a live eligibility report

## Tech Stack
| Layer | Technology |
|---|---|
| Frontend | HTML, CSS, JavaScript (Fetch API) |
| Backend | Java, Spring Boot, Spring Data JPA, REST APIs |
| Database | MySQL |

## API Endpoints
| Method | Endpoint | Description |
|---|---|---|
| GET / POST | `/api/students` | List or add students |
| PUT / DELETE | `/api/students/{id}` | Update or delete a student |
| POST | `/api/attendance` | Mark attendance |
| POST | `/api/grades` | Add marks |
| GET | `/api/reports` | Attendance %, eligibility and grade for all students |

## How to Run
1. Install JDK 17 and MySQL 8
2. Create the database:
   ```sql
   CREATE DATABASE attendance_db;
   ```
3. Set your MySQL password as an environment variable:
   ```
   DB_PASSWORD=your_mysql_password
   ```
4. Run `AttendanceSystemApplication` (tables are created automatically)
5. Open `frontend/index.html` for students and `frontend/dashboard.html` for attendance, marks and the report

## Author
Vijayaprabakaran K