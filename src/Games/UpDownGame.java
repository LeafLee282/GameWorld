package Games;

import java.util.Scanner;

public class UpDownGame {
    //생성자
    public UpDownGame() { }

    //메소드

    //게임 시작 메소드
    public boolean startGame() {
        Scanner sc = new Scanner(System.in);
        boolean result = false;
        int randomNumber = (int)((Math.random()*100)+1);
        int number = 0;

        System.out.println();
        System.out.println("\u001B[36m" + "▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
        System.out.println("▌ UP-DOWN 게임을 시작합니다. ▌");
        System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬ \n");
        System.out.println("┌────────────────────────────────┐");
        System.out.println("  10번의 기회 내에 숫자를 맞추는 게임! ");
        System.out.println("└────────────────────────────────┘" + "\u001B[0m");
        System.out.println();

        System.out.println("1~100 사이의 숫자를 입력해주세요. \n");
        for(int i=0; i<10; i++) {
            while(true) {
                System.out.print((i+1) + "번째 : ");
                number = sc.nextInt();
                if(number>100 || number<1) {
                    System.out.println("100 이하의 숫자를 입력해주세요.");
                } else {
                    break;
                }
            }

            if(number > randomNumber) {
                System.out.println("Down");
            } else if(number < randomNumber) {
                System.out.println("Up");
            } else {
                System.out.println("\n\u001B[32m" + "정답입니다!" + "\u001B[0m \n");
                result = true;
                break;
            }
        }
        if(number != randomNumber) {
            System.out.println("\n\u001B[31m" + "패배하셨습니다." + "\u001B[0m \n");
        }
        return result;
    }
}
