package br.com.academico.sistema.sistemaacademico.models.dao;

import br.com.academico.sistema.sistemaacademico.models.Aluno;
import br.com.academico.sistema.sistemaacademico.models.Pessoa;
import br.com.academico.sistema.sistemaacademico.models.repository.PessoaRepository;
import br.com.academico.sistema.sistemaacademico.util.Conversor;
import br.com.academico.sistema.sistemaacademico.util.EntityManagerUtil;
import br.com.academico.sistema.sistemaacademico.util.Verificador;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PessoaDao implements PessoaRepository {


    @Override
    public void insert(Pessoa pessoa) {
        //Cria um EntityManager para iniciar um persist dentro do try
        //Caso dê uma exceção cairá no catch e irá fazer um rollback do persist.
        //E ao final fechará a transação
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        try {

            entityManager.getTransaction().begin();
            entityManager.persist(pessoa);
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
    public Optional<Pessoa> findByMatricula(String matricula) {

        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            Pessoa pessoa = entityManager.find(Pessoa.class, matricula);
            return Optional.ofNullable(pessoa);
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
    public List<Pessoa> findAll() {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        try {
            String jpql = "Select a from Aluno a";
            TypedQuery<Pessoa> query = entityManager.createQuery(jpql, Pessoa.class);
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
    public void delete(Pessoa pessoa, String matricula) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            pessoa = entityManager.find(Pessoa.class, Conversor.convertToLong(matricula));
            entityManager.getTransaction().begin();
            entityManager.remove(pessoa);
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
    public Optional<Pessoa> findByCpf(String cpf) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            String JPQL = "FROM Pessoa p WHERE p.cpf = :cpf";

            TypedQuery<Pessoa> query = entityManager.createQuery(JPQL, Pessoa.class);
            query.setParameter("cpf", cpf);


            return Optional.ofNullable(query.getSingleResult());
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
    public Optional<Pessoa> findByEmail(String email) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            String JPQL = "FROM Pessoa p WHERE p.email = :email";

            TypedQuery<Pessoa> query = entityManager.createQuery(JPQL, Pessoa.class);
            query.setParameter("email", email);

            return Optional.ofNullable(query.getSingleResult());
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
    public void update(Pessoa pessoa, String matricula, Long cpf, String sexo, String idade,
                       String senha, String linkFoto, String nome, String dataCriacao,
                       String dataTermino, String email) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            pessoa = entityManager.find(Pessoa.class, Conversor.convertToLong(matricula));

            Verificador.verificarNullPessoa(pessoa,matricula,cpf,sexo,idade,senha,linkFoto,nome,
                                            dataCriacao,dataTermino,email);

            //Optional<Aluno> alunoAtualizadr = findByMatricula(matricula);

            entityManager.getTransaction().begin();
            entityManager.merge(pessoa);
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
