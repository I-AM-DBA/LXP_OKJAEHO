package com.lxp.curi.repository;

import com.lxp.curi.model.Curi;
import com.lxp.util.QueryUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CuriRepository {
    private final Connection connection;

    public CuriRepository(Connection connection) {
        this.connection = connection;
    }

    public List<Curi> findAll() {
        List<Curi> curis = new ArrayList<>();
        String sql = QueryUtil.getQuery("curi.allSelect");

        try (PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Curi curi = new Curi(rs.getLong("crui_no"), rs.getString("curi_name"),
                        rs.getString("depth1_name"), rs.getString("depth2_name"),
                        rs.getBoolean("success"), rs.getString("depth2_time"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return curis;
    }
}
