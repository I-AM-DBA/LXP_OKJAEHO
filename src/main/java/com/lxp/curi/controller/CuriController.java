package com.lxp.curi.controller;

import com.lxp.curi.model.Curi;
import com.lxp.curi.service.CuriService;
import java.util.List;

public class CuriController {
    private CuriService curiService = new CuriService();

    public void allComeOn() {
        try {
            List<Curi> curis = curiService.lxpFindAll();
            if (curis.isEmpty()) {
                System.out.println("커리큘럼이 없습니다 ㅠㅠ");
            } else {
                for (Curi curi : curis) {
                    // String status = curi.isSuccess() ? "✅완료" : "⏳진행중";
                    //
                    // System.out.printf("%-4d | %-15s | %-12s | %-18s | %-6s | %-5s%n",
                    //         curi.getCuriNo(), curi.getCurriName(), curi.getDepth1Name(),
                    //         curi.getDepth2Name(), status, curi.getDepth2Time());
                    Long no = curi.getCuriNo();
                    String name = curi.getCurriName();
                    String d1 = curi.getDepth1Name();
                    String d2 = curi.getDepth2Name();
                    String success = curi.isSuccess() ? "완료" : "미완료";
                    String time = curi.getDepth2Time();
                    System.out.println(
                            no + "번 | " + name + " | " + d1 + " | " + d2 + " | " + success + " | "
                                    + time);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
