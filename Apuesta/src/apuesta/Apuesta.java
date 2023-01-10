package apuesta;

/**
 * Clase 'apuesta'
 * @author Admin 
 */
public class Apuesta {
	
	/**
	 * Variable para guardar el dinero disponible
	 */
    private int dineroDisp;
    /**
     * Variable para guardar los goles del equipo local
     */
    private final int golesLocal;
    /**
     * Variable para guardar los goles del equipo visitante
     */
    private final int golesVisitante;
    /**
     * Variable para guardar la cantidad apostada
     */
    private int apostado;

    /**
     * Constructor por defecto
     */
    public Apuesta() {
    	//Constructor que asigna a los atributos los valores por defecto
    	dineroDisp = 0;
    	golesLocal = 0;
    	golesVisitante = 0;
    }
    /**
     * Constructor con parámetros
     * @param dineroDisp Dinero disponible
     * @param golesLocal Goles del equipo local
     * @param golesVisitante Goles del equipo visitante                                                                                                         
     */
    public Apuesta(final int dineroDisp, final int golesLocal, final int golesVisitante) {
        this.dineroDisp = dineroDisp;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
        this.apostado = 0;
    }
    
   /**
    * Método para obtener el valor del dinero disponible
    * @return Devuelve el dinero disponible
    */
    public int getDineroDisp() {
        return dineroDisp;
    }
    
    /**
     * Método para modificar el valor del atributo dineroDisponible
     * @param dineroDisp Usa el valor del parametro dieroDisponible
     */
    public void setDineroDisp(final int dineroDisp) {
        this.dineroDisp = dineroDisp;
    }

    /**
     * Método para apostar. 
     * Permite elegir la cantidad a apostar.
     * No puede ser inferior a 1 ni superior al saldo disponible
     * @param dinero Usa el valor del parametro dinero
     * @throws Exception Lanza una excepción
     */
    public void apostar(final int dinero) throws Exception {
        if (dinero <= 0) {
            throw new Exception("No se puede apostar menos de 10");
        }

        if (dinero > dineroDisp) {
            throw new Exception("No se puede apostar mas de lo que tienes");
        }
        {
            dineroDisp = dinero - dineroDisp;
            apostado = dinero;
        }
    }
    
/**
 * Método que comprueba si se ha acertado el resultado del partido. 
 * En caso positivo, devuelve true. Comprueba que no se metan menos de 0 goles.
 * @param local Usa el valor del parametro local
 * @param visitante Usa el valor del parametro visitante
 * @return Devuelve si se ha acertado o no el resultado
 * @throws Exception Lanza una excepción
 */ 
    public boolean comprobarResult(final int local, final int visitante) throws Exception {
        boolean acertado = false;
        if (local < 0 || (visitante) < 0) {
            throw new Exception("Un equipo no puede meter menos de 0 goles, por malo que sea");
        }

        if (golesLocal == local && golesVisitante == visitante) {
            acertado = true;
        }
        return acertado;
    }
    
    /**
     * Método para cobrar la apuesta.
     * Comprueba que se acerto el resultado y, en ese caso, 
     * añade el valor apostado multipliado por 10 al saldo disponible
     * @param golesLocal Usa el valor del parametro golesLocal
     * @param golesVisitante Usa el valor del parametro golesVisitante
     * @throws Exception Lanza una excepción
     */
    void cobrarApuesta(final int golesLocal, final int golesVisitante) throws Exception {

        if (!comprobarResult(golesLocal, golesVisitante)) {
            throw new Exception("No se puede cobrar una apuesta no acertada");
        }
        dineroDisp = dineroDisp * 10;

    }
}