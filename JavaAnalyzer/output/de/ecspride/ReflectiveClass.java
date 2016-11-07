package de.ecspride;

public class ReflectiveClass {
    private String imei = "";
    
    public void setImei(String imei) { this.imei = imei; }
    
    public String getImei() { return this.imei; }
    
    public ReflectiveClass() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.1";
    public static final long jlc$SourceLastModified$jl7 = 1450032968000L;
    public static final String jlc$ClassType$jl7 =
      ("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" + "AAA=");
}
