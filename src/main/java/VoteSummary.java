import java.util.Objects;

public class VoteSummary {
    private int validCount;
    private int blackCount;
    private int nullCount;

    public VoteSummary(int validCount, int blankCount, int nullCount) {
        this.validCount = validCount;
        this.blackCount = blankCount;
        this.nullCount = nullCount;
    }

    public int getValidCount() {
        return validCount;
    }

    public void setValidCount(int validCount) {
        this.validCount = validCount;
    }

    public int getBlackCount() {
        return blackCount;
    }

    public void setBlackCount(int blackCount) {
        this.blackCount = blackCount;
    }

    public int getNullCount() {
        return nullCount;
    }

    public void setNullCount(int nullCount) {
        this.nullCount = nullCount;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        VoteSummary that = (VoteSummary) o;
        return validCount == that.validCount && blackCount == that.blackCount && nullCount == that.nullCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(validCount, blackCount, nullCount);
    }


    @Override
    public String toString() {
        return "VoteSummary{" +
                "validCount=" + validCount +
                ", blackCount=" + blackCount +
                ", nullCount=" + nullCount +
                '}';
    }

}
