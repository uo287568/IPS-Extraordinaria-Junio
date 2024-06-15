package giis.demo.util.io;

import java.util.ArrayList;
import java.util.List;

import giis.demo.tkrun.EnvioEntity;
import giis.demo.util.io.exception.LineFormatException;

public class ParserEmpresa {
	
	private int lineNum = 0;

	public List<EnvioEntity> parseLines(List<String> lineas) {
		List<EnvioEntity> resultado = new ArrayList<>();
		for(String linea: lineas) {
			try {
				lineNum++;
				resultado.add(parseEnvio(linea));
			} catch (LineFormatException e) {
				System.err.println("Linea " + lineNum + " no pudo ser parseada: " + e.getMessage());
			}
		}		
		return resultado;
	}

	private EnvioEntity parseEnvio(String linea) throws LineFormatException {
		// TODO Auto-generated method stub
		return null;
	}

}
