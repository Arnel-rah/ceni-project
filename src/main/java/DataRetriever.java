import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class DataRetriever {

    long countAllVotes() {
        DBConnection dbConnection = new DBConnection();
        try (Connection conn = dbConnection.getConnection()) {
            String sql = "SELECT COUNT(id) AS total_votes FROM vote";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return rs.getLong("total_votes");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error counting votes: " + e.getMessage());
        }
        return 0;
    }

    List<VoterTypeCount> countVotesByType(){
        DBConnection dbConnection = new DBConnection();
    }

}
