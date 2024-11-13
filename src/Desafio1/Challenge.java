public class Challenge {
    public static Integer calculaTotalLeds(Integer altura, Integer largura) {
        if (altura < 1 || largura < 1) {
            return 0;
        }
        return (altura + 1) * (largura + 1);
    }
}