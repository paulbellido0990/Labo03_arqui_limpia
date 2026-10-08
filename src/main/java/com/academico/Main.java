
package com.academico;

import com.academico.application.EstudianteService;
import com.academico.application.CursoService;

import com.academico.domain.repository.EstudianteRepository;
import com.academico.domain.repository.CursoRepository;

import com.academico.infrastructure.persistence.EstudianteRepositoryJson;
import com.academico.infrastructure.persistence.CursoRepositoryJson;

import com.academico.presentation.EstudianteUI;
import com.academico.presentation.CursoUI;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // ====================================
        // CASO 1: GESTION DE ESTUDIANTES
        // ====================================

        // Infraestructura
        EstudianteRepository estudianteRepository =
                new EstudianteRepositoryJson();

        // Aplicacion
        EstudianteService estudianteService =
                new EstudianteService(estudianteRepository);

        // Presentacion
        EstudianteUI estudianteUI =
                new EstudianteUI(estudianteService);


        // ====================================
        // CASO 2: GESTION DE CURSOS
        // ====================================

        // Infraestructura
        CursoRepository cursoRepository =
                new CursoRepositoryJson();

        // Aplicacion
        CursoService cursoService =
                new CursoService(cursoRepository);

        // Presentacion
        CursoUI cursoUI =
                new CursoUI(cursoService);


        // ====================================
        // MENU PRINCIPAL
        // ====================================

        Scanner sc = new Scanner(System.in);

        int opcion;

        do {

            System.out.println(
                "\n=== SISTEMA DE GESTION ACADEMICA ==="
            );

            System.out.println("1. Gestionar estudiantes");
            System.out.println("2. Gestionar cursos");
            System.out.println("0. Salir");

            System.out.print("Seleccione una opcion: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    estudianteUI.mostrarMenu(sc);
                    break;

                case 2:
                    cursoUI.mostrarMenu(sc);
                    break;

                case 0:
                    System.out.println("Sistema finalizado.");
                    break;

                default:
                    System.out.println("Opcion no valida.");
                    break;
            }

        } while (opcion != 0);

        sc.close();
    }
}
