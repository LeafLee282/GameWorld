package Games;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class MemoryGame {
    //필드
    //생성자

    //메소드
    public boolean startGame() { // 메소드 생성
        Scanner scanner = new Scanner(System.in); // 입력받을 스캐너

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
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣤⣄⣄⣄⣄⣄⣄⣄⣄⣄⣄⣄⣄⣄⣄⣄⣄⣄⣄⣤⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n");

        // 게임 처음 실행 시 뜨는 창
        System.out.println();
        System.out.println("\u001B[36m" + "▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
        System.out.println("▌ Welcome to Memory Game! \uD83E\uDD14▐");
        System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬ \n");
        System.out.println("┌───────────────────────────────────────────────────────┐");
        System.out.println("  ※ 0 ~ 50 사이의 랜덤숫자 5개를 기억한 뒤 입력하는 게임! ※ ");
        System.out.println("└───────────────────────────────────────────────────────┘");


        int[] sequence = generateSequence(5); // 함수를 사용해 배열 생성 (정수를 저장하는 배열 생성)
        displaySequence(sequence); // 함수를 호출해 출력 (정수 배열을 인자로 받아 배열의 요소를 출력)

        System.out.println();
        System.out.println("\u001B[0m" + "자 정답을 하나씩 입력해주세요!");

        boolean correct = checkSequence(sequence, scanner);
        // checkSequence : 함수를 호출해 사용자가 입력한 값이 배열에 존재하는지 확인하고 결과를 correct 변수에 저장
        // checkSequence(sequence, scanner) : 함수는 정수배열과 Scanner 객체를 인용
        // boolean correct = checkSequence(sequence, scanner) : 함수를 호출해 사용자가 입력한 값이 배열에 존재하는지 확인

        if (correct) { // 정답 여부
            System.out.println("와우 대단해요! 모든 숫자들을 맞추었어요!");
        } else {
            System.out.println("땡.. 다시 도전하세요!");
        }
        return correct;
    }

    public static int[] generateSequence(int length) {
        int[] sequence = new int[length];
        for (int i = 0; i < length; i++) {
            sequence[i] = (int)((Math.random() * 50)+1);
        }
        return sequence;
    }

    public static void displaySequence(int[] sequence) {
        JFrame frame = new JFrame("짠! 5초 뒤 사라집니다~");
        JPanel panel = new JPanel();
        String number;

        System.out.println();
        System.out.println();

        frame.setSize(400, 300);                //창 크기 설정
        frame.setResizable(false);              //사용자 크기 조정 여부
        frame.setLocationRelativeTo(null);      //화면 가운데에 띄우기
        frame.setVisible(true);                 //화면에 보이게 하기

        System.out.println("\u001B[33m" + "두근두근! 숫자를 불러오는 중입니다... \n");

        number = String.valueOf(sequence[0]);
        for (int i=1; i<sequence.length; i++) {
            number += " " + sequence[i];
        }

        JLabel label = new JLabel(number);      //JPanel에 넣을 JLabel생성
        panel.setLayout(new GridBagLayout());
        panel.add(label);
        frame.add(panel);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        frame.dispose();        //자동으로 창 닫기
    }

    public static boolean checkSequence(int[] sequence, Scanner scanner) {
        int count = 1;
        for (int num : sequence) {
            System.out.print(count + "번째 : ");
            count++;
            int input = scanner.nextInt();
            if (input != num) {
                return false;
            }
        }
        return true;
    }
}