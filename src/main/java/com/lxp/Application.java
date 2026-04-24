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
                    Application.specialFunctions(sc);

                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void specialFunctions(Scanner sc) throws Exception {
        System.out.println("특별 기능을 시작합니다!");

        while (true) {
            System.out.println("특별 기능을 선택해주세요. 뒤로 가려면 back을 입력하세요. (1. 생성 2. 강의조회)");
            System.out.print("입력 : ");

            String command = sc.nextLine();

            if (command.equals("back")) {
                System.out.println("뒤로 돌아갑니다~");
                break;
            } else if (command.equals("1")) {
                System.out.print("강의명을 입력하세요. :");
                String courseName = sc.nextLine();

                System.out.print("섹션명을 입력하세요. :");
                String sectionName = sc.nextLine();

                System.out.print("컨텐츠명을 입력하세요.");
                String contentName = sc.nextLine();

                System.out.print("컨텐츠 설명을 입력하세요.");
                String contentData = sc.nextLine();

                courseController.courseInsert(courseName, sectionName, contentName, contentData);
            }
        }
    }

    private static void course(String courseName) {

    }
}

