package br.com.academico.sistema.sistemaacademico.models.dao;

import br.com.academico.sistema.sistemaacademico.models.Aluno;
import br.com.academico.sistema.sistemaacademico.models.repository.AlunoRepository;
import br.com.academico.sistema.sistemaacademico.util.Conversor;
import br.com.academico.sistema.sistemaacademico.util.EntityManagerUtil;
import br.com.academico.sistema.sistemaacademico.util.Verificador;
import jakarta.persistence.*;

import java.util.List;
import java.util.Optional;

public class AlunoDao implements AlunoRepository {


    @Override
    public void insert(Aluno aluno) {
        //Cria um EntityManager para iniciar um persist dentro do try
        //Caso dê uma exceção cairá no catch e irá fazer um rollback do persist.
        //E ao final fechará a transação
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        try {

            entityManager.getTransaction().begin();
            entityManager.persist(aluno);
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
    public Optional<Aluno> findByMatricula(String matricula) {

        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            Aluno aluno = entityManager.find(Aluno.class, matricula);
            return Optional.ofNullable(aluno);
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
    public List<Aluno> FindAll() {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        try {
            String jpql = "Select a from Aluno a";
            TypedQuery<Aluno> query = entityManager.createQuery(jpql, Aluno.class);
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
    public void delete(Aluno aluno, String matricula) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            aluno = entityManager.find(Aluno.class, Conversor.convertToLong(matricula));
            entityManager.getTransaction().begin();
            entityManager.remove(aluno);
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
    public List<Aluno> findByCpf(String cpf) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            String JPQL = "FROM Aluno a WHERE a.cpf = :cpf";

            TypedQuery<Aluno> query = entityManager.createQuery(JPQL, Aluno.class);
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
    public List<Aluno> findByEmail(String email) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            String JPQL = "FROM Aluno a WHERE a.email = :email";

            TypedQuery<Aluno> query = entityManager.createQuery(JPQL, Aluno.class);
            query.setParameter("email", email);

            List<Aluno> aluno = query.getResultList();
            return aluno;
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
    public void update(Aluno aluno, String matricula, Long cpf, String sexo, String idade,
                       String senha, String linkFoto, String nome, String dataCriacao,
                       String dataTermino, String email) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            aluno = entityManager.find(Aluno.class, Conversor.convertToLong(matricula));

            Verificador.verificarNullAluno(aluno,matricula,cpf,sexo,idade,senha,
                              linkFoto,nome,dataCriacao,dataTermino,email);

            entityManager.getTransaction().begin();
            entityManager.merge(aluno);
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
