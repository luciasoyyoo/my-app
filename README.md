# MyApp

Proyecto Maven sencillo creado como plantilla para desarrollo y prácticas.

## Descripción
Proyecto Java basado en Maven con estructura estándar. Contiene la configuración básica para compilar, ejecutar y probar la aplicación.

## Requisitos
- Java 11+ (o la versión configurada en pom.xml)
- Maven 3.6+

## Instalación y compilación
Desde la raíz del proyecto:
```bash
mvn clean install
```

## Ejecutar
Si el proyecto genera un JAR ejecutable:
```bash
java -jar target/my-app-<versión>.jar
```
O usando Maven:
```bash
mvn exec:java -Dexec.mainClass="com.example.Main"
```
(Reemplazar la clase principal por la del proyecto)

## Ejecutar tests
```bash
mvn test
```

## Estructura típica
- src/main/java — código fuente
- src/main/resources — recursos de la aplicación
- src/test/java — pruebas unitarias
- pom.xml — configuración de Maven

## Contribuir
1. Hacer fork
2. Crear una rama feature/mi-cambio
3. Hacer commit y push
4. Abrir un pull request

## Insignias
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=luciasoyyoo_my-app&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=luciasoyyoo_my-app)
[![SonarQube Cloud](https://sonarcloud.io/images/project_badges/sonarcloud-highlight.svg)](https://sonarcloud.io/summary/new_code?id=luciasoyyoo_my-app)

## Licencia
Proyecto con licencia MIT (ajustar según necesidad).

## Contacto
Mantener información de contacto o abrir issues en el repositorio.
