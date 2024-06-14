package br.com.academico.sistema.sistemaacademico.models.dao;

import br.com.academico.sistema.sistemaacademico.models.Aluno;
import br.com.academico.sistema.sistemaacademico.models.Professor;
import br.com.academico.sistema.sistemaacademico.models.repository.ProfessorRepository;
import br.com.academico.sistema.sistemaacademico.util.Conversor;
import br.com.academico.sistema.sistemaacademico.util.EntityManagerUtil;
import br.com.academico.sistema.sistemaacademico.util.Verificador;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

public class ProfessorDao implements ProfessorRepository {
    @Override
    public void insert(Professor professor) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        try {

            entityManager.getTransaction().begin();
            entityManager.persist(professor);
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
    public Optional<Professor> findByMatricula(String matricula) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            Professor professor = entityManager.find(Professor.class, matricula);
            return Optional.ofNullable(professor);
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
    public List<Professor> FindAll() {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        try {
            String jpql = "Select p from Professor p";
            TypedQuery<Professor> query = entityManager.createQuery(jpql, Professor.class);
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
    public void delete(Professor professor, String matricula) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            professor = entityManager.find(Professor.class, Conversor.convertToLong(matricula));
            entityManager.getTransaction().begin();
            entityManager.remove(professor);
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
    public List<Professor> findByCpf(String cpf) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            String JPQL = "FROM Professor p WHERE p.cpf = :cpf";

            TypedQuery<Professor> query = entityManager.createQuery(JPQL, Professor.class);
            query.setParameter("cpf", cpf);
            //List<Aluno> aluno;

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
    public List<Professor> findByEmail(String email) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            String JPQL = "FROM Professor p WHERE p.email = :email";

            TypedQuery<Professor> query = entityManager.createQuery(JPQL, Professor.class);
            query.setParameter("email", email);

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
    public void update(Professor professor, String matricula, Long cpf, String sexo, String idade,
                       String senha, String linkFoto, String nome, String dataCriacao,
                       String dataTermino, String email) {

        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            professor = entityManager.find(Professor.class, Conversor.convertToLong(matricula));

            Verificador.verificarNullProfessor(professor,matricula,cpf,sexo,idade,senha,linkFoto,
                                                nome,dataCriacao,dataTermino,email);


            entityManager.getTransaction().begin();
            entityManager.merge(professor);
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

