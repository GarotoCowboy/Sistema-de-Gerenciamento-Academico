package br.com.academico.sistema.sistemaacademico.util;

import br.com.academico.sistema.sistemaacademico.models.*;
import jakarta.persistence.EntityManager;

public class Verificador {

    public static Aluno verificarNullAluno(Aluno aluno, String matricula, Long cpf, String sexo, String idade,
                                           String senha, String linkFoto, String nome, String dataCriacao,
                                           String dataTermino, String email) {

        try {
            if (matricula != null) {
                aluno.setMatricula(Conversor.convertToLong(matricula));
            }
            if (cpf != null) {
                aluno.setCpf(cpf);
            }
            if (sexo != null) {
                aluno.setSexo(sexo);
            }
            if (idade != null) {
                aluno.setIdade(Conversor.convertToInt(idade));
            }
            if (senha != null) {
                aluno.setSenha(senha);

            }
            if (linkFoto != null) {
                aluno.setLinkFoto(linkFoto);

            }
            if (nome != null) {
                aluno.setNome(nome);

            }
            if (dataCriacao != null) {
                aluno.setDataCriacao(dataCriacao);

            }
            if (dataTermino != null) {
                aluno.setDataTermino(dataTermino);

            }
            if (email != null) {
                aluno.setEmail(email);
            }
            return aluno;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

    public static Professor verificarNullProfessor(Professor professor, String matricula, Long cpf, String sexo, String idade,
                                                   String senha, String linkFoto, String nome, String dataCriacao,
                                                   String dataTermino, String email) {

        try {
            if (matricula != null) {
                professor.setMatricula(Conversor.convertToLong(matricula));
            }
            if (cpf != null) {
                professor.setCpf(cpf);
            }
            if (sexo != null) {
                professor.setSexo(sexo);
            }
            if (idade != null) {
                professor.setIdade(Conversor.convertToInt(idade));
            }
            if (senha != null) {
                professor.setSenha(senha);

            }
            if (linkFoto != null) {
                professor.setLinkFoto(linkFoto);

            }
            if (nome != null) {
                professor.setNome(nome);

            }
            if (dataCriacao != null) {
                professor.setDataCriacao(dataCriacao);

            }
            if (dataTermino != null) {
                professor.setDataTermino(dataTermino);

            }
            if (email != null) {
                professor.setEmail(email);

            }
            return professor;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

    public static Secretaria verificarNullSecretaria(Secretaria secretaria, String matricula, Long cpf, String sexo, String idade,
                                                     String senha, String linkFoto, String nome, String dataCriacao,
                                                     String dataTermino, String email) {

        try {
            if (matricula != null) {
                secretaria.setMatricula(Conversor.convertToLong(matricula));
            }
            if (cpf != null) {
                secretaria.setCpf(cpf);
            }
            if (sexo != null) {
                secretaria.setSexo(sexo);
            }
            if (idade != null) {
                secretaria.setIdade(Conversor.convertToInt(idade));
            }
            if (senha != null) {
                secretaria.setSenha(senha);

            }
            if (linkFoto != null) {
                secretaria.setLinkFoto(linkFoto);

            }
            if (nome != null) {
                secretaria.setNome(nome);

            }
            if (dataCriacao != null) {
                secretaria.setDataCriacao(dataCriacao);

            }
            if (dataTermino != null) {
                secretaria.setDataTermino(dataTermino);

            }
            if (email != null) {
                secretaria.setEmail(email);

            }
            return secretaria;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }


    public static Curso verificarNullCurso(Curso curso, String idCurso, String cargaHoraria, String descricao,
                                           String horario, String nome, String salaDAula) {

        try {

            if (idCurso != null) {
                curso.setIdCurso(Conversor.convertToLong(idCurso));
            }
            if (cargaHoraria != null) {
                curso.setCargaHoraria(Conversor.convertToInt(cargaHoraria));
            }
            if (descricao != null) {
                curso.setDescricao(descricao);
            }
            if (nome != null) {
                curso.setNome(nome);
            }

            if (horario != null) {
                curso.setHorario(horario);
            }

            if (salaDAula != null) {
                curso.setSalaDAula(salaDAula);
            }
            return curso;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static Disciplina verificarNullDisciplina(Disciplina disciplina, String idDisciplina, String cargaHoraria, String descricao,
                                                     String nome, Professor fkMatriculaProf) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {

            if (idDisciplina != null) {
                disciplina.setIdDisciplina(Conversor.convertToLong(idDisciplina));
            }
            if (cargaHoraria != null) {
                disciplina.setCargaHoraria(Conversor.convertToInt(cargaHoraria));
            }
            if (descricao != null) {
                disciplina.setDescricao(descricao);
            }
            if (nome != null) {
                disciplina.setNome(nome);
            }

            if (fkMatriculaProf != null) {
                disciplina.setFk_id_professor(fkMatriculaProf);
            }
            return disciplina;

        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public static Pessoa verificarNullPessoa(Pessoa pessoa, String matricula, Long cpf, String sexo, String idade,
                                             String senha, String linkFoto, String nome, String dataCriacao,
                                             String dataTermino, String email) {

        try {
            if (matricula != null) {
                pessoa.setMatricula(Conversor.convertToLong(matricula));
            }
            if (cpf != null) {
                pessoa.setCpf(cpf);
            }
            if (sexo != null) {
                pessoa.setSexo(sexo);
            }
            if (idade != null) {
                pessoa.setIdade(Conversor.convertToInt(idade));
            }
            if (senha != null) {
                pessoa.setSenha(senha);

            }
            if (linkFoto != null) {
                pessoa.setLinkFoto(linkFoto);

            }
            if (nome != null) {
                pessoa.setNome(nome);

            }
            if (dataCriacao != null) {
                pessoa.setDataCriacao(dataCriacao);

            }
            if (dataTermino != null) {
                pessoa.setDataTermino(dataTermino);

            }
            if (email != null) {
                pessoa.setEmail(email);
            }
            return pessoa;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

    public static Presenca verificarNullPresenca(Presenca presenca, String idPresenca,Boolean ausente, String data, String justificativa,
                                             Disciplina fkIdDisciplina) {


        try {
            if (idPresenca != null) {
                presenca.setIdPresenca(Conversor.convertToLong(idPresenca));
            }
            if (ausente != null) {
                presenca.setAusente(ausente);
            }
            if (data != null) {
                presenca.setData(data);
            }
            if (justificativa != null) {
                presenca.setJustificativa(justificativa);
            }
            if (fkIdDisciplina != null) {
                presenca.setFkIdDisciplina(fkIdDisciplina);

            }

            return presenca;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

    public static Turma verificarNullTurma(Turma turma, String idTurma,String nome, String periodo, String qntdAluno,
                                                 Curso fkIdCurso) {


        try {
            if (idTurma != null) {
                turma.setIdTurma(Conversor.convertToLong(idTurma));
            }
            if (nome != null) {
                turma.setNome(nome);
            }
            if (periodo != null) {
                turma.setPeriodo(Conversor.convertToInt(periodo));
            }
            if (qntdAluno != null) {
                turma.setQntdAluno(Conversor.convertToInt(qntdAluno));
            }
            if (fkIdCurso != null) {
                turma.setFkIdCurso(fkIdCurso);

            }

            return turma;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }



}
