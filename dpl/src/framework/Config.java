package framework;

/**
 * This code may be modified and used for non-commercial 
 * purposes as long as attribution is maintained.
 * 
 * @author: Isaac Levy
 */

//package ut.distcomp.framework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Properties;
import java.util.logging.Logger;

public class Config {

	/**
	 * Loads config from a file.  Optionally puts in 'procNum' if in file.
	 * See sample file for syntax
	 * @param filename
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public Config(String filename) throws FileNotFoundException, IOException {
		logger = Logger.getLogger("NetFramework");

		Properties prop = new Properties();
		prop.load(new FileInputStream(filename));
		numProcesses = loadInt(prop,"NumProcesses");	//numProcesses is an integer
		
		System.out.println("NumProcesses "+numProcesses);
		
		addresses = new InetAddress[numProcesses+1];	//addresses is an array
		ports = new int[numProcesses+1];				//ports is an array
		for (int i=0; i < numProcesses+1; i++) {
			//System.out.println("port"+i);
			ports[i] = loadInt(prop, "port" + i);
			//System.out.println("host"+i);
			addresses[i] = InetAddress.getByName(prop.getProperty("host" + i).trim());
		}
		if (prop.getProperty("ProcNum") != null) {
			procNum = loadInt(prop,"ProcNum");		//there is an error here
                        System.out.println("I am Proc:"+procNum);
		} else {
			logger.info("procNum not loaded from file");
		}
                //if (prop.getProperty("logfile") != null) {
                        log3pcfile = prop.getProperty("logfile");
                        uplistfile = prop.getProperty("uplistfile");
                //}
	}
	
	private int loadInt(Properties prop, String s) {
		return Integer.parseInt(prop.getProperty(s.trim()));
	}
	
	/**
	 * Default constructor for those who want to populate config file manually
	 */
	public Config() {
	}

	/**
	 * Array of addresses of other hosts.  All hosts should have identical info here.
	 */
	public InetAddress[] addresses;
	

	/**
	 * Array of listening port of other hosts.  All hosts should have identical info here.			//initially only the coordinator knows others??
	 */
	public int[] ports;
	
	/**
	 * Total number of hosts
	 */
	public int numProcesses;
	
	/**
	 * This hosts number (should correspond to array above).  Each host should have a different number.
	 */
	public int procNum;
	
	/**
	 * Logger.  Mainly used for console printing, though be diverted to a file.
	 * Verbosity can be restricted by raising level to WARN
	 */
	public Logger logger;
        
        public String log3pcfile;
        
        public String uplistfile;
}
