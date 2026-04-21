package com.lxp.curi.service;

import com.lxp.config.JDBCConnection;
import com.lxp.curi.model.Curi;
import com.lxp.curi.repository.CuriRepository;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CuriService {

    private final CuriRepository curiRepository;
    private final Connection connection;

    public CuriService() {
        try {
            this.connection = JDBCConnection.getConnection();
            this.curiRepository = new CuriRepository(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Curi> lxpFindAll() throws Exception {
        List<Curi> curis = curiRepository.findAll();
        if (curis == null) {
            throw new Exception("커리큘럼을 조회하는데 실패했더요");
        } else {
            return curis;
        }
    }
}
