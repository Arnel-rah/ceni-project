import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
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

    List<VoterTypeCount> countVotesByType() {
        List<VoterTypeCount> voterTypeCounts = new ArrayList<>();
        DBConnection db = new DBConnection();
        try (Connection con = db.getConnection()) {
            String sql = "SELECT vote_type, COUNT(id) AS total_votes FROM vote GROUP BY vote_type";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                VoteType voteType = VoteType.valueOf(rs.getString("vote_type"));
                int totalVotes = rs.getInt("total_votes");
                VoterTypeCount voterTypeCount = new VoterTypeCount(voteType, totalVotes);
                voterTypeCounts.add(voterTypeCount);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error Connection: " + e.getMessage());
        }
        return voterTypeCounts;
    }

    List<CandidateVoteCount> countValidVotesByCandidate() {
        List<CandidateVoteCount> candidateVoteCounts = new ArrayList<>();
        DBConnection db = new DBConnection();
        try (Connection con = db.getConnection()) {
            String sql = """
                SELECT c.name, COUNT(v.id) AS valid_votes
                FROM candidate c
                LEFT JOIN vote v ON c.id = v.candidate_id AND v.vote_type = 'VALID'
                GROUP BY c.name
                """;
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String candidateName = rs.getString("name");
                    int validVotes = rs.getInt("valid_votes");
                    candidateVoteCounts.add(new CandidateVoteCount(candidateName, validVotes));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error Connection: " + e.getMessage());
        }
        return candidateVoteCounts;
    }

    VoteSummary computeVoteSummary(){

    }

}
