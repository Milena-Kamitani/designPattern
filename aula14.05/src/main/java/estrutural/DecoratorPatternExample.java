package estrutural;

// Interface base para cursos
interface Curso {
    String getDescricao();
    double getCusto();
}

// Implementação básica de um curso
class CursoBasico implements Curso {
    @Override
    public String getDescricao() {
        return "Curso Básico";
    }

    @Override
    public double getCusto() {
        return 100.0;
    }
}

// Decorador para adicionar recursos online aos cursos
class CursoOnline implements Curso {
    private Curso cursoDecorado;

    public CursoOnline(Curso cursoDecorado) {
        this.cursoDecorado = cursoDecorado;
    }

    @Override
    public String getDescricao() {
        return cursoDecorado.getDescricao() + " + Acesso Online";
    }

    @Override
    public double getCusto() {
        return cursoDecorado.getCusto() + 50.0; // Adiciona o custo do acesso online
    }
}

// Teste da implementação
public class DecoratorPatternExample {
    public static void main(String[] args) {
        // Criando um curso básico
        Curso cursoBasico = new CursoBasico();
        System.out.println("Curso: " + cursoBasico.getDescricao());
        System.out.println("Custo: $" + cursoBasico.getCusto());

        // Adicionando recursos online ao curso básico usando o decorador
        Curso cursoComOnline = new CursoOnline(cursoBasico);
        System.out.println("\nCurso com Acesso Online: " + cursoComOnline.getDescricao());
        System.out.println("Custo: $" + cursoComOnline.getCusto());
    }
}
