package giis.demo.util.io;

import java.util.ArrayList;
import java.util.List;
import giis.demo.tkrun.EnvioEntity;
import giis.demo.util.argumentchecks.ArgumentChecks;
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

	private EnvioEntity parseEnvio(String line) throws LineFormatException {
		ArgumentChecks.isNotNull(line, "Línea no encontrada!");
		ArgumentChecks.isTrue(!line.isEmpty(), "Línea en blanco!");
		
		String[] tokens = line.split(";");
		String nombreEmisor = tokens[0];
		String correoEmisor = tokens[1];
		String direccionEmisor = tokens[2];
		String nombreReceptor = tokens[3];
		String correoReceptor = tokens[4];
		String direccionReceptor = tokens[5];
		
		double largo = parseDouble(tokens[6]);
		double ancho = parseDouble(tokens[7]);
		double alto = parseDouble(tokens[8]);
		double peso = parseDouble(tokens[9]);
		double precio = parseDouble(tokens[10]);

		String instrExtra = tokens[11];
		
		return new EnvioEntity(nombreEmisor, correoEmisor, direccionEmisor, nombreReceptor, 
				correoReceptor, direccionReceptor, largo, ancho, alto, peso, precio, instrExtra);
	}

	private double parseDouble(String value) throws LineFormatException {
		try {
			return Double.parseDouble(value);
		} catch(NumberFormatException e) {
			throw new LineFormatException("No se pudo parsear el dato " + value +" a precisión doble");
		}
	}

}
