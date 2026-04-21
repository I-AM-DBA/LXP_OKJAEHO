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
                    System.out.println(curi);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
