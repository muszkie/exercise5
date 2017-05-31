package wdsr.exercise5.dao;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import wdsr.exercise5.model.Trade;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.util.Optional;

@Repository
public class TradeDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * Zaimplementuj metode insertTrade aby wstawiała nowy rekord do tabeli "trade"
     * na podstawie przekazanego objektu klasy Trade.
     * @param trade
     * @return metoda powinna zwracać id nowego rekordu.
     */
    public int insertTrade(Trade trade) {
    	
    	KeyHolder keyHolder = new GeneratedKeyHolder();
    	jdbcTemplate.update(new PreparedStatementCreator() {
    		@Override
    		public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement stpre = con.prepareStatement("Insert INTO trade (asset, amount, date) VALUES (?,?,?)",Statement.RETURN_GENERATED_KEYS);
				stpre.setString(1,trade.getAsset());
				stpre.setDouble(2,trade.getAmount());
				stpre.setDate(3,new java.sql.Date(trade.getDate().getTime()));
				return stpre;
    			}
				}, keyHolder);
    	        
		
        return keyHolder.getKey().intValue();
    }

    /**
     * Zaimplementuj metode aby wyciągneła z bazy rekord o podanym id.
     * Użyj intrfejsu RowMapper.
     * @param id
     * @return metaoda powinna zwracać obiekt reprezentujący rekord o podanym id.
     */
    public Optional<Trade> extractTrade(int id) {
    	String sql = "SELECT * FROM trade WHERE id = " +id;
    	
        Trade result = jdbcTemplate.queryForObject(sql,
        		(rs, rowNum) -> {
        			Trade trade = null;
        			trade = new Trade(id, rs.getString(2), rs.getDouble(3), rs.getDate(4));
        			return trade;        			
        		});
        if (result == null) {
        	return Optional.empty();
        }
        		
        	
        
        return Optional.of(result);
    }

    /**
     * Zaimplementuj metode aby wyciągneła z bazy rekord o podanym id.
     * @param id, rch - callback który przetworzy wyciągnięty wiersz.
     * @return metaoda powinna zwracać obiekt reprezentujący rekord o podanym id.
     */
    public void extractTrade(int id, RowCallbackHandler rch) {
        // TODO
    	jdbcTemplate.query(new PreparedStatementCreator() {
    		@Override
    		public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement stpre = con.prepareStatement("SELECT * FROM trade WHERE id = ?");
				stpre.setInt(1,id);
				return stpre;
    			}
				}, rch);
    }

    /**
     * Zaimplementuj metode aby zaktualizowała rekord o podanym id danymi z przekazanego parametru 'trade'
     * @param trade
     */
    public void updateTrade(int id, Trade trade) {
        // TODO
    	String sql = "UPDATE trade SET asset =?, amount =? , date=? WHERE id= ?";
    	jdbcTemplate.update(new PreparedStatementCreator() {
    		@Override
    		public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement stpre = con.prepareStatement(sql);
				stpre.setString(1,trade.getAsset());
				stpre.setDouble(2,trade.getAmount());
				stpre.setDate(3,new java.sql.Date(trade.getDate().getTime()));
				stpre.setInt(4,id);
				return stpre;
    			}
				});
    }

    /**
     * Zaimplementuj metode aby usuwała z bazy rekord o podanym id.
     * @param id
     */
    public void deleteTrade(int id) {
        // TODO
    	String sql = "DELETE FROM trade WHERE id="+id;
    	jdbcTemplate.update(sql);
    	
    }

}
