import services.BlackJackService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var respostaJogador = "s";

        while (respostaJogador.equalsIgnoreCase("s")) {
            BlackJackService blackJackService = new BlackJackService();

            blackJackService.iniciarJogo();

            System.out.println("--- * Vamos jogar de novo? * ---");
            System.out.println("s / n");
            respostaJogador = scanner.nextLine().trim();
        }

        scanner.close();
    }
}
