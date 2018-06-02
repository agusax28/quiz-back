# CursoJava - atSistemas (quiz-back)

## Requisitos
- [ ] 3 CRUD completos (usuarios, cuestionarios y preguntas)
	- [x] Usuarios
	- [x] Cuestionarios
	- [ ] Preguntas
- [x] Creación de cursos (alumnos, cuestionarios)
	- [x] Alumnos (usuarios) asignados a curso
	- [x] Al crear el cuestionario, es asignado en el curso (se crea dentro del curso)
- [ ] Recuperación resultados curso
- [ ] Petición preguntas de cuestionario 1 a 1 (aleatorio)
- [ ] Petición preguntas de cuestionario todo.
- [ ] Test de creación de cursos (del servicio)

## CRUD Usuario
**Listado de usuarios:**
> (GET) localhost:8080/user

**Usuario:**
> (GET) localhost:8080/user/{idUser}

**Creación de usuario**
> (POST) localhost:8080/user
{name, email, password}

**Edición de usuario**
> (PUT) localhost:8080/user/{idUser}
{name, email, password}

**Eliminación de usuario**
> (DELETE) localhost:8080/user/{idUser}

## CRUD Curso
**Listado de cursos:**
> (GET) localhost:8080/course

**Curso:**
> (GET) localhost:8080/course/{idCourse}

**Creación de curso**
> (POST) localhost:8080/course
{name}

**Edición de curso**
> (PUT) localhost:8080/course/{idCourse}
{name}

**Eliminación de curso**
> (DELETE) localhost:8080/course/{idCourse}

**Listado de usuarios del curso**
> (GET) localhost:8080/course/{idCourse}/user

## Asignación de usuario a un curso
> (POST) localhost:8080/course/{idCourse}/user/{idUser}"

## CRUD Cuestionario
**Listado de cuestionarios del curso:**
> (GET) localhost:8080/course/{idCourse}/questionary

**Cuestionario:**
> (GET) localhost:8080/course/{idCourse}/questionary/{idQuestionary}

**Creación de cuestionario del curso**
> (POST) localhost:8080/course/{idCourse}/questionary
{name}

**Edición de cuestionario del curso**
> (PUT) localhost:8080/course/{idCourse}/questionary/{idQuestionary}
{name}

**Eliminación de cuestionario del curso**
> (DELETE) localhost:8080/course/{idCourse}/questionary/{idQuestionary}

## CRUD Pregunta
**Listado de pregunta del cuestionario:**
> (GET) localhost:8080/cuestionary/{idQuestionary}/question

**Pregunta:**
> (GET) localhost:8080/question/{idQuestion}

**Creación de pregunta del cuestionario**
> (POST) localhost:8080/cuestionary/{idQuestionary}/question?tag={idTag}&difficulty={idDifficulty}
{name}

**Edición de pregunta**
> (PUT) localhost:8080/question/{idQuestion}?tag={idTag}&difficulty={idDifficulty}
{name}

**Eliminación de pregunta**
> (DELETE) localhost:8080/question/{idQuestion}

## Extra: CRUD TAG
**Listado de tags:**
> (GET) localhost:8080/tag

**Tags:**
> (GET) localhost:8080/tag/{idTag}

**Creación de tag**
> (POST) localhost:8080/tag
{name}

**Edición de tag**
> (PUT) localhost:8080/tag/{idTag}
{name}

**Eliminación de tag**
> (Delete) localhost:8080/tag/{idTag}

**Listado de tags del cuestionario**
> (GET) localhost:8080/course/{idCourse}/questionary/{idQuestionary}/tag

**Asignación de tag al cuestionario**
> (POST) localhost:8080/course/{idCourse}/questionary/{idQuestionary}/tag/{idTag}

## Extra: CRUD Dificultad
**Listado de dificultades:**
> (GET) localhost:8080/difficulty

**Dificultad:**
> (GET) localhost:8080/difficulty/{idDifficulty}

**Creación de dificultad**
> (POST) localhost:8080/difficulty
{name}

**Edición de dificultad**
> (PUT) localhost:8080/difficulty/{idDifficulty}

**Eliminación de dificultad**
> (DELETE) localhost:8080/difficulty/{idDifficulty}
