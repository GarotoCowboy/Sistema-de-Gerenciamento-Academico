package br.com.academico.sistema.sistemaacademico.models.dao;

import br.com.academico.sistema.sistemaacademico.models.Curso;
import br.com.academico.sistema.sistemaacademico.models.Disciplina;
import br.com.academico.sistema.sistemaacademico.models.Presenca;
import br.com.academico.sistema.sistemaacademico.models.Turma;
import br.com.academico.sistema.sistemaacademico.models.repository.TurmaRepository;
import br.com.academico.sistema.sistemaacademico.util.Conversor;
import br.com.academico.sistema.sistemaacademico.util.EntityManagerUtil;
import br.com.academico.sistema.sistemaacademico.util.Verificador;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

public class TurmaDao implements TurmaRepository {

    @Override
    public void insert(Turma turma) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            entityManager.getTransaction().begin();

            entityManager.persist(turma);

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
    public Optional<Turma> findById(String idTurma) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            Turma turma = entityManager.find(Turma.class, idTurma);
            return Optional.ofNullable(turma);
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
    public List<Turma> FindAll() {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            String JPQL = "Select d from Disciplina d";
            TypedQuery<Turma> query = entityManager.createQuery(JPQL, Turma.class);
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
    public void delete(Turma turma, String idTurma) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        try {
            turma = entityManager.find(Turma.class, Conversor.convertToLong(idTurma));
            entityManager.getTransaction().begin();
            entityManager.remove(turma);
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
    public void update(Turma turma, String idTurma, String nome, String periodo,
                       String qntdAluno, Curso fkIdCurso) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {

            Verificador.verificarNullTurma(turma,idTurma,nome,periodo,qntdAluno,fkIdCurso);

            entityManager.getTransaction().begin();
            entityManager.merge(turma);
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
