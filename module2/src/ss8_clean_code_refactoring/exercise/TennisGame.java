package ss8_clean_code_refactoring.exercise;

public class TennisGame {
    public static String getScore(String player1Name, String player2Name, int player1Score, int player2Score) {
        String alert = "";
        int tempScore = 0;
        boolean isDraw = player1Score == player2Score;
        if (isDraw) {
            alert = alertWhenDraw(player1Score);
        } else {
            boolean isGreaterThan4 = player1Score >= 4 || player2Score >= 4;
            if (isGreaterThan4) {
                alert = alertWhenPlayerWon(player1Score, player2Score);
            } else {
                alert = alertWhenIDK(player1Score, player2Score, alert);
            }
        }
        return alert;
    }

    private static String alertWhenIDK(int player1Score, int player2Score, String alert) {
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = player1Score;
            else {
                alert += "-";
                tempScore = player2Score;
            }
            switch (tempScore) {
                case 0:
                    alert += "Love";
                    break;
                case 1:
                    alert += "Fifteen";
                    break;
                case 2:
                    alert += "Thirty";
                    break;
                case 3:
                    alert += "Forty";
                    break;
            }
        }
        return alert;
    }

    private static String alertWhenPlayerWon(int player1Score, int player2Score) {
        String alert;
        int minusResult = player1Score - player2Score;
        if (minusResult == 1) alert = "Advantage player1";
        else if (minusResult == -1) alert = "Advantage player2";
        else if (minusResult >= 2) alert = "Win for player1";
        else alert = "Win for player2";
        return alert;
    }

    private static String alertWhenDraw(int player1Score) {
        String alert;
        switch (player1Score) {
            case 0:
                alert = "Love-All";
                break;
            case 1:
                alert = "Fifteen-All";
                break;
            case 2:
                alert = "Thirty-All";
                break;
            case 3:
                alert = "Forty-All";
                break;
            default:
                alert = "Deuce";
                break;

        }
        return alert;
    }
}
