package tool.compiler.java;

public class Main {

	public static void main(String[] args) {
	      polyglot.main.Main polyglotMain = new polyglot.main.Main();

	      try {
	    	  // For Java 7
	          //polyglotMain.start(args, new polyglot.ext.jl7.JL7ExtensionInfo());
	    	  
	    	  // For Java 7 plus an extra compilation pass
	    	  polyglotMain.start(args, new ExtensionInfo());
	      }
	      catch (polyglot.main.Main.TerminationException e) {
	          System.err.println(e.getMessage());
	          System.exit(1);
	      }
	}

}
