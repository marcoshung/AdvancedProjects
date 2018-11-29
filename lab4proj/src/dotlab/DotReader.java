package dotlab;

import java.io.*;

public class DotReader {
	private BufferedReader br;
	
	public DotReader(BufferedReader br){
		this.br = br;
	}
	
	public Dot readDot() throws IOException, DotException {
		String input = br.readLine();
		if(input != null) {
			String[] variables = input.split(",");
			if(variables.length != 4) {
				throw new DotException("Wrong number of variables entered");
			}
			return new Dot(variables[0],Integer.parseInt(variables[1]),Integer.parseInt(variables[2]),Integer.parseInt(variables[3]));
		}else {
			return null;
		}
		
	}
}
