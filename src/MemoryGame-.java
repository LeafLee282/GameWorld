/*
import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class MemoryGame {
    //필드

    //생성자
    public MemoryGame() {

    }

    //메소드
    */
/*public boolean startGame() {
        boolean result = false;

        JFrame frame = new JFrame("메모리 게임");
        JPanel panel = new JPanel();
        Scanner sc = new Scanner(System.in);

        int[] randomNumber = new int[5];
        int num;
        int count = 0;
        String number = "";

        for(int i=0; i<5; i++) {
            num = (int)((Math.random()*100)+1);
            if(i!=0){
                number += ", " + num;
            } else {
                number += num;
            }
            randomNumber[i] = num;
        }

        frame.setSize(300, 400);                //창 크기 설정
        frame.setResizable(false);              //사용자 크기 조정 여부
        frame.setLocationRelativeTo(null);      //화면 가운데에 띄우기
        frame.setVisible(true);                 //화면에 보이게 하기

        JLabel label = new JLabel(number);      //JPanel에 넣을 JLabel생성
        panel.setLayout(new GridBagLayout());
        panel.add(label);

        frame.add(panel);

        System.out.println("창을 보시고 외우신 후 준비되시면 아무거나 눌러주세요.");
        sc.next();
        frame.dispose();        //자동으로 창 닫기

        System.out.println("====================");
        System.out.println("보신 순서대로 숫자를 입력해 주세요.");
        for(int i=0; i<5; i++) {
            System.out.print((i+1) + "번째 숫자 : ");
            num = sc.nextInt();
            if(num == randomNumber[i]) {
                count++;
            }
        }
        if(count==5) {
            result = true;
            System.out.println("맞추셨습니다.");
        } else {
            System.out.println("틀리셨습니다.");
        }
        System.out.println("====================");
        return result;
    }*//*


    public boolean startGame() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("──────────────────────────────────────────");
        System.out.println("\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠟⠛⠛⠙⠙⠙⠋⠛⠛⠻⠿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⠋⣁⣤⣦⣶⣷⣿⣿⣿⣿⣿⣿⣾⣶⣶⣤⣄⣉⠙⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠋⣠⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣧⣄⠉⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⢁⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠟⠋⡉⠛⠻⢿⣿⣿⣿⣿⣿⣿⣿⣿⣦⡈⠻⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡏⢠⣾⣿⣿⣿⣿⣿⣿⡿⡿⡿⠋⣠⣾⣿⣿⣿⣶⡀⢉⣁⣀⣁⡙⠻⣿⣿⣿⣷⣄⠙⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⢀⣿⣿⣿⣿⣿⣿⠟⢁⣤⣤⣤⣄⠘⢿⣿⣿⣿⣿⠛⠛⠛⢿⣿⣿⣆⠘⣿⣿⣿⣿⣆⠨⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠀⣾⣿⣿⣿⣿⣿⠇⢰⣿⣿⣿⣿⣿⣅⣸⣿⣿⣿⣿⣿⣿⣧⣬⣿⣿⣿⠀⣺⣿⣿⣿⣿⡆⠸⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⡯⠀⣿⣿⣿⣿⠟⢉⣀⠘⠻⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠛⢁⣄⡈⠛⣿⣿⣿⣿⠀⣻⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⡯⠀⣿⣿⣿⠃⣰⣿⣿⣷⣶⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣿⣿⣿⣦⠘⣿⣿⣿⡆⢸⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⠿⠋⣁⣴⣿⣿⣿⠀⣺⣿⣿⣿⣿⣿⣿⠛⢙⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠀⣿⣿⣿⡇⠰⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⡿⠛⢁⣴⣾⣿⣿⣿⣿⣿⣧⠈⠻⣿⣿⣿⣿⠃⣰⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢿⠿⠋⣁⣼⣿⣿⣿⡇⢘⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⡃⠸⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⣄⣁⣁⣁⣀⣈⣈⣈⣈⣈⣈⣈⡉⠻⣿⣿⡟⠁⣤⣦⣶⣾⣿⣿⣿⣿⣿⡇⢨⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣶⡀⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡀⢽⣿⡇⠨⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⣺⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⡿⠃⣰⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⠈⠿⠇⠨⣿⣿⣿⣿⣿⣿⣿⣿⠇⢰⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⡧⠈⢛⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣶⣶⣾⣿⣿⣿⣿⣿⣿⣿⠋⢠⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣇⠘⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠋⣠⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⡶⠀⣽⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠃⣰⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⠁⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠁⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠁⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣦⡈⠛⠿⠿⣿⢿⡿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠃⣸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣷⣶⣦⣤⣤⣤⣤⣀⠹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡗⢀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⠈⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡃⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡆⠘⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠄⢽⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣤⣄⣄⣄⣄⣄⣄⣄⣄⣄⣄⣄⣄⣄⣄⣄⣄⣄⣄⣤⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
        System.out.println();
        System.out.println();
        System.out.println("\u001B[36m" + "▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
        System.out.println("▌ Welcome to Memory Game! \uD83E\uDD14▐");
        System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("┌──────────────────────────────────────────────────────┐");
        System.out.println("  ※ 0 ~ 50 사이의 랜덤숫자 5개를 기억한 뒤 입력하는 게임! ※ ");
        System.out.println("└──────────────────────────────────────────────────────┘");


        int[] sequence = generateSequence(5);
        displaySequence(sequence);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("\u001B[0m" + "자 정답을 하나씩 입력해주세요!");
        System.out.print("▶ ");

        boolean correct = checkSequence(sequence, scanner);

        if (correct) {
            System.out.println("와우 대단해요! 모든 숫자들을 맞추었어요!");
        } else {
            System.out.println("땡.. 다시 도전하세요!");
        }
        return correct;
    }

    public static int[] generateSequence(int length) {
        int[] sequence = new int[length];
        for (int i = 0; i < length; i++) {
            sequence[i] = (int) (Math.random() * 51);
        }
        return sequence;
    }

    public static void displaySequence(int[] sequence) {
        System.out.println();
        System.out.println();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.print("\u001B[33m" + "두근두근! 숫자를 불러오는 중입니다... ");
        System.out.println();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println();
        System.out.println("\u001B[0m" + "짠! 5초 뒤 사라집니다~");
        for (int num : sequence) {
            System.out.print("\u001B[31m" + num + " ");
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println();
        for (int i = 0; i < 50; i++) {
            System.out.print("      ");
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println();
        }
        */
/*System.out.print("     ▼ ");*//*

    }

    public static boolean checkSequence(int[] sequence, Scanner scanner) {
        for (int num : sequence) {
            int input = scanner.nextInt();
            if (input != num) {
                return false;
            }
        }
        return true;
    }
}*/
