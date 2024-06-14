package br.com.academico.sistema.sistemaacademico.models.dao;

import br.com.academico.sistema.sistemaacademico.models.Aluno;
import br.com.academico.sistema.sistemaacademico.models.Disciplina;
import br.com.academico.sistema.sistemaacademico.models.Professor;
import br.com.academico.sistema.sistemaacademico.models.repository.DisciplinaRepository;
import br.com.academico.sistema.sistemaacademico.util.Conversor;
import br.com.academico.sistema.sistemaacademico.util.EntityManagerUtil;
import br.com.academico.sistema.sistemaacademico.util.Verificador;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

public class DisciplinaDao implements DisciplinaRepository {


    @Override
    public void insert(Disciplina disciplina) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            entityManager.getTransaction().begin();

            entityManager.persist(disciplina);

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
    public Optional<Disciplina> findById(String idDisciplina) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            Disciplina disciplina = entityManager.find(Disciplina.class, idDisciplina);
            return Optional.ofNullable(disciplina);
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
    public List<Disciplina> FindAll() {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            String JPQL = "Select d from Disciplina d";
            TypedQuery<Disciplina> query = entityManager.createQuery(JPQL, Disciplina.class);
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
    public void delete(Disciplina disciplina, String idDisciplina) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        try {
            disciplina = entityManager.find(Disciplina.class, Conversor.convertToLong(idDisciplina));
            entityManager.getTransaction().begin();
            entityManager.remove(disciplina);
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
    public void update(Disciplina disciplina, String idDisciplina, String cargaHoraria, String descricao,
                       String nome, Professor fkMatriculaProf) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {

            Verificador.verificarNullDisciplina(disciplina,idDisciplina,cargaHoraria,descricao,
                                                nome,fkMatriculaProf);

            entityManager.getTransaction().begin();
            entityManager.merge(disciplina);
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
