package de.ecspride.data;

public class User {
    private final String username;
    private Password pwd;
    
    public User(String username, String password) {
        super();
        this.username = username;
        this.pwd = new Password(password);
    }
    
    public Password getPwd() { return pwd; }
    
    public void setPwd(Password pwd) { this.pwd = pwd; }
    
    public String getUsername() { return username; }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1450032968000L;
    public static final String jlc$ClassType$jl7 =
      ("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" +
       "88WFK+IC8h9vQBswfBQAAA==");
}
