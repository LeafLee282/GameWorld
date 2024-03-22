package GameMain;

import GameSQL.*;
import Games.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //입력(Scanner)을 위한 객체
        Scanner sc = new Scanner(System.in);

        GameUser user = new GameUser();
        GameSQL sql = new GameSQL();

        WheelGame wheel = new WheelGame();
        UpDownGame upDown = new UpDownGame();
        MemoryGame memory = new MemoryGame();
        HangManGame hangMan = new HangManGame();
        RSPGame rspGame = new RSPGame();
        BlackJackGame blackJack = new BlackJackGame();

        boolean run = true; //프로그램 실행을 위한 변수 : run
        int menu = 0;       //메뉴를 입력받기 위한 변수 : menu

        boolean runLogin = true; //login 프로그램 실행을 위한 변수 : run
        int menuLogin = 0;       //login 메뉴를 입력받기 위한 변수 : menu

        boolean winOrLose = false;

        sql.Connect();      //DB 연결

        System.out.println();
        System.out.println(GameSQL.red + " ____                                     \n" +
                GameSQL.yellow + "/\\  _`\\                                   \n" +
                GameSQL.green + "\\ \\ \\L\\_\\     __       ___ ___       __   \n" +
                GameSQL.cyan + " \\ \\ \\L_L   /'__`\\   /' __` __`\\   /'__`\\ \n" +
                GameSQL.blue + "  \\ \\ \\/, \\/\\ \\L\\.\\_ /\\ \\/\\ \\/\\ \\ /\\  __/ \n" +
                GameSQL.purple + "   \\ \\____/\\ \\__/.\\_\\\\ \\_\\ \\_\\ \\_\\\\ \\____\\\n" +
                GameSQL.red + "    \\/___/  \\/__/\\/_/ \\/_/\\/_/\\/_/ \\/____/\n"+
                GameSQL.red + " __      __                    ___        __     \n" +
                GameSQL.yellow + "/\\ \\  __/\\ \\                  /\\_ \\      /\\ \\    \n" +
                GameSQL.green + "\\ \\ \\/\\ \\ \\ \\    ___    _ __  \\//\\ \\     \\_\\ \\   \n" +
                GameSQL.cyan + " \\ \\ \\ \\ \\ \\ \\  / __`\\ /\\`'__\\  \\ \\ \\    /'_` \\  \n" +
                GameSQL.blue + "  \\ \\ \\_/ \\_\\ \\/\\ \\L\\ \\\\ \\ \\/    \\_\\ \\_ /\\ \\L\\ \\ \n" +
                GameSQL.purple + "   \\ `\\___x___/\\ \\____/ \\ \\_\\    /\\____\\\\ \\___,_\\\n" +
                GameSQL.red + "    '\\/__//__/  \\/___/   \\/_/    \\/____/ \\/__,_ /\n");

        System.out.println();
        System.out.println();
        System.out.println("\u001B[33m" + "★ 미니게임천국에 오신 것을 환영합니다! ★" + GameSQL.exit);

        while (run) {
            System.out.println();
            System.out.println("─────────────────────────────");
            System.out.println(" [1]회원가입 [2]로그인 [3]종료");
            System.out.println("─────────────────────────────");
            System.out.print("메뉴 선택 → ");
            menu = sc.nextInt();

            switch (menu) {
                case 1:
                    System.out.print(" 아이디 입력 → ");
                    user.setgId(sc.next());

                    System.out.print(" 비밀번호 입력 → ");
                    user.setgPw(sc.next());

                    System.out.print(" 닉네임 입력 → ");
                    user.setgName(sc.next());

                    sql.gameJoin(user);
                    break;
                case 2:
                    System.out.print(" 아이디 입력 → ");
                    String id = sc.next();

                    System.out.print(" 비밀번호 입력 → ");
                    String pw = sc.next();

                    runLogin = sql.gameLogin(id, pw);

                    while (runLogin) {
                        System.out.println("─────────────────────────────────────────────────");
                        System.out.println(" [1]돌림판\t[2]메모리\t[3]행맨\t\t[4]가위바위보");
                        System.out.println(" [5]업다운\t[6]블랙잭\t[7]내정보\t[8]로그아웃");
                        System.out.println("─────────────────────────────────────────────────");
                        System.out.print("메뉴 선택 → ");
                        menuLogin = sc.nextInt();
                        runLogin = true;

                        if (!sql.checkGrecord(id, menuLogin) && menuLogin < 7) {     //유저 전적 조회
                            sql.createGrecord(id, menuLogin);   //유저 전적 생성
                        }
                        if(menuLogin < 7 && menuLogin > 0) {
                            if(!sql.gameMoney(id, menuLogin)) {      //게임에 들어가는 돈 차감
                                menuLogin = 0;
                            }
                            sql.changeTier(id);                     //유저 티어 변경
                        }

                        switch (menuLogin) {
                            case 0 :
                                System.out.println("돈이 부족합니다.");
                                break;
                            case 1:
                                //각 게임마다 승패
                                winOrLose = wheel.startGame();
                                break;
                            case 2:
                                winOrLose = memory.startGame();
                                break;
                            case 3:
                                winOrLose = hangMan.startGame();
                                break;
                            case 4 :
                                winOrLose = rspGame.startGame();
                                break;
                            case 5 :
                                winOrLose = upDown.startGame();
                                break;
                            case 6 :
                                winOrLose = blackJack.startGame();
                                break;
                            case 7:
                                sql.myData(id);     //자신의 정보 확인
                                sql.mySolely(id);   //게임별 전적 확인
                                break;
                            case 8:
                                runLogin = false;

                                System.out.println(GameSQL.red + "로그아웃 되었습니다." + GameSQL.exit);
                                break;
                            default:
                                System.out.println("다시 입력해주세요!");
                        }
                        if (winOrLose && menuLogin < 7) {            //게임 시작 및 승리, 패배 확인
                            sql.changeSolely(id, menuLogin, 1, 0);  //승리 전적 변경
                            sql.changeMoney(id, menuLogin);         //승리시 돈 획득
                            sql.setGameExp(id, menuLogin);          //승리시 경험치 획득
                        } else if (menuLogin < 7){
                            sql.changeSolely(id, menuLogin, 0, 1);  //패배 전적 변경
                        }
                    }
                    break;
                case 3:
                    sql.conClose();     //DB와 연결 끊기
                    run = false;
                    System.out.println(GameSQL.red + "게임을 종료합니다." + GameSQL.exit);
                    break;
                default:
                    System.out.println("다시 입력해주세요!");
            }
        }
    }
}