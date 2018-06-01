# CursoJava - atSistemas

## Proyect: quiz-back

## Requisitos
- 3 CRUD completos (preguntas, cuestionarios y usuario)
- Creación de cursos (alumnos, cuestionarios)
- Recuperación resultados curso
- Petición preguntas de cuestionario 1 a 1 (aleatorio)
- Petición preguntas de cuestionario todo.

## Realizado
###### CRUD Usuario
**Listado de usuarios:**
> (GET) localhost:8080/user

**Creación de usuario**
> (POST) localhost:8080/user

**Edición de usuario**
> (PUT) localhost:8080/user/{idUser}

**Eliminación de usuario**
> (Delete) localhost:8080/user/{idUser}

###### CRUD Curso
**Listado de cursos:**
> (GET) localhost:8080/course

**Creación de curso**
> (POST) localhost:8080/course

**Edición de curso**
> (PUT) localhost:8080/course/{idCourse}

**Eliminación de curso**
> (Delete) localhost:8080/course/{idCourse}

###### Asignación de usuario a un curso
> (POST) localhost:8080/course/{idCourse}/user/{idUser}"

###### CRUD Cuestionario
**Listado de cuestionarios del curso:**
> (GET) localhost:8080/course/{idCourse}/cuestionary

**Creación de cuestionario del curso**
> (POST) localhost:8080/course/{idCourse}/cuestionary

**Edición de cuestionario del curso**
> (PUT) localhost:8080/course/{idCourse}/cuestionary/{idCuestionary}

**Eliminación de cuestionario del curso**
> (Delete) localhost:8080/course/{idCourse}/cuestionary/{idCuestionary}