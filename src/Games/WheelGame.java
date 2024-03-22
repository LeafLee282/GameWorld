package Games;

public class WheelGame {
    public boolean startGame() {
        boolean result = false;

        int[] randomNumber = new int[3];
        int count = 0;

        System.out.println();
        System.out.println("\u001B[36m" + "▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
        System.out.println("▌ 행운의 돌림판 게임을 시작합니다! ▌");
        System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬ \n");
        System.out.println("┌───────────────────────────────────────────┐");
        System.out.println("  ※ 3개의 숫자가 모두 같으면 이기는 게임입니다! ※");
        System.out.println("└───────────────────────────────────────────┘" + "\u001B[0m");
        System.out.println();

        for(int i=0; i<randomNumber.length; i++) {
            randomNumber[i] = (int)((Math.random()*7)+1);
            System.out.println((i+1) + "번째 숫자 : " + randomNumber[i]);
        }

        for (int i=0; i<randomNumber.length-1; i++) {
            if(randomNumber[i] == randomNumber[i+1]) {
                count++;
            }
        }

        if(count==2) {
            System.out.println();
            System.out.println("축하합니다. 세 숫자 모두 같습니다!");
            result = true;
        } else {
            System.out.println();
            System.out.println("맞추기에 실패하셨습니다.");
        }

        return result;
    }
}