package darkroom.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class HostsIO {
	private File hosts;
	private BufferedReader bufHostsIn;
	private BufferedWriter bufHostsOut;
	private File temp;
	private BufferedReader bufTempIn;
	private BufferedWriter bufTempOut;
	private File list;
	private BufferedReader bufListIn;
	
	public HostsIO() {
		init();
	}
	
	private void init() {
		// File objects
		hosts = new File("hosts"); // TODO should be "/etc/hosts"
		list = new File("list"); // TODO should be "/usr/share/darkroom/list"
		// Create temp file
		try {
			temp = File.createTempFile("darkroom-host-", "");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		temp.deleteOnExit();
	}
	
	public void writeHosts(boolean lock) {
		
		boolean skip = false;
		
		String line = "";
		
		// Buffered reader and writer
		try {
			bufHostsIn = new BufferedReader(new FileReader(hosts));
			bufTempOut = new BufferedWriter(new FileWriter(temp));
			bufListIn = new BufferedReader(new FileReader(list));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		do {
			// Read original hosts file
			try {
				line = bufHostsIn.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(line==null) {
				break;
			}
			
			if(line.startsWith("#DarkRoomStart")) {
				skip = true;
			}
			
			if(!skip) {
				try {
					bufTempOut.write(line);
					bufTempOut.newLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			
			if(line.startsWith("#DarkRoomE")) {
				skip = false;
			}
			
		} while(line != null);
		
		// Add lock
		if(lock) {
			do {
				// Read block list file
				try {
					line = bufListIn.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				if(line==null) {
					break;
				}
				// Write into temp hosts file
				try {
					bufTempOut.write(line);
					bufTempOut.newLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} while(line != null);
		}
		// Close file IO
		try {
			bufListIn.close();
			bufHostsIn.close();
			bufTempOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Buffered reader and writer
		try {
			bufHostsOut = new BufferedWriter(new FileWriter(hosts));
			bufTempIn = new BufferedReader(new FileReader(temp));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Transfer content of temp file to hosts
		line = null;
		do {
			// Read temp file
			try {
				line = bufTempIn.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			// Write into hosts file
			System.out.println(line);
			if(line==null) {
				break;
			}
			try {
				bufHostsOut.write(line);
				bufHostsOut.newLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} while (line != null);
		
		// Close file IO
		try {
			bufHostsOut.close();
			bufTempIn.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
