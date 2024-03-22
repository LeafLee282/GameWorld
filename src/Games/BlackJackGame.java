package Games;

import java.util.Scanner;

public class BlackJackGame {
    public boolean startGame() {
        boolean result = false;

        Scanner sc = new Scanner(System.in);
        boolean run = true;
        int[] dealer = new int[1];
        int[] user = new int[1];
        String menu;
        int dealerSum = 0;
        int userSum = 0;

        System.out.println();
        System.out.println("\u001B[36m" + "▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
        System.out.println("▌ 블랙잭 게임을 시작합니다. ▌");
        System.out.println("\u001B[36m" + "▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬ \n");
        System.out.println("┌──────────────────◇──────────────────┐");
        System.out.println("  숫자 21에 가깝게 만들어 딜러를 이기세요.");
        System.out.println("   카드는 1부터 10까지의 숫자가 나옵니다.");
        System.out.println("└──────────────────◇──────────────────┘" + "\u001B[0m");
        System.out.println(); System.out.println();

        while(run) {
            System.out.print("숫자를 뽑으시겠습니까?(y/n)\n → ");
            menu = sc.next();
            switch (menu) {
                case "y" :
                case "Y" :
                    System.out.println();

                    //user의 배열 길이 늘리기
                    user = extendArrayLength(user);
                    userSum = drawCard(user, "유저");

                    if(userSum == 21) {
                        System.out.println("유저가 " + "\u001B[32m" + "승리" + "\u001B[0m" + "했습니다.");
                        run = false;
                        result = true;
                    } else if(userSum > 21) {
                        System.out.println("유저가 " + "\u001B[31m" + "패배" + "\u001B[0m" + "했습니다.");
                        run = false;
                    }

                    break;
                case "n" :
                case "N" :
                    while(dealerSum<=userSum) {

                        //dealer의 배열 길이 늘리기
                        dealer = extendArrayLength(dealer);
                        dealerSum = drawCard(dealer, "딜러");
                    }
                    userSum=0;
                    for(int i : user) {
                        userSum += i;
                    }
                    if(dealerSum>userSum && dealerSum<=21) {
                        System.out.println("\u001B[31m" + "딜러" + "\u001B[0m" + "가 승리했습니다.");
                    } else if(dealerSum!=userSum){
                        System.out.println("\u001B[32m" + "유저" + "\u001B[0m" + "가 승리했습니다.");
                        result = true;
                    } else {
                        System.out.println("무승부입니다.");
                    }
                    System.out.println("\u001B[33m" + "────────────────────" + "\u001B[0m");
                    run = false;
                    break;
                default :
                    System.out.println("y/n 중에 입력해주세요.");
            }

            if((menu.equals("y") || menu.equals("Y") || menu.equals("n") || menu.equals("N")) && run) {

                //dealer의 배열 길이 늘리기
                dealer = extendArrayLength(dealer);
                dealerSum = drawCard(dealer, "딜러");

                if (dealerSum == 21) {
                    System.out.println("유저가 " + "\u001B[31m" + "패배" + "\u001B[0m" + "했습니다.");
                    run = false;
                } else if (dealerSum > 21) {
                    System.out.println("유저가 " + "\u001B[32m" + "승리" + "\u001B[0m" + "했습니다.");
                    result = true;
                    run = false;
                }
                System.out.println();
                System.out.println("\u001B[33m" + "─────────────────────────" + "\u001B[0m");
            }

        }

        return result;
    }

    //카드뽑기
    public int drawCard(int[] userNum, String user) {
        int sum = 0;

        userNum[userNum.length - 1] = (int) ((Math.random() * 10) + 1);
        System.out.println("┌───────────◇───────────┐");
        System.out.println("   " + user + "가 " + userNum[userNum.length - 1] + "를 뽑았습니다.");
        for (int i : userNum) {
            sum += i;
        }
        System.out.println("   " + user + "의 숫자의 총합 : " + sum);
        System.out.println("└───────────◇───────────┘");

        return sum;
    }

    //배열길이 늘리기
    public int[] extendArrayLength(int[] array) {
        int[] temp = array;
        array = new int[temp.length+1];
        for(int i=0; i<temp.length; i++) {
            array[i] = temp[i];
        }

        return array;
    }
}