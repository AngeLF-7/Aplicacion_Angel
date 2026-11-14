# DeepCore — Deep Work & Discipline Tracker

**DeepCore** es una aplicación móvil nativa para **Android** diseñada bajo una estética minimalista (negro carbón, grises y rojo carmesí) para fomentar el trabajo profundo (*Deep Work*) y la constancia en el estudio. Permite organizar objetivos diarios, cronometrar bloques de concentración, validar el aprendizaje mediante inteligencia artificial y medir la disciplina personal a través de un sistema de puntuación (MMR).

* **Autor:** Ángel López Franco
* **Ciclo:** CFGS en Desarrollo de Aplicaciones Multiplataforma (2.º DAM) — Curso 2026-2027
* **Repositorio:** [https://github.com/AngeLF-7/Aplicacion_Angel.git](https://github.com/AngeLF-7/Aplicacion_Angel.git)

---

## 📚 Documentación del Proyecto (`/docs`)

Toda la memoria técnica y de planificación del proyecto se encuentra organizada en la carpeta [`/docs`](./docs):

### Fase 1 · Definición y Viabilidad
1. [01. Definición del Proyecto](./docs/01_Definicion_del_proyecto.pdf)
2. [02. Análisis de Mercado y Competencia](./docs/02_Analisis_de_mercado.pdf)
3. [03. Requisitos del Sistema](./docs/03_Requisitos_del_sistema.pdf)
4. [04. Especificaciones Técnicas y Arquitectura](./docs/04_Especificaciones_tecnicas.pdf)
5. [05. Viabilidad y Presupuesto](./docs/05_Viabilidad_y_presupuesto.pdf)
6. [06. Planificación del Proyecto](./docs/06_Planificacion_del_proyecto.pdf)

### Fase 2 · Análisis y Diseño
* [Actividad 2 · Análisis y Diseño del Sistema](./docs/Actividad2_Analisis_y_Diseno_DeepCore.pdf) *(Casos de uso, Diagrama de clases, Cloud Firestore + Room y Mockups)*

### Fase 3 · Planificación y Desarrollo
* [Actividad 3 · Planificación y Desarrollo del Proyecto](./docs/Actividad3_Planificacion_y_Desarrollo_DeepCore.pdf) *(Desglose de tareas, Gantt, riesgos y entregas parciales)*

---

## 🛠️ Stack Tecnológico

* **Plataforma:** Android (API 24 / Android 7.0 Nougat o superior)
* **Lenguaje:** Kotlin
* **Arquitectura:** MVVM (*Model-View-ViewModel*) + patrón *Repository*
* **Autenticación:** Firebase Authentication (Correo y contraseña)
* **Base de Datos Remota:** Cloud Firestore
* **Base de Datos Local (Offline):** Room Database (SQLite)
* **Inteligencia Artificial (Fase avanzada):** Google Gemini API

---

## 🚀 Requisitos e Instalación

Para clonar y ejecutar este proyecto en tu entorno local:

1. **Requisitos previos:**
   * Android Studio (versión Ladybug o superior recomendada).
   * JDK 17 o superior.
   * Dispositivo físico Android o emulador con **API 24+**.

2. **Clonar el repositorio:**
   ```bash
   git clone https://github.com/AngeLF-7/Aplicacion_Angel.git
   ```

3. **Configuración de Firebase (Importante):**
   * Por motivos de seguridad, las credenciales privadas del proyecto no se incluyen en el repositorio público.
   * Crea un proyecto en [Firebase Console](https://console.firebase.google.com/), registra la aplicación Android con el paquete correspondiente y habilita **Authentication** (Correo/Contraseña) y **Cloud Firestore**.
   * Descarga el archivo `google-services.json` y colócalo dentro de la carpeta `app/`.

4. **Compilar y ejecutar:**
   * Sincroniza el proyecto con Gradle en Android Studio y ejecútalo en tu dispositivo o emulador.

---

## 📌 Estado Actual del Desarrollo (`main`)

* [x] **Documentación técnica completa** (Actividades 1, 2 y 3).
* [x] **Configuración base del proyecto** y conexión con Firebase.
* [ ] **Autenticación completa** (Registro, Login y cierre de sesión con Firebase Auth).
* [ ] **Pantalla Home minimalista** y navegación principal.
* [ ] **Persistencia híbrida** (Room Database en local + sincronización con Cloud Firestore).
* [ ] **Módulos avanzados** (Calendario, temporizadores *Deep Work* / Pomodoro, mini-tests IA y cálculo MMR).