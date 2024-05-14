package comportamental;

// Interface para representar um comando
interface Comando {
    void executar();
}

// Classe que representa uma solicitação de transcrição de registros acadêmicos
class SolicitacaoTranscricao implements Comando {
    private String aluno;

    public SolicitacaoTranscricao(String aluno) {
        this.aluno = aluno;
    }

    @Override
    public void executar() {
        System.out.println("Solicitando transcrição de registros acadêmicos para o aluno: " + aluno);
        // Aqui iria a lógica para processar a solicitação de transcrição
    }
}

// Classe que representa um gerenciador de solicitações
class GerenciadorSolicitacoes {
    public void processarSolicitacao(Comando comando) {
        comando.executar();
    }
}

// Teste da implementação
public class CommandPatternExample {
    public static void main(String[] args) {
        // Criando solicitações de transcrição para dois alunos
        Comando solicitacaoAluno1 = new SolicitacaoTranscricao("João");
        Comando solicitacaoAluno2 = new SolicitacaoTranscricao("Maria");

        // Criando um gerenciador de solicitações
        GerenciadorSolicitacoes gerenciador = new GerenciadorSolicitacoes();

        // Processando as solicitações
        gerenciador.processarSolicitacao(solicitacaoAluno1);
        gerenciador.processarSolicitacao(solicitacaoAluno2);
    }
}
