package com.example.demo.repository;

import com.example.demo.entity.Cliente;
import com.example.demo.entity.Persona;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClienteRepositoryTest {

    @Autowired
    private ClienteRepository clienteRepository;

    @Rollback(value = false)
    @DisplayName(("Junit test for save cliente"))
    @Test
    public void givenClienteObject_whenSave_thenReturnSavedCliente() {

        //given - precondition or setup (replaced by setup method)
        Cliente cliente = new Cliente();
        cliente.setNombre("Joan");
        cliente.setEdad(18);
        cliente.setDireccion("Calle 46");
        cliente.setIdentificacion("1075");
        cliente.setTelefono("311");
        cliente.setPassword("1234");
        cliente.setEstado("A");

        //when - action or the behavior that we are going to test
        Cliente savedCliente = clienteRepository.save(cliente);

        //then - verify the output
        assertThat(savedCliente).isNotNull();
        assertThat(savedCliente.getId()).isGreaterThan(0);

    }

    @Rollback(value = false)
    @DisplayName(("Junit test for get cliente"))
    @Test
    public void givenId_whenGet_thenReturnCliente() {

        //given - precondition or setup (replaced by setup method)
        Cliente cliente = new Cliente();
        cliente.setNombre("Joan");
        cliente.setEdad(18);
        cliente.setDireccion("Calle 46");
        cliente.setIdentificacion("1075");
        cliente.setTelefono("311");
        cliente.setPassword("1234");
        cliente.setEstado("A");

        //when - action or the behavior that we are going to test
        Cliente savedCliente = clienteRepository.save(cliente);

        Cliente retrievedCliente = clienteRepository.getReferenceById(savedCliente.getId());

        //then - verify the output
        assertThat(retrievedCliente).isNotNull();
        assertThat(retrievedCliente.getNombre()).isEqualTo(cliente.getNombre());

    }
}
