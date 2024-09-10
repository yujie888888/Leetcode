package Topic_ClassDesign;
import java.util.HashMap;

class AuthenticationManager {
    int timeToLive;
    HashMap<String,Integer> tokens;

    public AuthenticationManager(int timeToLive) {
        tokens = new HashMap<>();
        this.timeToLive = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
        tokens.put(tokenId,currentTime);
    }

    public void renew(String tokenId, int currentTime) {
        if(tokens.containsKey(tokenId)){
            if(currentTime - tokens.get(tokenId) < timeToLive){
                tokens.put(tokenId, currentTime);
            }
            else{
                tokens.remove(tokenId);
            }
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        int res = 0;
        for(String id : tokens.keySet()){
            if(currentTime - tokens.get(id) < timeToLive){
                res++;
            }
        }
        return res;
    }
}

public class P1797_DesignAuthenticationManager {
    public static void main(String[] args) {
        AuthenticationManager manager = new AuthenticationManager(5);
        manager.renew("aaa",1);
        manager.generate("aaa",2);
        System.out.println(manager.countUnexpiredTokens(4));
    }
}
