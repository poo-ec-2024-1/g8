

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


 // A classe de teste da clasee Paciente.
 
public class PacienteTest
{
    /**
     * Construtor default para a classe de teste PacienteTest
     */
    public PacienteTest()
    {
        Paciente jeovane = new Paciente("Jeovane", 23,'m');
        assertEquals("Jeovane", jeovane.getNome());
        assertEquals(23, jeovane.getIdade());
        assertEquals('m' , jeovane.getSexo());
    }

    /**
     * Define a 'fixture' do teste.
     *
     * Chamado antes de cada método de caso de teste.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Desfaz a 'fixture' do teste.
     *
     * Chamado após cada método de teste de caso.
     */
    @AfterEach
    public void tearDown()
    {
    }

    @Test
    public void testepaciente()
    {Paciente jeovane = new Paciente("Jeovane", 23,'m');
        assertEquals("Jeovane", jeovane.getNome());
        assertEquals(23, jeovane.getIdade());
        assertEquals('m' , jeovane.getSexo());
    }

    @Test
    public void TesteId()
    {
        Paciente paciente2 = new Paciente("Iker", 20, 'f');
        assertEquals(1, paciente2.getId());
        paciente2.setId(2);
        assertEquals(2, paciente2.getId());
    }
}


