import java.util.ArrayList;

public class SnakePathFinder {

    public static ArrayList<ArrayList<Integer>> findSnakeOnGrid(ArrayList<String> grid) {
        int rows = grid.size();
        int cols = grid.get(0).length();
        ArrayList<ArrayList<Integer>> path = new ArrayList<>();

        // Encontra a posição da cabeça da cobra
        int headX = -1, headY = -1;
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                if (grid.get(y).charAt(x) == 'h') {
                    headX = x;
                    headY = y;
                    break;
                }
            }
            if (headX != -1) break; // Encerra o laço externo se a cabeça for encontrada
        }

        // Adiciona a posição da cabeça ao caminho
        ArrayList<Integer> headPosition = new ArrayList<>();
        headPosition.add(headX);
        headPosition.add(headY);
        path.add(headPosition);

        // Define direções para cada caractere
        int[][] directions = {
                {'>', 1, 0},  // Direita
                {'<', -1, 0}, // Esquerda
                {'v', 0, 1},  // Baixo
                {'^', 0, -1}  // Cima
        };

        // Variáveis para a posição atual
        int currentX = headX;
        int currentY = headY;

        // Segue o caminho da cobra até a cauda
        while (true) {
            boolean foundNext = false;

            for (int[] dir : directions) {
                char arrow = (char) dir[0];
                int dx = dir[1];
                int dy = dir[2];
                int nextX = currentX + dx;
                int nextY = currentY + dy;

                // Verifica se a próxima posição está dentro da grade e é uma seta válida
                if (nextY >= 0 && nextY < rows && nextX >= 0 && nextX < cols
                        && grid.get(nextY).charAt(nextX) == arrow) {
                    ArrayList<Integer> nextPosition = new ArrayList<>();
                    nextPosition.add(nextX);
                    nextPosition.add(nextY);
                    path.add(nextPosition);
                    currentX = nextX;
                    currentY = nextY;
                    foundNext = true;
                    break;
                }
            }

            // Para quando não encontrar o próximo segmento
            if (!foundNext) break;
        }

        return path;
    }

    public static void main(String[] args) {
        ArrayList<String> grid = new ArrayList<>();
        grid.add(" >>h   ");
        grid.add(" ^   v ");
        grid.add(" ^<<<< ");

        ArrayList<ArrayList<Integer>> path = findSnakeOnGrid(grid);

        for (ArrayList<Integer> position : path) {
            System.out.println(position);
        }
    }
}
