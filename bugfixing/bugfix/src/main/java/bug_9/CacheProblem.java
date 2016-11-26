package bug_9;


//????????????)))
public class CacheProblem {
    String cache;
    //String cache = "cache"; //variant 1

    public static void main(String[] args) {
        final CacheProblem cacheProblem = new CacheProblem();
        //cacheProblem.cache = "cache"; //variant 2
        cacheProblem.fullCacheInformation(cacheProblem.getCache());
        System.out.println(cacheProblem.cache.equals("cache"));//hould be true, please provide few variants to fix this problem,
        //System.out.println(cacheProblem.cache.startsWith("cache")); //variant 5 with @line 21-23
    }


    public void fullCacheInformation(String cache) {
        this.cache = "cacheInfo";
    }
    //public void fullCacheInformation(String cache) {
    //    this.cache = "cacheInfo";
    //} //varian 5 with @line 14
    //public void fullCacheInformation(String cache) {
    //    this.cache = "cache";
    //} //variant 3

    //public void fullCacheInformation(String cache) {
    //    this.cache = cache;
    //} //variant 4 as combination with variantD 1 or 2


    public String getCache() {
        return cache;
    }

    public void setCache(String cache) {
        this.cache = cache;
    }
}
