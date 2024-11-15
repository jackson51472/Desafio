package Desafio2;

import java.util.ArrayList;
import java.util.List;

public class Challenge {
    // 6 Complexidade ciclomática
    public static ArrayList<ArrayList<Integer>> findSnakeOnGrid(ArrayList<String> grid) {
        int linhas = grid.size();
        int colunas = grid.get(0).length();

        ArrayList<ArrayList<Character>> matriz = formatarGrid(grid);

        ArrayList<ArrayList<Integer>> corpoCobra = findSnakeHead(matriz, linhas, colunas);
        if (corpoCobra == null) return null;

        int colunaAtual = corpoCobra.get(0).get(0);
        int linhaAtual = corpoCobra.get(0).get(1);

        while (true) {

            if (colunaAtual + 1 < colunas && matriz.get(linhaAtual).get(colunaAtual + 1) == '<') {
                colunaAtual++;
            } else if (colunaAtual - 1 >= 0 && matriz.get(linhaAtual).get(colunaAtual - 1) == '>') {
                colunaAtual--;
            } else if (linhaAtual + 1 < linhas && matriz.get(linhaAtual + 1).get(colunaAtual) == '^') {
                linhaAtual++;
            } else if (linhaAtual - 1 >= 0 && matriz.get(linhaAtual - 1).get(colunaAtual) == 'v') {
                linhaAtual--;
            } else {
                break;
            }

            corpoCobra.add(new ArrayList<>(List.of(colunaAtual, linhaAtual)));
        }
        return corpoCobra;
    }


    // 3 Complexidade ciclomática
    public static ArrayList<ArrayList<Character>> formatarGrid(ArrayList<String> grid) {
        ArrayList<ArrayList<Character>> matriz = new ArrayList<>();

        for (String linha : grid) {
            ArrayList<Character> linhaFormatada = new ArrayList<>();
            for (char c : linha.toCharArray()) {
                linhaFormatada.add(c);
            }
            matriz.add(linhaFormatada);
        }

        return matriz;
    }

    // 3 Complexidade ciclomática
    public static ArrayList<ArrayList<Integer>> findSnakeHead(ArrayList<ArrayList<Character>> matriz, Integer linhas, Integer colunas) {
        for (int linha = 0; linha < linhas; linha++) {
            for (int coluna = 0; coluna < colunas; coluna++) {
                if (matriz.get(linha).get(coluna) == 'h') {

                    ArrayList<ArrayList<Integer>> posicao = new ArrayList<>();
                    ArrayList<Integer> coordenadas = new ArrayList<>();

                    coordenadas.add(coluna);
                    coordenadas.add(linha);

                    posicao.add(coordenadas);
                    return posicao;
                }
            }
        }
        return null;
    }


}
