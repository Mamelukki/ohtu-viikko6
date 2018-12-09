package statistics.matcher;

public class QueryBuilder {

    private Matcher matcher;

    public QueryBuilder() {
        matcher = new All();
    }

    public Matcher build() {
        Matcher returnMatcher = matcher;
        this.matcher = new All();
        return returnMatcher;
    }

    public QueryBuilder playsIn(String team) {
        matcher = new And(matcher, new PlaysIn(team));
        return this;
    }

    public QueryBuilder hasAtLeast(int number, String category) {
        matcher = new And(matcher, new HasAtLeast(number, category));
        return this;
    }

    public QueryBuilder hasFewerThan(int number, String category) {
        matcher = new And(matcher, new HasFewerThan(number, category));
        return this;
    }

    public QueryBuilder oneOf(Matcher... matchers) {
        matcher = new Or(matchers);
        return this;
    }
}
