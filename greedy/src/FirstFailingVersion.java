public class FirstFailingVersion {

    public static long firstBadVersion(long n, IsFailingVersion isBadVersion) {
        // TODO
        System.out.println(n);
        System.out.println(isBadVersion.isFailingVersion(n));
        if(isBadVersion.isFailingVersion(n)){
            return firstBadVersion(n/2, isBadVersion);
        }
        else{
            return cryingVersion(n*2,isBadVersion);
        }
    }


    public static long cryingVersion(long n, IsFailingVersion isBadVersion){
        if(isBadVersion.isFailingVersion(n)){
            return cryingVersion(n-100000000, isBadVersion);
        }
        else {
            return tears(n+100000000,isBadVersion);
        }
    }

    public static long tears(long n, IsFailingVersion isBadVersion){
        if(isBadVersion.isFailingVersion(n)){
            return tears(n-10000000, isBadVersion);
        }
        else {
            return stillSadVersion(n+10000000,isBadVersion);
        }
    }


    public static long stillSadVersion(long n, IsFailingVersion isBadVersion){
        if(isBadVersion.isFailingVersion(n)){
            return stillSadVersion(n-1000, isBadVersion);
        }
        else {
            return sadVersion(n+1000,isBadVersion);
        }
    }


    public static long sadVersion(long n, IsFailingVersion isBadVersion){
        if(isBadVersion.isFailingVersion(n)){
            return sadVersion(n-1, isBadVersion);
        }
        else {
            return n+1;
        }
    }
}
