package services;

import Factory.PlayerFactory;
import models.Baralho;
import models.Dealer;
import models.Jogador;

import java.util.Scanner;

// Fazemos a instancia do blackjackService passando a factory e o nome do jogador, chamando as instancias unicas
// do dealer e do baralho. Alem disso sempre limpamos a mao do delaer no começo da partida.

public class BlackJackService {
    private final Baralho baralho;
    private final Jogador jogador;
    private final Dealer dealer;

    public BlackJackService(PlayerFactory playerFactory, String nomeJogador) {
        this.baralho = Baralho.getInstance();

        this.jogador = playerFactory.criarJogador(nomeJogador);
        this.dealer = playerFactory.criarDealer();
    }

    public void iniciarJogo() {
        Scanner scanner = new Scanner(System.in);
        var continuarJogador = true;
        var continuarDealer = true;

        dealer.limparMao();

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

        if (jogador.getPontuacao() < 21) {
            print("--* Rodada do jogador *--");
            while (jogador.getPontuacao() < 21 && continuarJogador) {
                System.out.println("Deseja mais uma carta " + jogador.getNome() + "? s / n");
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
        }

        if (jogador.getPontuacao() < 21) {
            print("--* Rodada do dealer *--");
            while (dealer.getPontuacao() < 21 && continuarDealer) {
                print("Mão do dealer: " + dealer.imprimirMao());
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
            print("--**--");
            print("Jogador tem um joker! Parabéns, você ganhou com ajuda...");
            return true;
        } else if (this.jogador.getPontuacao() == 21) {
            print("--**--");
            print("Jogador tem 21! Parabéns, você ganhou de primeira!");
            return true;
        }
        return false;
    }

    public boolean vitoriaImediataDealer() {
        if (this.dealer.getJoker()) {
            print("Mão do dealer: " + this.dealer.imprimirMao());
            print("Dealer tem um joker hahahaha");
            print("--**--");
            print("Dessa vez o dealer riu mais alto hahahaha");
            return true;
        }
        return false;
    }

    private void mostrarMaoJogador() {
        print("Mão do jogador " + jogador.getNome() + ": " + jogador.imprimirMao());
        print("Jogador tem uma mão total de " + jogador.getPontuacao());
    }

    private void mostrarMaoDealer() {
        print("Mão do dealer: " + dealer.imprimirMao());
        print("Dealer tem uma mão total de " + dealer.getPontuacao());
    }

    private void determinarVencedor() {
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
