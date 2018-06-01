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

## CRUD Usuario
**Listado de usuarios:**
> (GET) localhost:8080/user

**Creación de usuario**
> (POST) localhost:8080/user

**Edición de usuario**
> (PUT) localhost:8080/user/{idUser}

**Eliminación de usuario**
> (Delete) localhost:8080/user/{idUser}

## CRUD Curso
**Listado de cursos:**
> (GET) localhost:8080/course

**Creación de curso**
> (POST) localhost:8080/course

**Edición de curso**
> (PUT) localhost:8080/course/{idCourse}

**Eliminación de curso**
> (Delete) localhost:8080/course/{idCourse}

## Asignación de usuario a un curso
> (POST) localhost:8080/course/{idCourse}/user/{idUser}"

## CRUD Cuestionario
**Listado de cuestionarios del curso:**
> (GET) localhost:8080/course/{idCourse}/cuestionary

**Creación de cuestionario del curso**
> (POST) localhost:8080/course/{idCourse}/cuestionary

**Edición de cuestionario del curso**
> (PUT) localhost:8080/course/{idCourse}/cuestionary/{idCuestionary}

**Eliminación de cuestionario del curso**
> (Delete) localhost:8080/course/{idCourse}/cuestionary/{idCuestionary}

## Extra: CRUD TAG
**Listado de tags:**
> (GET) localhost:8080/tag

**Creación de tag**
> (POST) localhost:8080/tag

**Edición de tag**
> (PUT) localhost:8080/tag/{idTag}

**Eliminación de tag**
> (Delete) localhost:8080/tag/{idTag}

**Listado de tags del cuestionario**
> (GET) localhost:8080/course/{idCourse}/cuestionary/{idCuestionary}/tag

**Asignación de tag al cuestionario**
> (GET) localhost:8080/course/{idCourse}/cuestionary/{idCuestionary}/tag/{idTag}

## Extra: CRUD Difficulty
**Listado de dificultades:**
> (GET) localhost:8080/difficulty

**Creación de dificultad**
> (POST) localhost:8080/difficulty

**Edición de dificultad**
> (PUT) localhost:8080/difficulty/{idDifficulty}

**Eliminación de dificultad**
> (Delete) localhost:8080/difficulty/{idDifficulty}
