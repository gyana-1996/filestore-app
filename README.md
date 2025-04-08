
# 📁 Google Cloud Filestore Spring Boot Application

A Spring Boot RESTful application for uploading and downloading files using a **Google Cloud Filestore (NFS mounted storage)**.

---

## 🚀 Features

- Upload files via REST API
- Download files from mounted NFS (Google Filestore)
- Auto-creates upload directories
- Simple integration and easy to deploy on GCP VMs

---

## 🏗️ Architecture

This application interacts directly with a directory that is **NFS-mounted from Google Cloud Filestore** (e.g., `/mnt/filestore/uploads`).

Files uploaded via API are saved to the Filestore directory, making them instantly accessible across all connected VMs.

---

## 📦 Technologies Used

- Spring Boot (REST)
- Java 17+
- Google Cloud Filestore (NFS)
- Maven

---

## 📂 File Storage Structure

```
Google VM Instance
└── /mnt/filestore/uploads/     <-- NFS mount (Google Filestore)
    ├── uploaded_file_1.txt
    └── image.png
```

---

## ⚙️ Configuration

Edit the `src/main/resources/application.properties` file:

```properties
# Directory where files will be stored (mounted Google Filestore)
file.storage.path=/mnt/filestore/uploads
```

Ensure the folder `/mnt/filestore/uploads` exists and is writable.

---

## 🛠️ How to Run

### Prerequisites:
- Java 17+
- Maven
- A GCP VM with Filestore NFS mounted at `/mnt/filestore`

### Steps:

1. **Clone the project:**
```bash
git clone https://github.com/gyana-1996/filestore-app.git
cd filestore-app
```

2. **Build the project:**
```bash
mvn clean install
```

3. **Run the application:**
```bash
mvn spring-boot:run
```

The application starts on: `http://localhost:8080`

---

## 📤 File Upload

### Endpoint:
```http
POST /api/files/upload
```

### Example cURL:
```bash
curl -F "file=@/path/to/local/file.txt" http://localhost:8080/api/files/upload
```

---

## 📥 File Download

### Endpoint:
```http
GET /api/files/download/{filename}
```

### Example cURL:
```bash
curl -O http://localhost:8080/api/files/download/file.txt
```

---

## 🔐 Security (Optional)

For production use, consider adding:
- Spring Security (JWT or Basic Auth)
- File validation (e.g., size/type restrictions)
- Exception handling and custom error messages

---

## 📁 Sample Directory Structure

```
src/
├── main/
│   ├── java/com/example/filestore/
│   │   ├── FilestoreApplication.java
│   │   ├── controller/FileController.java
│   │   └── service/FileStorageService.java
│   └── resources/
│       └── application.properties
└── pom.xml
```

---

## 🙌 Author

**[Gyana Ranjan Barik]**  
[https://www.linkedin.com/in/gyana247/]  
[https://github.com/gyana-1996]
