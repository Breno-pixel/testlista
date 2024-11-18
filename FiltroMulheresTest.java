import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class FiltroMulheresTest {

    @Test
    void testFiltroSomenteMulheres() {
        // Lista de teste
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Pessoa("Maria", "feminino"));
        pessoas.add(new Pessoa("João", "masculino"));
        pessoas.add(new Pessoa("Ana", "feminino"));
        pessoas.add(new Pessoa("Carlos", "masculino"));

        // Filtra apenas mulheres
        List<Pessoa> mulheres = pessoas.stream()
                .filter(pessoa -> "feminino".equalsIgnoreCase(pessoa.getGenero()))
                .collect(Collectors.toList());

        // Verificações
        Assertions.assertFalse(mulheres.isEmpty(), "A lista de mulheres não pode estar vazia.");
        Assertions.assertEquals(2, mulheres.size(), "Deve haver 2 mulheres na lista.");
        Assertions.assertTrue(mulheres.stream().allMatch(p -> "feminino".equalsIgnoreCase(p.getGenero())),
                "Todas as pessoas na lista devem ser do gênero feminino.");
    }
}
