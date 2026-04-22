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
        String sql = QueryUtil.getQuery("curri.allSelect");

        try (PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Curi curi = new Curi(rs.getLong("curri_no"), rs.getString("curri_name"),
                        rs.getString("depth1_name"), rs.getString("depth2_name"),
                        rs.getBoolean("success"), rs.getString("depth2_time"));
                curis.add(curi);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return curis;
    }
}
