
package com.academico.application;

import com.academico.domain.model.Curso;
import com.academico.domain.repository.CursoRepository;

import java.util.List;

public class CursoService {

    private final CursoRepository repository;

    // Inyeccion de dependencias por constructor
    public CursoService(CursoRepository repository) {
        this.repository = repository;
    }

    // Registrar un nuevo curso
    public void registrar(Curso curso) {

        List<Curso> cursos = repository.listar();

        cursos.add(curso);

        repository.guardar(cursos);
    }

    // Listar todos los cursos
    public List<Curso> listar() {
        return repository.listar();
    }

    // Actualizar un curso existente
    public boolean actualizar(Curso curso) {

        List<Curso> cursos = repository.listar();

        for (Curso c : cursos) {

            if (c.getId() == curso.getId()) {

                c.setNombre(curso.getNombre());
                c.setCreditos(curso.getCreditos());

                repository.guardar(cursos);

                return true;
            }
        }

        return false;
    }

    // Eliminar un curso por ID
    public boolean eliminar(int id) {

        List<Curso> cursos = repository.listar();

        boolean eliminado = cursos.removeIf(
            c -> c.getId() == id
        );

        if (eliminado) {
            repository.guardar(cursos);
        }

        return eliminado;
    }
}
