import java.util.Scanner;

public class Virus {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        int porcentagemRisco = 0;
        
        boolean retornandoDeViagem = false;

        System.out.println("--- Rastreamento Viral: Questionário de Risco ---");
        System.out.println("Por favor, responda às perguntas para avaliação de risco de expansão viral.");
        System.out.println("-------------------------------------------------");

        System.out.print("Informe o seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Informe a sua idade: ");
        
        int idade;
        try {
            idade = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Idade inválida. Considerando 0 para prosseguir.");
            idade = 0;
        }

        System.out.println("\n--- Responda com SIM ou NAO ---");

        System.out.print("Seu cartão de vacina está em dia? (SIM/NAO): ");
        String vacina = scanner.nextLine().trim().toUpperCase();
        if (vacina.equals("NAO")) {
            porcentagemRisco += 10;
        }

        System.out.print("Teve algum dos sintomas recentemente? (dor de cabeça, febre, náusea, dor articular, gripe) (SIM/NAO): ");
        String sintomas = scanner.nextLine().trim().toUpperCase();
        if (sintomas.equals("SIM")) {
            porcentagemRisco += 30;
        }

        System.out.print("Teve contato com pessoas com sintomas gripais nos últimos dias? (SIM/NAO): ");
        String contato = scanner.nextLine().trim().toUpperCase();
        if (contato.equals("SIM")) {
            porcentagemRisco += 30;
        }

        System.out.print("Está retornando de viagem realizada no exterior? (SIM/NAO): ");
        String viagem = scanner.nextLine().trim().toUpperCase();
        if (viagem.equals("SIM")) {
            porcentagemRisco += 30;
            retornandoDeViagem = true; 
        }

        if (porcentagemRisco > 100) {
            porcentagemRisco = 100;
        } 
        System.out.println("\n--- Resultado da Avaliação de Risco ---");
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade + " anos");
        System.out.println("Porcentagem de Risco Calculada: " + porcentagemRisco + "%");
        System.out.print("Orientação: ");

        if (porcentagemRisco <= 30) {
            if (!retornandoDeViagem) {
                
                System.out.println("Paciente sob observação. Caso apareça algum sintoma, gentileza buscar assistência médica.");
            } else {
                
                System.out.println("Você ficará sob observação por 05 dias.");
            }
        } else if (porcentagemRisco <= 60) {
            
            System.out.println("Paciente com risco de estar infectado. Gentileza aguardar em lockdown por 02 dias para ser acompanhado.");
        } else if (porcentagemRisco < 90) {
            
            System.out.println("Paciente com alto risco de estar infectado. Gentileza aguardar em lockdown por 05 dias para ser acompanhado.");
        } else { 
            System.out.println("Paciente crítico! Gentileza aguardar em lockdown por 10 dias para ser acompanhado");
        }
        
        System.out.println("----------------------------------------");
        
        scanner.close();
    }
}