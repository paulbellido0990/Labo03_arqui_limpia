
package com.academico.domain.repository;

import com.academico.domain.model.Curso;
import java.util.List;

public interface CursoRepository {

    // Obtener todos los cursos
    List<Curso> listar();

    // Guardar los cursos
    void guardar(List<Curso> cursos);
}
