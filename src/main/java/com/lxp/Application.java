package com.lxp;

import com.lxp.config.JDBCConnection;
import com.lxp.course.controller.CourseController;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Application {
    private static CourseController courseController = new CourseController();

    public static void main(String[] args) {
        try (Connection connection = JDBCConnection.getConnection();
                Scanner sc = new Scanner(System.in)) {
            System.out.println("연결 성공~" + connection);

            while (true) {
                System.out.println("1. 강의 전체 조회");
                System.out.println("2. 강의 입력");
                System.out.println("종료 시 exit");

                System.out.print("명령어를 입력하세요 : ");
                String command = sc.nextLine();

                if (command.equals("exit")) {
                    System.out.println("종료합니다");
                    break;
                } else if (command.equals("1")) {
                    System.out.println("강의 전체를 조회합니다.");
                    courseController.allComeOn();
                } else if (command.equals("2")) {
                    System.out.println("커리큘럼을 입력합니다.");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

