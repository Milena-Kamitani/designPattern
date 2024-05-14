package  criacional;
import java.util.List;
import java.util.ArrayList;

public class RegistroAlunos {
    private static RegistroAlunos instancia;

    private List<Aluno> listaAlunos;

    private RegistroAlunos() {
        listaAlunos = new ArrayList<>();
    }

    public static RegistroAlunos getInstancia() {
        if (instancia == null) {
            instancia = new RegistroAlunos();
        }
        return instancia;
    }

    public void adicionarAluno(Aluno aluno) {
        listaAlunos.add(aluno);
    }


    public void removerAluno(Aluno aluno) {
        listaAlunos.remove(aluno);
    }


    public List<Aluno> getListaAlunos() {
        return listaAlunos;
    }
}


class Aluno {
    private String nome;
    private int matricula;

    public Aluno(String nome, int matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public int getMatricula() {
        return matricula;
    }
}

// Testes da classe RegistroAlunos
class RegistroAlunosTest {
    public static void main(String[] args) {
        // Testando o Singleton
        testSingleton();

        // Testando a funcionalidade de adicionar e remover alunos
        testAdicionarRemoverAluno();
    }

    public static void testSingleton() {
        // Obtendo duas instâncias do RegistroAlunos
        RegistroAlunos registro1 = RegistroAlunos.getInstancia();
        RegistroAlunos registro2 = RegistroAlunos.getInstancia();

        // Verificando se as duas instâncias são iguais
        if (registro1 == registro2) {
            System.out.println("Singleton: Teste passou - As duas instâncias são iguais.");
        } else {
            System.out.println("Singleton: Teste falhou - As duas instâncias não são iguais.");
        }
    }

    public static void testAdicionarRemoverAluno() {
        RegistroAlunos registro = RegistroAlunos.getInstancia();

        // Criando alguns alunos
        Aluno aluno1 = new Aluno("João", 1001);
        Aluno aluno2 = new Aluno("Maria", 1002);

        // Adicionando os alunos ao registro
        registro.adicionarAluno(aluno1);
        registro.adicionarAluno(aluno2);

        // Verificando se os alunos foram adicionados corretamente
        List<Aluno> listaAlunos = registro.getListaAlunos();
        if (listaAlunos.size() == 2 && listaAlunos.contains(aluno1) && listaAlunos.contains(aluno2)) {
            System.out.println("Adicionar/Remover Aluno: Teste passou - Os alunos foram adicionados corretamente.");
        } else {
            System.out.println("Adicionar/Remover Aluno: Teste falhou - Os alunos não foram adicionados corretamente.");
        }

        // Removendo um aluno do registro
        registro.removerAluno(aluno1);

        // Verificando se o aluno foi removido corretamente
        listaAlunos = registro.getListaAlunos();
        if (listaAlunos.size() == 1 && !listaAlunos.contains(aluno1) && listaAlunos.contains(aluno2)) {
            System.out.println("Adicionar/Remover Aluno: Teste passou - O aluno foi removido corretamente.");
        } else {
            System.out.println("Adicionar/Remover Aluno: Teste falhou - O aluno não foi removido corretamente.");
        }
    }
}
