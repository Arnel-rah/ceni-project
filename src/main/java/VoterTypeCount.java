import java.util.Objects;

public class VoterTypeCount {
    private VoteType voteType;
    private int count;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        VoterTypeCount that = (VoterTypeCount) o;
        return count == that.count && voteType == that.voteType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(voteType, count);
    }

    @Override
    public String toString() {
        return "VoteTypeCount(voteType=" + voteType + ", count=" + count + ")";
    }

    public VoterTypeCount(VoteType voteType, int count) {
        this.voteType = voteType;
        this.count = count;
    }

    public VoteType getVoteType() {
        return voteType;
    }

    public void setVoteType(VoteType voteType) {
        this.voteType = voteType;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
