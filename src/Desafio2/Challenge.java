package Desafio2;

import java.util.ArrayList;

public class Challenge {

    public static ArrayList<ArrayList<Integer>> findSnakeOnGrid(ArrayList<String> grid) {
        int linhas = grid.size();
        int colunas = grid.get(0).length();

        ArrayList<ArrayList<Character>> matriz = new ArrayList<>();

        for (int i = 0; i < linhas; i++) {
            ArrayList<Character> linha = new ArrayList<>();
            for (int j = 0; j < colunas; j++) {
                linha.add(grid.get(i).charAt(j));
            }
            matriz.add(linha);
        }

        ArrayList<ArrayList<Integer>> corpoCobra = new ArrayList<>();

        boolean achou = true;
        for (int linha = 0; linha < linhas; linha++) {
            for (int coluna = 0; coluna < colunas; coluna++) {
                if (grid.get(linha).charAt(coluna) == 'h') {
                    ArrayList<Integer> posicao = new ArrayList<>();
                    posicao.add(0,coluna);
                    posicao.add(1,linha);

                    corpoCobra.add(0,posicao);
                    achou = false;
                    break;
                }
            }
            if (!achou) break;
        }

        int colunaAtual = corpoCobra.get(0).get(0);
        int linhaAtual = corpoCobra.get(0).get(1);

        while (true) {

            if (colunaAtual + 1 < colunas && matriz.get(linhaAtual).get(colunaAtual + 1).equals('<')) {
                colunaAtual = colunaAtual + 1;
                ArrayList<Integer> posicao = new ArrayList<>();
                posicao.add(0, colunaAtual);
                posicao.add(1, linhaAtual);
                corpoCobra.add(posicao);

            } else if (colunaAtual - 1 >= 0 && matriz.get(linhaAtual).get(colunaAtual - 1).equals('>')) {

                colunaAtual = colunaAtual - 1;
                ArrayList<Integer> posicao = new ArrayList<>();
                posicao.add(0, colunaAtual);
                posicao.add(1, linhaAtual);
                corpoCobra.add(posicao);

            } else if ((linhaAtual + 1 < linhas) && matriz.get(linhaAtual + 1).get(colunaAtual).equals('^')) {
                linhaAtual = linhaAtual + 1;
                ArrayList<Integer> posicao = new ArrayList<>();
                posicao.add(0, colunaAtual);
                posicao.add(1, linhaAtual);
                corpoCobra.add(posicao);

            } else if ((linhaAtual - 1 >= 0) && matriz.get(linhaAtual - 1).get(colunaAtual).equals('v')) {

                linhaAtual = linhaAtual - 1;
                ArrayList<Integer> posicao = new ArrayList<>();
                posicao.add(0, colunaAtual);
                posicao.add(1, linhaAtual);
                corpoCobra.add(posicao);

            } else {
                return corpoCobra;
            }
        }
    }
}
