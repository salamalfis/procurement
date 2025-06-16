APP_NAME=procurement
JAR_FILE=target/$(APP_NAME)-0.0.1-SNAPSHOT.jar
DOCKER_IMAGE=alfis/$(APP_NAME)
ENV ?= dev

.PHONY: help build run test docker-up docker-down clean migrate

help:
	@echo ""
	@echo "📦 Makefile Commands"
	@echo "----------------------"
	@echo "make build        → Build project via Maven"
	@echo "make run          → Jalankan Spring Boot app"
	@echo "make test         → Run unit tests"
	@echo "make clean        → Clean build target"
	@echo "make docker-up    → Jalankan docker-compose up -d"
	@echo "make docker-down  → Jalankan docker-compose down"
	@echo "make migrate      → Jalankan migration token refresh schema (flyway atau sql manual)"
	@echo ""

build:
	./mvnw clean package -DskipTests

run: build
	java -jar $(JAR_FILE)

test:
	./mvnw test

clean:
	./mvnw clean

docker-up:
	docker-compose -f docker-compose.yml up -d

docker-down:
	docker-compose -f docker-compose.yml down

migrate:
	psql -U postgres -d procurement_db -f ./scripts/token_refresh_schema.sql
