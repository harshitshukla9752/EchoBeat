# 🎧 EchoBeat – Music Streaming Platform

*Java Spring Boot • MongoDB • JWT Auth • AWS Deployment*

## 🚀 Overview

EchoBeat is a Spotify‑style music streaming platform built using Java + Spring Boot, designed to deliver secure and scalable audio streaming services. It includes authentication, playlists, song management, and AWS-based media storage.

The project follows clean backend architecture and industry-level practices, making it an excellent fit for backend engineering portfolios and interviews.

---

## 🔥 Features

* **User Authentication (JWT)**
* **Upload / Stream Music**
* **Playlist Creation & Management**
* **Like / Favorite Songs**
* **MongoDB Integration**
* **Role-based Access (Admin/User)**
* **RESTful API Architecture**
* **AWS Deployments (EC2 + S3)**
* **Secure Password Hashing (BCrypt)**

---

## 🛠️ Tech Stack

* **Backend:** Java, Spring Boot, Spring Security
* **Database:** MongoDB
* **Auth:** JWT, BCrypt
* **Cloud:** AWS EC2, AWS S3
* **Build Tool:** Maven
* **Tools:** Postman, Git, GitHub

---

## 📁 Project Structure

```
EchoBeat/
│── src/
│   ├── main/
│   │   ├── java/com/echobeat/
│   │   │   ├── controller/
│   │   │   ├── dto/
│   │   │   ├── exception/
│   │   │   ├── service/
│   │   │   ├── repository/
│   │   │   ├── model/
│   │   │   └── security/
│   │   └── resources/
│   │       ├── application.properties
│   │       └── static/uploads
│── .gitignore
│── build.gradle
│── HELP.md
│── gradlew
│── gradlew.bat
│── settings.gradle
│── README.md
```

---

## ⚙️ Installation & Setup

### 1️⃣ Clone the repository

```
git clone https://github.com/harshitshukla9752/EchoBeat.git
cd EchoBeat
```

### 2️⃣ Install dependencies

```
./gradlew build
```

### 3️⃣ Create `application.properties`

```
server.port=8080

spring.data.mongodb.uri=YOUR_MONGO_URI
jwt.secret=YOUR_SECRET_KEY

aws.access-key=XXXX
aws.secret-key=XXXX
aws.s3.bucket=echobeat-bucket
```

### 4️⃣ Run the project

```
./gradlew bootRun
```

---

## 🔐 API Endpoints

### **Auth APIs**

| Method | Endpoint         | Description       |
| ------ | ---------------- | ----------------- |
| POST   | `/auth/register` | User registration |
| POST   | `/auth/login`    | Login + JWT token |

### **Songs APIs**

| Method | Endpoint        | Description           |
| ------ | --------------- | --------------------- |
| POST   | `/songs/upload` | Upload a song (Admin) |
| GET    | `/songs/all`    | Fetch all songs       |
| GET    | `/songs/{id}`   | Play / get song       |

### **Playlist APIs**

| Method | Endpoint                 | Description          |
| ------ | ------------------------ | -------------------- |
| POST   | `/playlist/create`       | Create playlist      |
| PUT    | `/playlist/add/{songId}` | Add song to playlist |
| GET    | `/playlist/user`         | Get user playlists   |

---

## 📸 Screenshots (Add Your Own)

* Home Page UI
* Song List API Response
* Playlist JSON Output
* AWS Deployment Screenshot

---

## 🤝 Contributing

Pull requests are welcome! For major changes, open an issue to discuss what you would like to change.

---

## 📜 License

This project is licensed under the **MIT License**.

---

## 🌟 Show Your Support

⭐ Star this repository to support development!
