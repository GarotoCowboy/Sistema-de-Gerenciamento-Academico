package br.com.academico.sistema.sistemaacademico.models.dao;

import br.com.academico.sistema.sistemaacademico.models.Secretaria;
import br.com.academico.sistema.sistemaacademico.models.repository.SecretariaRepository;
import br.com.academico.sistema.sistemaacademico.util.Conversor;
import br.com.academico.sistema.sistemaacademico.util.EntityManagerUtil;
import br.com.academico.sistema.sistemaacademico.util.Verificador;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

public class SecretariaDao implements SecretariaRepository {
    @Override
    public void insert(Secretaria secretaria) {
        //Cria um EntityManager para iniciar um persist dentro do try
        //Caso dê uma exceção cairá no catch e irá fazer um rollback do persist.
        //E ao final fechará a transação
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        try {

            entityManager.getTransaction().begin();
            entityManager.persist(secretaria);
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
    public Optional<Secretaria> findByMatricula(String matricula) {

        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            Secretaria secretaria = entityManager.find(Secretaria.class, matricula);
            return Optional.ofNullable(secretaria);
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
    public List<Secretaria> findAll() {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        try {
            String jpql = "Select s from Secretaria s";
            TypedQuery<Secretaria> query = entityManager.createQuery(jpql, Secretaria.class);
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
    public void delete(Secretaria secretaria, String matricula) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            secretaria = entityManager.find(Secretaria.class, Conversor.convertToLong(matricula));
            entityManager.getTransaction().begin();
            entityManager.remove(secretaria);
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
    public List<Secretaria> findByCpf(String cpf) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            String JPQL = "FROM Secretaria s WHERE s.cpf = :cpf";

            TypedQuery<Secretaria> query = entityManager.createQuery(JPQL, Secretaria.class);
            query.setParameter("cpf", cpf);

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
    public List<Secretaria> findByEmail(String email) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            String JPQL = "FROM Secretaria s WHERE s.email = :email";

            TypedQuery<Secretaria> query = entityManager.createQuery(JPQL, Secretaria.class);
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
    //@Transactional
    public void update(Secretaria secretaria, String matricula, Long cpf, String sexo, String idade,
                       String senha, String linkFoto, String nome, String dataCriacao,
                       String dataTermino, String email) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            secretaria = entityManager.find(Secretaria.class, Conversor.convertToLong(matricula));

            Verificador.verificarNullSecretaria(secretaria,matricula,cpf,sexo,idade,senha,linkFoto,
                                                nome,dataCriacao,dataTermino,email);

            //Optional<Aluno> alunoAtualizadr = findByMatricula(matricula);

            entityManager.getTransaction().begin();
            entityManager.merge(secretaria);
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
