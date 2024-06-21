package models;

import java.util.*;

// Adicionamos mais um parametro para o nome do jogador.

public class Jogador {

    public List<Carta> mao;
    public int pontuacao;
    private String nome;

    public Jogador(String nome) {
        this.mao = new ArrayList<>();
        this.pontuacao = 0;
        this.nome = nome;
    }

    public void adicionarCarta(Carta carta) {
        mao.add(carta);
        this.atualizarPontuacao(carta);
    }

    public List<Carta> getMao() {
        return mao;
    }

    public String getNome() {
        return nome;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public boolean getJoker() {
        for (Carta carta : mao) {
            if (carta.isCuringa()) {
                return true;
            }
        }
        return false;
    }

    private void atualizarPontuacao(Carta carta) {
        if (carta.getValor().equals("A")) {
            this.pontuacao += 11;
        } else if (carta.getValor().equals("J") || carta.getValor().equals("Q") || carta.getValor().equals("K")) {
            this.pontuacao += 10;
        } else if(carta.getValor().equals("Joker")) {
          this.pontuacao = 21;
        } else {
            this.pontuacao += Integer.parseInt(carta.getValor());
        }
    }

    public String imprimirMao() {
        StringJoiner cartasMao = new StringJoiner(", ");
        for (Carta carta : mao) {
            cartasMao.add(carta.toString());
        }
        return cartasMao.toString();
    }
}
