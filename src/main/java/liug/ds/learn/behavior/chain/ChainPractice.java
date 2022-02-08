package liug.ds.learn.behavior.chain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 正能量导师
 * @version 1.0
 * @description
 * @date 9/2/2022 上午1:46
 */
public class ChainPractice {

    public static abstract class Middleware{
        private static Middleware next;

        //构造一个责任链
        public Middleware linkwith(Middleware next) {
            this.next = next;
            return next;
        }

        public abstract boolean check(String email,String password);

        protected boolean checkNext(String email,String password){
            if (next == null) {
                return true;
            }
            return next.check(email, password);
        }
    }

    //检查请求数量限制
    public static class ThrottlingMiddleware extends Middleware{
        private int requestPerminute;
        private int request;
        private long currentTime;

        public ThrottlingMiddleware(int requestPerminute) {
            this.requestPerminute = requestPerminute;
            this.currentTime = System.currentTimeMillis();
        }

        @Override
        public boolean check(String email, String password) {
            if (System.currentTimeMillis() > currentTime+60_000){
                request = 0;
                currentTime = System.currentTimeMillis();
            }
            request++;

            if (request>requestPerminute){
                System.out.println("Request limit exceeded!");
                Thread.currentThread().stop();
            }
            return checkNext(email,password);
        }
    }

    public static class UserExistsMiddleware extends Middleware{
        private Server server;
        public UserExistsMiddleware(Server server) {
            this.server = server;
        }
        @Override
        public boolean check(String email, String password) {
            if (!server.hasEmail(email)) {
                System.out.println("This email is not registered!");
                return false;
            }
            if (!server.isValidPassword(email, password)) {
                System.out.println("Wrong password!");
                return false;
            }
            return checkNext(email, password);
        }
    }

    public static class RoleCheckMiddleware extends Middleware {
        public boolean check(String email, String password) {
            if (email.equals("admin@example.com")) {
                System.out.println("Hello, admin!");
                return true;
            }
            System.out.println("Hello, user!");
            return checkNext(email, password);
        }
    }

    public static class Server{
        private Map<String,String> users = new HashMap<>();
        private Middleware middleware;

        public void setMiddleware(Middleware middleware) {
            this.middleware = middleware;
        }

        public boolean logIn(String email, String password){
            if (middleware.checkNext(email,password)){
                System.out.println("Authorization have bean successful!");
                //...
                return true;
            }
            return false;
        }

        public void register(String email,String password){
            users.put(email,password);
        }

        public boolean hasEmail(String email){
            return users.containsKey(email);
        }

        public boolean isValidPassword(String email,String password){
            return users.get(email).equals(password);
        }
    }
    static Server server;
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void init(){
        server = new Server();
        server.register("admin@example.com", "admin_pass");
        server.register("user@example.com", "user_pass");

        Middleware middleware = new ThrottlingMiddleware(2);
        middleware.linkwith(new UserExistsMiddleware(server))
                .linkwith(new RoleCheckMiddleware());

        server.setMiddleware(middleware);
    }

    public static void main(String[] args) throws IOException {
        init();
        boolean success;
        do{
            System.out.println("Enter email:");
            String email = reader.readLine();
            System.out.println("Input password:");
            String password = reader.readLine();
            success = server.logIn(email,password);
        }while (!success);

    }
}
