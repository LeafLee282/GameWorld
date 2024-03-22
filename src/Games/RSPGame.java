package Games;

import java.util.Scanner;

public class RSPGame {
    public boolean startGame() {
        boolean result = false;

        boolean run = true;
        int random;
        String menu = null;
        String[] opponent = {"가위", "바위", "보"};
        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.println("\u001B[36m" + "▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
        System.out.println("▌ 가위바위보 게임을 시작합니다. ▌");
        System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬ \n");
        System.out.println("┌───────────────────────┐");
        System.out.println("  가위바위보를 이기는 게임! ");
        System.out.println("└───────────────────────┘" + "\u001B[0m");
        System.out.println();

        while(run) {
            System.out.print("가위, 바위, 보 중에서 입력해 주세요! \n → ");
            menu = sc.next();

            random = (int)((Math.random()*3));
            System.out.println();
            System.out.println("상대 : " + opponent[random]);
            switch (menu) {
                case "가위" :
                    switch (random) {
                        case 0 :
                            System.out.println("무승부입니다. 다시 입력해주세요!");
                            System.out.println();
                            break;
                        case 1 :
                            run = false;
                            System.out.println("\u001B[31m" + "패배하였습니다." + "\u001B[0m");
                            System.out.println();
                            break;
                        case 2 :
                            run = false;
                            result = true;
                            System.out.println("\u001B[32m" + "승리하였습니다." + "\u001B[0m");
                            System.out.println();
                    }
                    break;
                case "바위" :
                    switch (random) {
                        case 0 :
                            run = false;
                            result = true;
                            System.out.println("\u001B[32m" + "승리하였습니다." + "\u001B[0m");
                            System.out.println();
                            break;
                        case 1 :
                            System.out.println("무승부입니다. 다시 입력해주세요!");
                            System.out.println();
                            break;
                        case 2 :
                            run = false;
                            System.out.println("\u001B[31m" + "패배하였습니다." + "\u001B[0m");
                            System.out.println();
                    }
                    break;
                case "보" :
                    switch (random) {
                        case 0 :
                            run = false;
                            System.out.println("\u001B[31m" + "패배하였습니다." + "\u001B[0m");
                            System.out.println();
                            break;
                        case 1 :
                            run = false;
                            result = true;
                            System.out.println("\u001B[32m" + "승리하였습니다." + "\u001B[0m");
                            System.out.println();
                            break;
                        case 2 :
                            System.out.println("무승부입니다. 다시 입력해주세요!");
                            System.out.println();
                    }
                    break;
                default:
                    System.out.println("잘못 입력하셨습니다.");
                    System.out.println();
            }
        }

        return result;
    }
}