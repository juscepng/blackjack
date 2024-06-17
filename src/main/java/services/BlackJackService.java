package services;

import Factory.PlayerFactory;
import models.Baralho;
import models.Dealer;
import models.Jogador;

import java.util.Scanner;

public class BlackJackService {
    private final Baralho baralho;
    private final Jogador jogador;
    private final Dealer dealer;

    public BlackJackService(PlayerFactory playerFactory) {
        this.baralho = new Baralho();

        // Com a factory, criamos o jogadore e o dealer, antes do jogo começar.

        this.jogador = playerFactory.criarJogador();
        this.dealer = playerFactory.criarDealer();
    }

    public void iniciarJogo() {
        Scanner scanner = new Scanner(System.in);
        var continuarJogador = true;
        var continuarDealer = true;

        print("--- * Bem vindo ao BlackJack jogador * ---");
        print("Tente a sorte contra nosso Daeler.");

        print("--* Precione enter para começar *--");
        scanner.nextLine();

        cartasIniciais();

        mostrarMaoJogador();

        if (vitoriaImediataJogador()) {
            return;
        }

        print("Delar começa com... ");
        print("Mão do dealer: " + dealer.imprimirMaoDealer());

        if (vitoriaImediataDealer()) {
            return;
        }

        print("--* Rodada do jogador *--");

        while (jogador.getPontuacao() < 21 && continuarJogador) {
            System.out.println("Deseja mais uma carta jogador? s / n");
            if (scanner.nextLine().equals("s")) {
                jogador.adicionarCarta(baralho.puxarCarta());
                mostrarMaoJogador();
                if (jogador.getJoker()) {
                    print("--**--");
                    print("Jogador tem um joker! Parabéns, você ganhou com ajuda...");
                    return;
                }
            } else {
                continuarJogador = false;
                break;
            }
        }

        print("--* Rodada do dealer *--");

        if (jogador.getPontuacao() < 21) {
            while (dealer.getPontuacao() < 21 && continuarDealer) {
                System.out.println("Deseja mais uma carta dealer?");

                if (dealer.validarPuxarCarta(jogador.getPontuacao(), dealer.getPontuacao())) {
                    print("s");
                    dealer.adicionarCarta(baralho.puxarCarta());
                    mostrarMaoDealer();
                    if (dealer.getJoker()) {
                        print("Dealer tem um joker hahahaha");
                        print("--**--");
                        print("Dessa vez o dealer riu mais alto hahahaha");
                        return;
                    }
                } else {
                    print("n");
                    continuarDealer = false;
                    break;
                }
            }
        }

        System.out.println("--- * Fim de jogo * ---");

        determinarVencedor();
    }

    public void cartasIniciais() {
        for (int i = 0; i < 2; i++) {
            jogador.adicionarCarta(baralho.puxarCarta());
            dealer.adicionarCarta(baralho.puxarCarta());
        }
    }

    public boolean vitoriaImediataJogador() {
        if (this.jogador.getJoker()) {
            print("Mão do jogador: " + this.jogador.imprimirMao());
            print("--**--");
            print("Jogador tem um joker! Parabéns, você ganhou com ajuda...");
            return true;
        } else if (this.jogador.getPontuacao() == 21) {
            print("Mão do jogador: " + this.jogador.imprimirMao());
            print("--**--");
            print("Jogador tem 21! Parabéns, você ganhou de primeira!");
            return true;
        }
        return false;
    }

    public boolean vitoriaImediataDealer() {
        if (this.dealer.getJoker()) {
            print("Dealer tem um joker hahahaha");
            print("--**--");
            print("Dessa vez o dealer riu mais alto hahahaha");
            return true;
        }
        return false;
    }

    private void mostrarMaoJogador() {
        print("Mão do jogador: " + jogador.imprimirMao());
        print("Jogador tem uma mão total de " + jogador.getPontuacao());
    }

    private void mostrarMaoDealer() {
        print("Mão do dealer: " + dealer.imprimirMao());
        print("Dealer tem uma mão total de " + dealer.getPontuacao());
    }

    private void determinarVencedor(){
        mostrarMaoJogador();
        mostrarMaoDealer();

        print("--**--");

        if (jogador.getPontuacao() > 21) {
            print("Jogador perdeu...");
        } else if (dealer.getPontuacao() > 21) {
            print("Jogador venceu!");
        } else if (jogador.getPontuacao() > dealer.getPontuacao()) {
            print("Jogador venceu!");
        } else if (dealer.getPontuacao() == jogador.getPontuacao()) {
            print("Empate!");
        } else {
            print("Essa foi do dealer...");
        }

    }

    public void print(String message) {
        System.out.println(message);
    }
}
