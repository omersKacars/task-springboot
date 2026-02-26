# 🚀 TaskTracer API - Task Management System

Bu proje, modern bir Java Backend uygulamasının sahip olması gereken tüm temel ve ileri seviye katmanları içeren, kurumsal standartlarda geliştirilmiş bir **Görev Yönetim API**'sidir.

---

## 🛠️ Teknolojiler
- **Java 17/21**
- **Spring Boot 3.x** (Web, Data JPA, Validation)
- **PostgreSQL** (Veritabanı)
- **Docker & Docker Compose** (Altyapı Konteynerizasyonu)
- **ModelMapper** (DTO Mapping)
- **JUnit 5 & Mockito** (Unit Testing)
- **Swagger / OpenAPI 3** (API Documentation)

---

## 🏗️ Mimari Yapı
Projede **Katmanlı Mimari (Layered Architecture)** kullanılmıştır:

- **Controller:** REST uç noktaları ve HTTP istek yönetimi.
- **Service:** İş mantığı ve DTO/Entity dönüşümleri.
- **Repository:** Veritabanı erişim katmanı (JPA).
- **DTO:** Veri taşıma nesneleri ile veri izolasyonu.
- **Exception:** Merkezi hata yönetimi (Global Exception Handler).

---

## ⚙️ Kurulum ve Çalıştırma
Proje Dockerize edildiği için yerelinizde PostgreSQL kurulumuna gerek yoktur.

### 1. Projeyi Klonlayın
```bash
git clone https://github.com/omerskacars/task-tracer-api.git
```

### 2. Veritabanını Başlatın (Docker)
```bash
docker compose up -d
```

### 3. Uygulamayı Çalıştırın
```bash
./mvnw spring-boot:run
```

---

## 📝 API Dökümantasyonu
Uygulama çalıştıktan sonra aşağıdaki adresten Swagger arayüzüne erişebilir ve API'yi canlı olarak test edebilirsiniz:

👉[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

---

## 🧪 Testler
Birim (Unit) testleri çalıştırmak ve kod kalitesini doğrulamak için:
```bash
mvn test
```

---

## 👨‍🏫 Proje Hakkında
Bu proje, bir Java Eğitmeni ve Test Otomasyon Mühendisi bakış açısıyla; temiz kod (clean code), test edilebilirlik ve sürdürülebilir mimari prensiplerini sergilemek amacıyla geliştirilmiştir.
