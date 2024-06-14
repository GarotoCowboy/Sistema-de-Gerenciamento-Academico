package br.com.academico.sistema.sistemaacademico.models.dao;

import br.com.academico.sistema.sistemaacademico.models.Disciplina;
import br.com.academico.sistema.sistemaacademico.models.Professor;
import br.com.academico.sistema.sistemaacademico.models.repository.PresencaRepository;
import br.com.academico.sistema.sistemaacademico.util.Conversor;
import br.com.academico.sistema.sistemaacademico.util.EntityManagerUtil;
import br.com.academico.sistema.sistemaacademico.util.Verificador;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import br.com.academico.sistema.sistemaacademico.models.Presenca;

import java.util.List;
import java.util.Optional;

public class PresencaDao implements PresencaRepository {

    @Override
    public void insert(Presenca presenca) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            entityManager.getTransaction().begin();

            entityManager.persist(presenca);

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
    public Optional<Presenca> findById(String idPresenca) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            Presenca presenca = entityManager.find(Presenca.class, idPresenca);
            return Optional.ofNullable(presenca);
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
    public List<Presenca> FindAll() {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            String JPQL = "Select d from Disciplina d";
            TypedQuery<Presenca> query = entityManager.createQuery(JPQL, Presenca.class);
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
    public void delete(Presenca presenca, String idPresenca) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        try {
            presenca = entityManager.find(Presenca.class, Conversor.convertToLong(idPresenca));
            entityManager.getTransaction().begin();
            entityManager.remove(presenca);
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
    public void update(Presenca presenca, String idPresenca, Boolean ausente, String data,
                       String justificativa, Disciplina fkIdDisciplina) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {

            Verificador.verificarNullPresenca(presenca,idPresenca,ausente,data,justificativa,fkIdDisciplina);

            entityManager.getTransaction().begin();
            entityManager.merge(presenca);
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
