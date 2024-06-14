package br.com.academico.sistema.sistemaacademico.models.dao;

import br.com.academico.sistema.sistemaacademico.models.Curso;
import br.com.academico.sistema.sistemaacademico.models.Disciplina;
import br.com.academico.sistema.sistemaacademico.models.Professor;
import br.com.academico.sistema.sistemaacademico.models.repository.CursoRepository;
import br.com.academico.sistema.sistemaacademico.util.Conversor;
import br.com.academico.sistema.sistemaacademico.util.EntityManagerUtil;
import br.com.academico.sistema.sistemaacademico.util.Verificador;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

public class CursoDao implements CursoRepository {

    @Override
    public void insert(Curso curso) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            entityManager.getTransaction().begin();

            entityManager.persist(curso);

            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }

            ex.printStackTrace();
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public Optional<Curso> findById(String idCurso) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            Curso curso = entityManager.find(Curso.class, idCurso);
            return Optional.ofNullable(curso);
        } catch (Exception ex) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            ex.printStackTrace();

            return Optional.empty();
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public List<Curso> findAll() {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            String JPQL = "Select c from Curso c";
            TypedQuery<Curso> query = entityManager.createQuery(JPQL, Curso.class);
            return query.getResultList();
        } catch (Exception ex) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            ex.printStackTrace();

            return null;
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public void delete(Curso curso, String idCurso) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        try {
            curso = entityManager.find(Curso.class, Conversor.convertToLong(idCurso));
            entityManager.getTransaction().begin();
            entityManager.remove(curso);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }

            ex.printStackTrace();
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public void update(Curso curso, String idCurso, String cargaHoraria, String descricao,
                       String horario ,String nome, String salaDAula) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            Verificador.verificarNullCurso(curso,idCurso,cargaHoraria,descricao,horario,
                                            nome,salaDAula);

            entityManager.getTransaction().begin();
            entityManager.merge(curso);
            entityManager.getTransaction().commit();

        } catch (Exception ex) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            ex.printStackTrace();
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

}
