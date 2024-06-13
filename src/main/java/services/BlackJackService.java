package services;

import models.Baralho;
import models.Dealer;
import models.Jogador;

import java.util.Scanner;

public class BlackJackService {
    private final Baralho baralho;
    private final Jogador jogador;
    private final Dealer dealer;

    public BlackJackService() {
        this.baralho = new Baralho();
        this.jogador = new Jogador();
        this.dealer = new Dealer();
    }

    public void iniciarJogo() {
        Scanner scanner = new Scanner(System.in);
        var proximoJogador = true;
        var proximoDealer = true;

        print("--- * Bem vindo ao BlackJack jogador * ---");
        print("Tente a sorte contra nosso Daeler.");
        print("Vamos comecar...");

        while (jogador.getMao().size() < 2) {
            jogador.adicionarCarta(baralho.puxarCarta());

            if (jogador.getJoker()) {
                jogador.imprimirMao();
                print("Jogador tem um joker hahahaha");
                print("Parabens, voce ganhou, mas com ajuda...");
                return;
            } else if (jogador.getPontuacao() == 21) {
                jogador.imprimirMao();
                print("Jogador tem 21!");
                print("Parabens, voce ganhou de primeira, que raro!!");
                return;
            }
        }


        print("Jogador tem " + jogador.getPontuacao());
        jogador.imprimirMao();


        while (dealer.getMao().size() < 2) {
            dealer.adicionarCarta(baralho.puxarCarta());
        }

        var cartaExibida = dealer.getMao().getFirst();
        if(cartaExibida.isCuringa()) {
            print("Dealer tem um joker hahahaha");
            print("Dessa vez quem riu foi a mesa hahahaha");
            return;
        }

        print("Dealer tem ");
        dealer.imprimirMaoDealer();

        while (jogador.getPontuacao() < 21 && proximoJogador) {
            System.out.println("Deseja mais uma carta jogador? s / n");
            if (scanner.nextLine().equals("s")) {
                jogador.adicionarCarta(baralho.puxarCarta());
                print("Jogador tem " + jogador.getPontuacao());
                jogador.imprimirMao();
            } else {
                proximoJogador = false;
                break;
            }
        }

        if (jogador.getPontuacao() < 21) {
            while (dealer.getPontuacao() < 21 && proximoDealer) {
                System.out.println("Deseja mais uma carta dealer?");

                if (dealer.validarPuxarCarta(jogador.getPontuacao(), dealer.getPontuacao())) {
                    print("s");
                    dealer.adicionarCarta(baralho.puxarCarta());
                    print("Dealer tem " + dealer.getPontuacao());
                    dealer.imprimirMao();
                } else {
                    print("n");
                    proximoDealer = false;
                    break;
                }
            }
        }

        System.out.println("--- * Fim de jogo * ---");

        print("Jogador tem " + jogador.getPontuacao());
        jogador.imprimirMao();

        print("Dealer tem " + dealer.getPontuacao());
        dealer.imprimirMao();

        if (jogador.getPontuacao() > 21) {
            print("Jogador perdeu...");
        } else if (dealer.getPontuacao() > 21) {
            print("Jogador venceu!");
        } else if (jogador.getPontuacao() > dealer.getPontuacao()) {
            print("Jogador venceu!");
        } else if(dealer.getPontuacao() == jogador.getPontuacao()) {
            print("Empate!");
        }
        else {
            print("Essa foi do dealer...");
        }


    }

    public void print(String message) {
        System.out.println(message);
    }
}
