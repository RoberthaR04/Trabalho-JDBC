package imobiliaria;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

// importa os DAOs
import daoimobiliaria.ClienteDAO;
import daoimobiliaria.ImovelDAO;
import daoimobiliaria.ContratoDAO;

// importa os modelos
import imobiliaria.Cliente;
import imobiliaria.Imovel;
import imobiliaria.Contrato;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ClienteDAO clienteDAO = new ClienteDAO();
        ImovelDAO imovelDAO = new ImovelDAO();
        ContratoDAO contratoDAO = new ContratoDAO();

        int opcao = 0;
        while (opcao != 7) {
            System.out.println("\n==== MENU IMOBILIÁRIA ====");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Cadastrar Contrato de Aluguel");
            System.out.println("3 - Listar Imóveis Disponíveis para Aluguel");
            System.out.println("4 - Listar Contratos Ativos");
            System.out.println("5 - Clientes com Mais Contratos");
            System.out.println("6 - Contratos Expirando nos Próximos 30 Dias");
            System.out.println("7 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            try {
                switch (opcao) {
                    case 1:
                        System.out.print("Nome do cliente: ");
                        String nome = sc.nextLine();
                        System.out.print("CPF: ");
                        String cpf = sc.nextLine();
                        System.out.print("Telefone: ");
                        String telefone = sc.nextLine();
                        System.out.print("Email: ");
                        String email = sc.nextLine();
                        Cliente c = new Cliente();
                        c.setNome(nome);
                        c.setCpf(cpf);
                        c.setEmail(email);
                        c.setTelefone(telefone);
                        clienteDAO.inserir(c);


                        System.out.println("✅ Cliente cadastrado!");
                        break;

                    case 2:
                        System.out.print("ID do Cliente: ");
                        int idCliente = sc.nextInt();
                        System.out.print("ID do Imóvel: ");
                        int idImovel = sc.nextInt();
                        System.out.print("Valor do aluguel: ");
                        double valor = sc.nextDouble();
                        sc.nextLine();
                        System.out.print("Data início (AAAA-MM-DD): ");
                        LocalDate inicio = LocalDate.parse(sc.nextLine());
                        System.out.print("Data fim (AAAA-MM-DD): ");
                        LocalDate fim = LocalDate.parse(sc.nextLine());

                        Contrato contrato = new Contrato();
                        contrato.setIdCliente(idCliente);
                        contrato.setIdImovel(idImovel);
                        contrato.setValor(valor);
                        contrato.setDataInicio(inicio);
                        contrato.setDataFim(fim);
                        contrato.setAtivo(true);

                        contratoDAO.inserir(contrato);
                        System.out.println("✅ Contrato cadastrado!");
                        break;

                    case 3:
                        List<Imovel> imoveis = imovelDAO.listarDisponiveis();
                        System.out.println("=== Imóveis disponíveis ===");
                        for (Imovel i : imoveis) {
                            System.out.println(i.getId() + " - " + i.getEndereco() + " (" + i.getTipo() + ")");
                        }
                        break;

                    case 4:
                        List<Contrato> contratos = contratoDAO.listarAtivos();
                        System.out.println("=== Contratos Ativos ===");
                        for (Contrato ct : contratos) {
                            System.out.println("Contrato " + ct.getId() + " | Cliente " + ct.getIdCliente() +
                                    " | Imóvel " + ct.getIdImovel() + " | Valor: " + ct.getValor());
                        }
                        break;

                    case 5:
                        List<Object[]> ranking = clienteDAO.clientesComMaisContratos();
                        System.out.println("=== Clientes com mais contratos ===");
                        for (Object[] linha : ranking) {
                            System.out.println("Cliente: " + linha[0] + " | Contratos: " + linha[1]);
                        }
                        break;

                    case 6:
                        List<Contrato> contratos2 = contratoDAO.listarAtivos();
                        System.out.println("=== Contratos expirando nos próximos 30 dias ===");
                        LocalDate hoje = LocalDate.now();
                        for (Contrato ct : contratos2) {
                            long dias = ChronoUnit.DAYS.between(hoje, ct.getDataFim());
                            if (dias >= 0 && dias <= 30) {
                                System.out.println("Contrato " + ct.getId() + " expira em " + dias + " dias");
                            }
                        }
                        break;

                    case 7:
                        System.out.println("Encerrando...");
                        break;

                    default:
                        System.out.println("❌ Opção inválida!");
                        break;
                }
            } catch (SQLException e) {
                System.out.println("Erro SQL: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }

        sc.close();
    }
}
