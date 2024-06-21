import Factory.BlackJackPlayerFactory;
import services.BlackJackService;

import java.util.Scanner;

// Fizemos algumas alterações no codigo para a implementação do padrao de projeto, alem de algumas melhorias.
// Iniciamos o jogo na classe main, o que ajuda a nao imprimir sempre o bem vindo quando começamos uma nova
// rodada apos um jogo

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var respostaJogador = "s";

        System.out.println("--- * Bem vindo ao BlackJack jogador * ---");
        System.out.println("Tente a sorte contra nosso Daeler.");
        System.out.println("--* Digite seu nome para começar *--");
        String nomeJogador = scanner.nextLine().trim();

        do {
            BlackJackService blackJackService = new BlackJackService(new BlackJackPlayerFactory(), nomeJogador);

            blackJackService.iniciarJogo();

            System.out.println("--- * Vamos jogar de novo? * ---");
            System.out.println("s / n");
            respostaJogador = scanner.nextLine().trim();
        }
        while (respostaJogador.equalsIgnoreCase("s"));

        scanner.close();
        System.out.println("Obrigado por jogar! Até a próxima.");
    }
}
