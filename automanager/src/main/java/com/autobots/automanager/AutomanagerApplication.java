package com.autobots.automanager;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.autobots.automanager.entidades.CredencialCodigoBarra;
import com.autobots.automanager.entidades.Documento;
import com.autobots.automanager.entidades.Email;
import com.autobots.automanager.entidades.Endereco;
import com.autobots.automanager.entidades.Telefone;
import com.autobots.automanager.entidades.Usuario;
import com.autobots.automanager.entidades.Veiculo;
import com.autobots.automanager.enumeracoes.PerfilUsuario;
import com.autobots.automanager.enumeracoes.TipoVeiculo;
import com.autobots.automanager.repositorios.UsuarioRepositorio;
import com.autobots.automanager.repositorios.VeiculoRepositorio;

@SpringBootApplication
public class AutomanagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutomanagerApplication.class, args);
    }

    @Component
    public static class Runner implements ApplicationRunner {

        @Autowired
        private UsuarioRepositorio usuarioRepositorio;

        @Autowired
        private VeiculoRepositorio veiculoRepositorio;

        @Override
        @Transactional
        public void run(ApplicationArguments args) throws Exception {

            // --- CLIENTE ---
            Usuario cliente = new Usuario();
            cliente.setNome("Pedro Alcntara de Bragana e Bourbon");
            cliente.setNomeSocial("Dom Pedro");
            cliente.getPerfis().add(PerfilUsuario.CLIENTE);

            Telefone telCliente = new Telefone();
            telCliente.setDdd("21");
            telCliente.setNumero("981234576");
            cliente.getTelefones().add(telCliente);

            Endereco endCliente = new Endereco();
            endCliente.setEstado("Rio de Janeiro");
            endCliente.setCidade("Rio de Janeiro");
            endCliente.setBairro("Copacabana");
            endCliente.setRua("Avenida Atlntica");
            endCliente.setNumero("1702");
            endCliente.setCodigoPostal("22021001");
            endCliente.setInformacoesAdicionais("Hotel Copacabana Palace");
            cliente.setEndereco(endCliente);

            Documento rgCliente = new Documento();
            rgCliente.setTipo("RG");
            rgCliente.setNumero("1500");
            cliente.getDocumentos().add(rgCliente);

            Documento cpfCliente = new Documento();
            cpfCliente.setTipo("CPF");
            cpfCliente.setNumero("00000000001");
            cliente.getDocumentos().add(cpfCliente);

            Email emailCliente = new Email();
            emailCliente.setEndereco("dompedro@imperio.br");
            cliente.getEmails().add(emailCliente);

            CredencialCodigoBarra credCliente = new CredencialCodigoBarra();
            credCliente.setCodigo(100000001L);
            credCliente.setInativo(false);
            credCliente.setCriacao(new Date());
            cliente.getCredenciais().add(credCliente);

            Usuario clienteSalvo = usuarioRepositorio.save(cliente);

            // Veculo vinculado ao cliente
            Veiculo veiculo = new Veiculo();
            veiculo.setTipo(TipoVeiculo.SEDA);
            veiculo.setModelo("Mercedes-Benz Classe S");
            veiculo.setPlaca("RIO1234");
            veiculo.setProprietario(clienteSalvo);

            Veiculo veiculoSalvo = veiculoRepositorio.save(veiculo);
            clienteSalvo.getVeiculos().add(veiculoSalvo);
            usuarioRepositorio.save(clienteSalvo);

            // --- FUNCIONARIO ---
            Usuario funcionario = new Usuario();
            funcionario.setNome("Isabel Cristina de Bragana");
            funcionario.setNomeSocial("Princesa Isabel");
            funcionario.getPerfis().add(PerfilUsuario.FUNCIONARIO);

            Telefone telFunc = new Telefone();
            telFunc.setDdd("24");
            telFunc.setNumero("933218765");
            funcionario.getTelefones().add(telFunc);

            Endereco endFunc = new Endereco();
            endFunc.setEstado("Rio de Janeiro");
            endFunc.setCidade("Petrpolis");
            endFunc.setBairro("Centro");
            endFunc.setRua("Rua da Imperatriz");
            endFunc.setNumero("350");
            endFunc.setCodigoPostal("25610060");
            endFunc.setInformacoesAdicionais("Casa 2");
            funcionario.setEndereco(endFunc);

            Documento rgFunc = new Documento();
            rgFunc.setTipo("RG");
            rgFunc.setNumero("4123987");
            funcionario.getDocumentos().add(rgFunc);

            Documento cpfFunc = new Documento();
            cpfFunc.setTipo("CPF");
            cpfFunc.setNumero("98765432100");
            funcionario.getDocumentos().add(cpfFunc);

            Email emailFunc = new Email();
            emailFunc.setEndereco("isabel@imperio.br");
            funcionario.getEmails().add(emailFunc);

            CredencialCodigoBarra credFunc = new CredencialCodigoBarra();
            credFunc.setCodigo(100000002L);
            credFunc.setInativo(false);
            credFunc.setCriacao(new Date());
            funcionario.getCredenciais().add(credFunc);

            usuarioRepositorio.save(funcionario);

            // --- FORNECEDOR ---
            Usuario fornecedor = new Usuario();
            fornecedor.setNome("Jos Bonifcio de Andrada e Silva");
            fornecedor.setNomeSocial("Patriarca");
            fornecedor.getPerfis().add(PerfilUsuario.FORNECEDOR);

            Telefone telForn = new Telefone();
            telForn.setDdd("13");
            telForn.setNumero("991234567");
            fornecedor.getTelefones().add(telForn);

            Endereco endForn = new Endereco();
            endForn.setEstado("So Paulo");
            endForn.setCidade("Santos");
            endForn.setBairro("Vila Mathias");
            endForn.setRua("Rua do Comrcio");
            endForn.setNumero("215");
            endForn.setCodigoPostal("11013020");
            endForn.setInformacoesAdicionais("Sobrado, porto azul");
            fornecedor.setEndereco(endForn);

            Documento rgForn = new Documento();
            rgForn.setTipo("RG");
            rgForn.setNumero("5544332");
            fornecedor.getDocumentos().add(rgForn);

            Documento cpfForn = new Documento();
            cpfForn.setTipo("CPF");
            cpfForn.setNumero("11122233344");
            fornecedor.getDocumentos().add(cpfForn);

            Email emailForn = new Email();
            emailForn.setEndereco("jose.bonifacio@imperio.br");
            fornecedor.getEmails().add(emailForn);

            CredencialCodigoBarra credForn = new CredencialCodigoBarra();
            credForn.setCodigo(100000003L);
            credForn.setInativo(false);
            credForn.setCriacao(new Date());
            fornecedor.getCredenciais().add(credForn);

            usuarioRepositorio.save(fornecedor);
        }
    }
}
