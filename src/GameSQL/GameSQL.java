package GameSQL;

import javax.swing.*;
import java.sql.*;

public class GameSQL {
    //SQL클래스에서 CRUD를 사용하는 3가지 객체
    //DB에 접속하기 위한 연결(Connection) 객체 : con
    Connection con;

    //SQL 쿼리문 전달을 위한 (PreparedStatement)객체 : pstmt
    PreparedStatement pstmt;

    //DB에서 조회(select)한 결과(ResultSet)을 담을 객체 : rs
    ResultSet rs;

    private JFrame frame = new JFrame();

    public static final String black = "\u001B[30m";
    public static final String red = "\u001B[31m";
    public static final String green = "\u001B[32m";
    public static final String yellow = "\u001B[33m";
    public static final String blue = "\u001B[34m";
    public static final String purple = "\u001B[35m";
    public static final String cyan = "\u001B[36m";

    public static final String exit = "\u001B[0m"; // 색 초기화

    //DB 접속
    public void Connect() {
        con = DBC.DBConnect();
    }

    //DB 접속해제
    public void conClose() {
        try {
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //회원가입 메소드
    public void gameJoin(GameUser user) {
        try {
            //1 sql문 작성
            String sql = "INSERT INTO GAMEUSER VALUES(?, ?, ?, 1, 0, 10000)";

            //2 db준비
            pstmt = con.prepareStatement(sql);

            //3 데이터 입력
            pstmt.setString(1, user.getgId());
            pstmt.setString(2, user.getgPw());
            pstmt.setString(3, user.getgName());

            //4 실행
            int result = pstmt.executeUpdate();

            //5 결과
            if(result > 0) {
                System.out.println(green + "{ 회원가입 성공! }" + exit);
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println(red + "{ 회원가입 실패 }" + exit);
            System.out.println(red + "- 중복된 이름입니다. -" + exit);
            System.out.println();
        }
    }

    //로그인 메소드
    public boolean gameLogin(String id, String pw) {
        boolean result = false;

        try {
            //1
            String sql = "SELECT * FROM GAMEUSER WHERE GID=? AND GPW=?";

            //2
            pstmt = con.prepareStatement(sql);

            //3
            pstmt.setString(1, id);
            pstmt.setString(2, pw);

            //4
            rs = pstmt.executeQuery();

            //5
            if(rs.next()) {
                System.out.println(green + "{ 로그인 성공! }" + exit);
                System.out.println();
                result = true;
            } else {
                System.out.println(red + "{ 로그인 실패 }" + exit);
                System.out.println();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    //전적 변경 메소드
    public void changeSolely(String gId, int gRecord, int vcount, int dcount) {
        try {
            //1
            String sql = "UPDATE GRECORD SET VCOUNT=VCOUNT+?, DCOUNT=DCOUNT+? WHERE GID=? AND GNUM=?";

            //2
            pstmt = con.prepareStatement(sql);

            //3
            pstmt.setInt(1, vcount);
            pstmt.setInt(2, dcount);
            pstmt.setString(3, gId);
            pstmt.setInt(4, gRecord);

            //4
            int result = pstmt.executeUpdate();

            //5
            if(result > 0) {
                System.out.println(green + "{ 전적 변경 성공! }" + exit);
                System.out.println();
            } else {
                System.out.println(red + "{ 전적 변경 실패 }" + exit);
                System.out.println();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //전적 생성 메소드
    public void createGrecord(String id, int menuLogin) {
        try {
            //1
            String sql = "INSERT INTO GRECORD VALUES(?, ?, 0, 0)";

            //2
            pstmt = con.prepareStatement(sql);

            //3
            pstmt.setString(1, id);
            pstmt.setInt(2, menuLogin);

            //4
            int result = pstmt.executeUpdate();

            if(result > 0) {
                System.out.println(green + "{ 생성 완료! }" + exit);
                System.out.println();
            } else {
                System.out.println(red + "{ 생성 실패 }" + exit);
                System.out.println();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //전적 확인 메소드
    public boolean checkGrecord(String id, int menuLogin) {
        boolean result = false;

        try {
            //1 유저가 선택한 게임의 전적이 존재하는지 검색
            String sql = "SELECT * FROM GRECORD WHERE GID=? AND GNUM=?";

            //2
            pstmt = con.prepareStatement(sql);

            //3
            pstmt.setString(1, id);
            pstmt.setInt(2, menuLogin);

            //4
            rs = pstmt.executeQuery();

            if (rs.next()) {
                result = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    //유저 정보 확인 메소드
    public void myData(String id) {
        try {
            //1 sql문 작성
            String sql = "SELECT * FROM GAMEUSER WHERE GID=?";

            //2 db준비
            pstmt = con.prepareStatement(sql);

            //3 데이터 입력
            pstmt.setString(1, id);

            //4 실행
            rs = pstmt.executeQuery();

            //5 결과
            if(rs.next()) {
                System.out.println();
                System.out.println();
                System.out.println("───────◇───────");
                System.out.println(red + " 아이디 : " + rs.getString(1));
                System.out.println(yellow + " 비밀번호 : " + rs.getString(2));
                System.out.println(green + " 닉네임 :  : " + rs.getString(3));
                System.out.println(cyan + " 티어 : " + getTier(rs.getString(4)));
                System.out.println(blue + " 경험치 : " + rs.getInt(5));
                System.out.println(purple + " 돈 : " + rs.getInt(6) + exit);
                System.out.println("───────◇───────");
                System.out.println();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //유저 티어 닉네임 확인 메소드
    private String getTier(String tier) {
        String result = null;

        try {
            //1
            String sql = "SELECT * FROM GAMETIER T, GAMEUSER U WHERE T.GTIER=U.GTIER AND T.GTIER=?";
            ResultSet r;

            //2
            pstmt = con.prepareStatement(sql);

            //3
            pstmt.setString(1, tier);

            //4
            r = pstmt.executeQuery();

            if(r.next()) {
                result = r.getString(2);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    //유저 전적 확인 메소드
    public void mySolely(String id) {
        try {
            //1
            String sql = "SELECT * FROM GRECORD R, GAME G WHERE R.GNUM=G.GNUM AND R.GID=? ORDER BY R.GNUM";

            //2
            pstmt = con.prepareStatement(sql);

            //3
            pstmt.setString(1, id);

            //4
            rs = pstmt.executeQuery();

            //5
            while(rs.next()) {

                //1
                sql = "SELECT GID, GNUM, RANK() OVER (ORDER BY VCOUNT-DCOUNT DESC) FROM (SELECT U.GID, R.GNUM, R.VCOUNT, R.DCOUNT FROM GAMEUSER U, GRECORD R WHERE U.GID=R.GID AND GNUM=?)";

                //2
                pstmt = con.prepareStatement(sql);

                //3
                pstmt.setInt(1, rs.getInt(2));

                //4
                ResultSet r = pstmt.executeQuery();

                //5
                System.out.println("─────────────────────");

                while(true) {
                    //각 row의 아이디 확인
                    if(r.next() && r.getString(1).equals(id)) {
                        switch (r.getInt(3)) {
                            case 1 :
                                System.out.println("게임 이름 : " + red + rs.getString(6) + exit);
                                break;
                            case 2 :
                                System.out.println("게임 이름 : " + green + rs.getString(6) + exit);
                                break;
                            case 3 :
                                System.out.println("게임 이름 : " + yellow + rs.getString(6) + exit);
                                break;
                            case 4 :
                                System.out.println("게임 이름 : " + rs.getString(6));
                        }
                        System.out.println("이긴 횟수 : " + rs.getInt(3));
                        System.out.println("진 횟수 : " + rs.getInt(4));
                        System.out.println("랭킹 : " + r.getInt(3) + "위");
                        break;
                    }
                }

                System.out.println("─────────────────────");

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //유저 돈 확인 및 차감 메소드
    public boolean gameMoney(String id, int gRecord) {
        boolean result;

        try {
            //1 유저 돈 차감 전 확인
            String sql = "SELECT * FROM GAMEUSER U, GAME G WHERE U.GID=? AND G.GNUM=?";

            //2
            pstmt = con.prepareStatement(sql);

            //3
            pstmt.setString(1, id);
            pstmt.setInt(2 , gRecord);

            //4
            rs = pstmt.executeQuery();

            //5
            if(rs.next() && rs.getInt(6)>=rs.getInt(10)) {
                //1 유저 돈 차감
                sql = "UPDATE (SELECT * FROM GAMEUSER U, GAME G WHERE U.GID=? AND G.GNUM=?) SET MONEY=MONEY-MGMONEY WHERE GID=?";

                //2
                pstmt = con.prepareStatement(sql);

                //3
                pstmt.setString(1, id);
                pstmt.setInt(2, gRecord);
                pstmt.setString(3, id);

                //4->5
                if(pstmt.executeUpdate()>0) {

                    //1 유저 돈 차감 후 결과
                    sql = "SELECT * FROM GAMEUSER U, GAME G WHERE U.GID=? AND G.GNUM=?";

                    //2
                    pstmt = con.prepareStatement(sql);

                    //3
                    pstmt.setString(1, id);
                    pstmt.setInt(2 , gRecord);

                    //4
                    rs = pstmt.executeQuery();

                    //5
                    if(rs.next()) {
                        System.out.println("────────────────────────────");
                        System.out.println(rs.getInt(10) + "원을 사용하셨습니다.");
                        System.out.println("잔액 : " + rs.getInt(6) + "원");
                        System.out.println("────────────────────────────");
                    }
                }
                result = true;
            } else {
                result = false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    //유저 돈 획득 메소드
    public void changeMoney(String gId, int gNum) {
        try {
            //1 현재 유저의 돈 확인
            int gameMoney=0;
            String sql = "SELECT MONEY FROM GAMEUSER WHERE GID=?";

            //2
            pstmt = con.prepareStatement(sql);

            //3
            pstmt.setString(1, gId);

            //4
            rs = pstmt.executeQuery();

            //5
            if(rs.next()) {
                gameMoney = rs.getInt(1);
            }

            //1 승리시 얻을 돈 확인
            sql = "SELECT PGMONEY FROM GAME WHERE GNUM=?";

            //2
            pstmt = con.prepareStatement(sql);

            //3
            pstmt.setInt(1, gNum);

            //4
            rs = pstmt.executeQuery();

            //5
            if(rs.next()) {
                //1 유저 돈 확득
                sql = "UPDATE GAMEUSER SET MONEY=MONEY+? WHERE GID=?";

                //2
                pstmt = con.prepareStatement(sql);

                //3
                pstmt.setInt(1, rs.getInt(1));
                pstmt.setString(2, gId);

                //4->5 유저 돈 출력
                if(pstmt.executeUpdate() > 0) {
                    System.out.println("─────────────────");
                    System.out.println("돈이 추가되었습니다.");
                    System.out.println("잔액 : " + (gameMoney + rs.getInt(1)));
                    System.out.println("─────────────────");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //티어 변경 메소드
    public void changeTier(String id) {
        try {
            //1
            String sql = "SELECT * FROM GAMETIER";

            //2
            pstmt = con.prepareStatement(sql);

            //3->4
            rs = pstmt.executeQuery();

            //5
            while(rs.next()) {
                if(getGameEXP(id) >= rs.getInt(3)) {
                    //1
                    sql = "UPDATE GAMEUSER SET GTIER=? WHERE GID=?";

                    //2
                    pstmt = con.prepareStatement(sql);

                    //3
                    pstmt.setInt(1, rs.getInt(1));
                    pstmt.setString(2, id);

                    //4->5
                    pstmt.executeUpdate();
                }
            }

            //while문으로 인한 커서이동이 많아져서 재부팅
            conClose();
            Connect();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //유저 경험치 확인 메소드
    public int getGameEXP(String id) {
        try {
            //1
            String sql = "SELECT GEXP FROM GAMEUSER WHERE GID=?";
            ResultSet result = null;

            //2
            pstmt = con.prepareStatement(sql);

            //3
            pstmt.setString(1, id);

            //4
            result = pstmt.executeQuery();

            //5
            if(result.next()) {
                return result.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    //경험치 변경 메소드
    public void setGameExp(String id, int menuLogin) {
        try {
            //1
            String sql = "SELECT GEXP FROM GAME WHERE GNUM=?";

            //2
            pstmt = con.prepareStatement(sql);

            //3
            pstmt.setInt(1, menuLogin);

            //4
            rs = pstmt.executeQuery();

            //5
            if(rs.next()) {
                //1
                sql = "UPDATE GAMEUSER SET GEXP=GEXP+? WHERE GID=?";

                //2
                pstmt = con.prepareStatement(sql);

                //3
                pstmt.setInt(1, rs.getInt(1));
                pstmt.setString(2, id);

                //4
                int result = pstmt.executeUpdate();

                //5
                if(result > 0) {
                    System.out.println();
                    System.out.println("\u001B[32m" + "경험치 변경 성공!" + "\u001B[0m");
                    System.out.println();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}