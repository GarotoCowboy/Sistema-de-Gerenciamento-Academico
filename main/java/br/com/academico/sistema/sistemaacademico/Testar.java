package br.com.academico.sistema.sistemaacademico;

import br.com.academico.sistema.sistemaacademico.controllers.PessoaController;
import br.com.academico.sistema.sistemaacademico.models.*;
import br.com.academico.sistema.sistemaacademico.models.dao.AlunoDao;
import br.com.academico.sistema.sistemaacademico.models.dao.DisciplinaDao;
import br.com.academico.sistema.sistemaacademico.models.dao.PessoaDao;
import br.com.academico.sistema.sistemaacademico.util.Conversor;
import com.mysql.cj.Session;
import jakarta.persistence.*;
import org.hibernate.Hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class Testar {


    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("academico");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        DisciplinaDao  disciplinaDao= new DisciplinaDao();
        Disciplina disciplina = new Disciplina(null,null,"Redes de computadores2","Disciplina que visa ensinar sobre redes",32);

        disciplinaDao.update(disciplina,"1",Integer.toString(disciplina.getCargaHoraria()),null,disciplina.getNome(),disciplina.getFk_id_professor());
       entityManager.close();


       entityManagerFactory.close();

    }


}
